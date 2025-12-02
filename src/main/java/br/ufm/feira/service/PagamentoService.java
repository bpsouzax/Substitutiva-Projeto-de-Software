package br.ufm.feira.service;
public class PagamentoService {
    public boolean processarPagamento(String cartao, double valor) {
        System.out.println("(Simulated) Processando pagamento com cartao: " + cartao + " valor: " + valor);
        return true;
    }
}
