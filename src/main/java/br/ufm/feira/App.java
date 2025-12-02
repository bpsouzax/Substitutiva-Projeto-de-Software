package br.ufm.feira;
import br.ufm.feira.repository.*;
import br.ufm.feira.service.*;
import br.ufm.feira.controller.*;
import java.util.Scanner;
import java.nio.file.Paths;
public class App {
    public static void main(String[] args) throws Exception {
        PlanoRepository planoRepo = new PlanoRepository();
        ProdutoRepository prodRepo = new ProdutoRepository();
        String base = Paths.get("resources").toAbsolutePath().toString();
        CSVLoader.loadPlanos(base + "/Plano.csv", planoRepo);
        CSVLoader.loadProdutos(base + "/Produto.csv", prodRepo);
        SMSService sms = new SMSService();
        PagamentoService pay = new PagamentoService();
        AssinaturaController ctrl = new AssinaturaController(planoRepo, prodRepo, sms, pay);
        System.out.println("=== Feira Subscription Demo ===");
        Scanner in = new Scanner(System.in);
        ctrl.iniciarFluxo(in);
        in.close();
    }
}
