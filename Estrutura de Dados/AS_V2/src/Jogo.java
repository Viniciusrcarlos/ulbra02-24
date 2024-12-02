import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    private Tabuleiro tabuleiro;
    private List<Jogador> jogadores;
    private int numeroMaximoRodadas;
    private double salarioJogador;

    public Jogo(double salarioJogador, int numeroMaximoRodadas) {
        this.tabuleiro = new Tabuleiro();
        this.jogadores = new ArrayList<>();
        this.numeroMaximoRodadas = numeroMaximoRodadas;
        this.salarioJogador = salarioJogador;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void adicionarJogador(String nome, double saldoInicial) {
        if (jogadores.size() < 6) {
            jogadores.add(new Jogador(nome, saldoInicial));
        } else {
            System.out.println("Número máximo de jogadores atingido!");
        }
    }

    public void adicionarCasa(String nome, String tipo, double precoCompra, double precoAluguel) {
        tabuleiro.adicionarCasa(nome, tipo, precoCompra, precoAluguel);
    }

    public void iniciarJogo() {
        if (tabuleiro.getTotalCasas() < 10 || jogadores.size() < 2) {
            System.out.println("O jogo não pode ser iniciado. Certifique-se de ter pelo menos 10 casas e 2 jogadores.");
            return;
        }

        System.out.println("Iniciando o jogo!");
        int rodada = 1;
        Random dado = new Random();

        while (rodada <= numeroMaximoRodadas) {
            System.out.println("\n--- Rodada " + rodada + " ---");

            for (Jogador jogador : jogadores) {
                if (jogador.getSaldo() <= 0) {
                    System.out.println(jogador.getNome() + " está falido e fora do jogo!");
                    continue;
                }

                int movimento = dado.nextInt(6) + 1;
                System.out.println(jogador.getNome() + " tirou " + movimento + " no dado.");

                moverJogador(jogador, movimento);

                Casa casaAtual = obterCasaAtual(jogador);
                interagirComCasa(jogador, casaAtual);
            }

            rodada++;
        }

        encerrarJogo();
    }

    private void moverJogador(Jogador jogador, int movimento) {
        Casa atual = tabuleiro.getInicio();
        for (int i = 0; i < jogador.getPosicao(); i++) {
            atual = atual.getProxima();
        }

        for (int i = 0; i < movimento; i++) {
            atual = atual.getProxima();
        }

        jogador.setPosicao(jogador.getPosicao() + movimento);
        if (atual == tabuleiro.getInicio()) {
            jogador.alterarSaldo(salarioJogador);
            System.out.println(jogador.getNome() + " passou pelo Início e recebeu R$ " + salarioJogador);
        }
    }

    private Casa obterCasaAtual(Jogador jogador) {
        Casa atual = tabuleiro.getInicio();
        for (int i = 0; i < jogador.getPosicao(); i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    private void interagirComCasa(Jogador jogador, Casa casa) {
        switch (casa.getTipo()) {
            case "Imóvel":
                if (casa.getPrecoCompra() > 0) {
                    System.out.println(jogador.getNome() + " parou em um imóvel disponível: " + casa.getNome());
                }
                break;
            case "Imposto":
                double imposto = jogador.getSaldo() * 0.05;
                jogador.alterarSaldo(-imposto);
                System.out.println(jogador.getNome() + " pagou R$ " + imposto + " de imposto.");
                break;
            case "Restituição":
                double restituicao = salarioJogador * 0.10;
                jogador.alterarSaldo(restituicao);
                System.out.println(jogador.getNome() + " recebeu uma restituição de R$ " + restituicao);
                break;
            default:
                System.out.println(jogador.getNome() + " parou em " + casa.getNome());
                break;
        }
    }

    private void encerrarJogo() {
        System.out.println("\n--- Fim do Jogo ---");
        Jogador vencedor = null;
        double maiorSaldo = 0;

        for (Jogador jogador : jogadores) {
            if (jogador.getSaldo() > maiorSaldo) {
                maiorSaldo = jogador.getSaldo();
                vencedor = jogador;
            }
        }

        if (vencedor != null) {
            System.out.println("O vencedor é " + vencedor.getNome() + " com saldo de R$ " + maiorSaldo);
        } else {
            System.out.println("Não houve vencedor.");
        }
    }
}
