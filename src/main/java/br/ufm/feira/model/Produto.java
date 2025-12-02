package br.ufm.feira.model;
public class Produto {
    public enum Tipo { FRUTA, LEGUME, VERDURA }
    private String id;
    private String nome;
    private Tipo tipo;
    private int quantidadeDisponivel;
    public Produto(String id, String nome, Tipo tipo, int quantidadeDisponivel) {
        this.id = id; this.nome = nome; this.tipo = tipo; this.quantidadeDisponivel = quantidadeDisponivel;
    }
    public String getId() { return id; }
    public String getNome() { return nome; }
    public Tipo getTipo() { return tipo; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }
    @Override public String toString() {
        return String.format("%s - %s (%s) available: %d", id, nome, tipo, quantidadeDisponivel);
    }
}
