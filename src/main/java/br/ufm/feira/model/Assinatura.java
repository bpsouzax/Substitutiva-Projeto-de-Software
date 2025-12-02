package br.ufm.feira.model;
public class Assinatura {
    private String protocolo;
    private Assinante assinante;
    private Plano plano;
    private Cesta cesta;
    public Assinatura(String protocolo, Assinante a, Plano p, Cesta c) {
        this.protocolo = protocolo; this.assinante = a; this.plano = p; this.cesta = c;
    }
    public String getProtocolo() { return protocolo; }
}
