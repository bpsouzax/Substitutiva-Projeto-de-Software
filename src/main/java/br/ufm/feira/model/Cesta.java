package br.ufm.feira.model;
import java.util.ArrayList;
import java.util.List;
public class Cesta {
    private String id;
    private List<ItemCesta> itens = new ArrayList<>();
    public Cesta(String id) { this.id = id; }
    public void adicionarItem(ItemCesta it) { itens.add(it); }
    public List<ItemCesta> getItens() { return itens; }
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ItemCesta it : itens) sb.append(it.toString()).append("\\n");
        return sb.toString();
    }
}
