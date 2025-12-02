package br.ufm.feira.controller;
import br.ufm.feira.model.*;
import br.ufm.feira.repository.*;
import br.ufm.feira.service.*;
import java.util.*;
public class AssinaturaController {
    private PlanoRepository planoRepo;
    private ProdutoRepository produtoRepo;
    private SMSService sms;
    private PagamentoService pagamento;
    public AssinaturaController(PlanoRepository pr, ProdutoRepository prod, SMSService sms, PagamentoService pay) {
        this.planoRepo = pr; this.produtoRepo = prod; this.sms = sms; this.pagamento = pay;
    }
    public String iniciarFluxo(Scanner in) {
        System.out.print("Informe seu celular: ");
        String celular = in.nextLine().trim();
        String code = sms.sendCode(celular);
        System.out.print("Informe o codigo recebido por SMS: ");
        String codeRecebido = in.nextLine().trim();
        if (!code.equals(codeRecebido)) { System.out.println("Codigo invalido. Abortando."); return null; }
        System.out.println("Planos disponiveis:");
        for (Plano p: planoRepo.getAll()) System.out.println(p);
        System.out.print("Escolha id do plano: ");
        String pid = in.nextLine().trim();
        Plano plano = planoRepo.findById(pid);
        if (plano == null) { System.out.println("Plano invalido"); return null; }
        Cesta cesta = new Cesta(UUID.randomUUID().toString());
        System.out.println("Escolha frutas (ate " + plano.getMaxFrutas() + ") - ids separados por virgula");
        mostrarPorTipo(Produto.Tipo.FRUTA);
        String s = in.nextLine().trim();
        processarSelecao(s, plano.getMaxFrutas(), cesta, Produto.Tipo.FRUTA);
        System.out.println("Escolha legumes (ate " + plano.getMaxLegumes() + ") - ids separados por virgula");
        mostrarPorTipo(Produto.Tipo.LEGUME);
        s = in.nextLine().trim();
        processarSelecao(s, plano.getMaxLegumes(), cesta, Produto.Tipo.LEGUME);
        System.out.println("Escolha verduras (ate " + plano.getMaxVerduras() + ") - ids separados por virgula");
        mostrarPorTipo(Produto.Tipo.VERDURA);
        s = in.nextLine().trim();
        processarSelecao(s, plano.getMaxVerduras(), cesta, Produto.Tipo.VERDURA);
        System.out.println("Produtos na cesta:");
        System.out.println(cesta);
        System.out.println("Informe endereco (rua;numero;cidade;cep):");
        String endereco = in.nextLine().trim();
        String[] ep = endereco.split(";");
        Assinante assinante = new Assinante(UUID.randomUUID().toString(), "Cliente Teste", celular);
        if (ep.length >= 4) assinante.setEndereco(new Endereco(ep[0], ep[1], ep[2], ep[3]));
        System.out.println("Total da assinatura: R$ " + plano.getPreco());
        System.out.print("Informe numero do cartao: ");
        String cartao = in.nextLine().trim();
        boolean ok = pagamento.processarPagamento(cartao, plano.getPreco());
        if (!ok) { System.out.println("Pagamento recusado"); return null; }
        Assinatura as = new Assinatura(UUID.randomUUID().toString(), assinante, plano, cesta);
        System.out.println("Assinatura realizada com sucesso! Protocolo: " + as.getProtocolo());
        return as.getProtocolo();
    }
    private void mostrarPorTipo(Produto.Tipo tipo) {
        for (Produto p: produtoRepo.findByTipo(typeOf(tipo))) System.out.println(p);
    }
    private Produto.Tipo typeOf(Produto.Tipo t) { return t; }
    private void processarSelecao(String s, int max, Cesta cesta, Produto.Tipo tipo) {
        if (s.isEmpty()) return;
        String[] ids = s.split('[,;\\s]+');
        int count = 0;
        for (String id: ids) {
            if (count >= max) break;
            Produto p = produtoRepo.findById(id.trim());
            if (p != null && p.getTipo() == tipo) { cesta.adicionarItem(new ItemCesta(p, 1)); count++; }
        }
    }
}
