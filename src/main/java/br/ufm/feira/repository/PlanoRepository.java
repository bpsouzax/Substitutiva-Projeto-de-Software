package br.ufm.feira.repository;
import br.ufm.feira.model.Plano;
import java.util.*;
public class PlanoRepository {
    private Map<String, Plano> planos = new LinkedHashMap<>();
    public void addPlano(Plano p) { planos.put(p.getId(), p); }
    public Collection<Plano> getAll() { return planos.values(); }
    public Plano findById(String id) { return planos.get(id); }
}
