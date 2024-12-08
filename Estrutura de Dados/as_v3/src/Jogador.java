import java.util.ArrayList;
import java.util.List;

class Jogador {
    String nome;
    int saldo;
    Casa posicaoAtual;
    List<String> propriedades;

    public Jogador(String nome, int saldoInicial, Casa posicaoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
        this.posicaoAtual = posicaoInicial;
        this.propriedades = new ArrayList<>();
    }

    public void mover(int passos) {
        for (int i = 0; i < passos; i++) {
            posicaoAtual = posicaoAtual.proxima;
            if (posicaoAtual.nome.equals("Início")) {
                // Recebe salário ao passar pelo início
                saldo += 200;
                System.out.println(nome + " recebeu R$200 de salário.");
            }
        }
        System.out.println(nome + " moveu para a casa " + posicaoAtual.nome);
    }

    public void pagar(int valor) {
        saldo -= valor;
        System.out.println(nome + " pagou R$" + valor + ". Saldo atual: R$" + saldo);
    }

    public void receber(int valor) {
        saldo += valor;
        System.out.println(nome + " recebeu R$" + valor + ". Saldo atual: R$" + saldo);
    }

    public void comprarPropriedade(String propriedade) {
        propriedades.add(propriedade);
        System.out.println(nome + " comprou a propriedade " + propriedade);
    }
}
