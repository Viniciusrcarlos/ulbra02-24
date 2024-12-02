import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private double saldo;
    private int posicao;
    private List<Casa> propriedades;

    public Jogador(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
        this.posicao = 0; // Começa no início do tabuleiro
        this.propriedades = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public List<Casa> getPropriedades() {
        return propriedades;
    }

    public void adicionarPropriedade(Casa propriedade) {
        this.propriedades.add(propriedade);
    }

    public void alterarSaldo(double valor) {
        this.saldo += valor;
    }

    public void exibirStatus() {
        System.out.println("Jogador: " + nome);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Posição no tabuleiro: " + posicao);
        System.out.println("Propriedades:");
        for (Casa propriedade : propriedades) {
            System.out.println("- " + propriedade.getNome());
        }
    }
}
