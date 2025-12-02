package br.ufm.feira.service;
import br.ufm.feira.model.Plano;
import br.ufm.feira.model.Produto;
import br.ufm.feira.repository.PlanoRepository;
import br.ufm.feira.repository.ProdutoRepository;
import java.nio.file.*;
import java.util.*;
public class CSVLoader {
    public static void loadPlanos(String path, PlanoRepository repo) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String ln: lines) {
            if (ln.trim().isEmpty()) continue;
            String[] parts = ln.split(";");
            if (parts.length < 6) continue;
            Plano p = new Plano(parts[0], parts[1], Double.parseDouble(parts[2].replace(",", ".")),
                    Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
            repo.addPlano(p);
        }
    }
    public static void loadProdutos(String path, ProdutoRepository repo) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String ln: lines) {
            if (ln.trim().isEmpty()) continue;
            String[] parts = ln.split(";");
            if (parts.length < 4) continue;
            Produto.Tipo t = Produto.Tipo.valueOf(parts[2].toUpperCase());
            Produto p = new Produto(parts[0], parts[1], t, Integer.parseInt(parts[3]));
            repo.add(p);
        }
    }
}
