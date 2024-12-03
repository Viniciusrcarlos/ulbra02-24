import java.util.*;

public class Grafo {
    Map<String, Cidade> cidades;

    public Grafo() {
        this.cidades = new HashMap<>();
    }

    public void adicionarCidade(String nome) {
        cidades.putIfAbsent(nome, new Cidade(nome));
    }

    public void adicionarEstrada(String origem, String destino, int distancia, int custo) {
        Cidade cidadeOrigem = cidades.get(origem);
        Cidade cidadeDestino = cidades.get(destino);

        if (cidadeOrigem != null && cidadeDestino != null) {
            cidadeOrigem.conexoes.put(cidadeDestino, new Estrada(distancia, custo));
            cidadeDestino.conexoes.put(cidadeOrigem, new Estrada(distancia, custo)); // Grafo não-direcionado
        }
    }

    public void removerEstrada(String origem, String destino) {
        Cidade cidadeOrigem = cidades.get(origem);
        Cidade cidadeDestino = cidades.get(destino);

        if (cidadeOrigem != null && cidadeDestino != null) {
            cidadeOrigem.conexoes.remove(cidadeDestino);
            cidadeDestino.conexoes.remove(cidadeOrigem);
        }
    }

    public List<String> calcularRota(String origem, String destino, int limiteCusto, boolean menorDistancia) {
        // Implementar algoritmo de otimização de rotas
        return new ArrayList<>();
    }
}
