package br.ufm.feira.model;
public class Plano {
    private String id;
    private String nome;
    private double preco;
    private int maxFrutas;
    private int maxLegumes;
    private int maxVerduras;
    public Plano(String id, String nome, double preco, int maxFrutas, int maxLegumes, int maxVerduras) {
        this.id = id; this.nome = nome; this.preco = preco;
        this.maxFrutas = maxFrutas; this.maxLegumes = maxLegumes; this.maxVerduras = maxVerduras;
    }
    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getMaxFrutas() { return maxFrutas; }
    public int getMaxLegumes() { return maxLegumes; }
    public int getMaxVerduras() { return maxVerduras; }
    @Override public String toString() {
        return String.format("%s - %s (R$ %.2f) [F:%d L:%d V:%d]", id, nome, preco, maxFrutas, maxLegumes, maxVerduras);
    }
}
