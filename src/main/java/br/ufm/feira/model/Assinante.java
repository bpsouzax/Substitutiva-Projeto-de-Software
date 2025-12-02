package br.ufm.feira.model;
public class Assinante {
    private String id;
    private String nome;
    private String celular;
    private Endereco endereco;
    public Assinante(String id, String nome, String celular) {
        this.id = id; this.nome = nome; this.celular = celular;
    }
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getCelular() { return celular; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    @Override public String toString() { return String.format("%s - %s (%s)", id, nome, celular); }
}
