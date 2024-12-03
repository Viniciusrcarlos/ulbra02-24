import java.util.HashMap;
import java.util.Map;

public class Cidade {
    String nome;
    Map<Cidade, Estrada> conexoes;

    public Cidade(String nome) {
        this.nome = nome;
        this.conexoes = new HashMap<>();
    }
}
