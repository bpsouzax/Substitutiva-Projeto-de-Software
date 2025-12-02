package br.ufm.feira.repository;
import br.ufm.feira.model.Produto;
import java.util.*;
public class ProdutoRepository {
    private Map<String, Produto> produtos = new LinkedHashMap<>();
    public void add(Produto p) { produtos.put(p.getId(), p); }
    public Collection<Produto> getAll() { return produtos.values(); }
    public Produto findById(String id) { return produtos.get(id); }
    public List<Produto> findByTipo(Produto.Tipo tipo) {
        List<Produto> r = new ArrayList<>();
        for (Produto p: produtos.values()) if (p.getTipo() == tipo) r.add(p);
        return r;
    }
}
