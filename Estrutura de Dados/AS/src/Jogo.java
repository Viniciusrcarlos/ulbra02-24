import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Jogo {
    private Tabuleiro tabuleiro;
    private List<Jogador> jogadores;
    private double salario;
    private int maxRodadas;

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.jogadores = new ArrayList<>();
    }

    public void configurarJogo(double saldoInicial, double salario, int maxRodadas) {
        this.salario = salario;
        this.maxRodadas = maxRodadas;
        for (Jogador jogador : jogadores) {
            jogador.saldo = saldoInicial;
        }
    }

    public void adicionarJogador(String nome) {
        jogadores.add(new Jogador(nome, 0));
    }

    public void adicionarCasa(Casa casa) {
        tabuleiro.adicionarCasa(casa);
    }

    public void iniciar() {
        if (jogadores.size() < 2 || tabuleiro.inicio == null) {
            System.out.println("Erro: Número insuficiente de jogadores ou casas no tabuleiro!");
            return;
        }

        for (Jogador jogador : jogadores) {
            jogador.posicaoAtual = tabuleiro.inicio;
        }

        System.out.println("\n=== Início do Jogo ===");
        tabuleiro.imprimirTabuleiro();

        Random dado = new Random();
        for (int rodada = 1; rodada <= maxRodadas; rodada++) {
            System.out.println("\n=== Rodada " + rodada + " ===");

            for (Jogador jogador : jogadores) {
                if (jogador.estaFalido()) {
                    System.out.println(jogador.nome + " está falido e será ignorado.");
                    continue;
                }

                int resultadoDado = dado.nextInt(6) + 1;
                System.out.println("\n" + jogador.nome + " jogou o dado: " + resultadoDado);

                movimentarJogador(jogador, resultadoDado);
                processarCasa(jogador);

                jogador.exibirStatus();
            }
        }

        finalizarJogo();
    }

    private void movimentarJogador(Jogador jogador, int passos) {
        for (int i = 0; i < passos; i++) {
            jogador.posicaoAtual = jogador.posicaoAtual.proxima;
        }
        System.out.println(jogador.nome + " parou na casa: " + jogador.posicaoAtual.nome);
    }

    private void processarCasa(Jogador jogador) {
        Casa casa = jogador.posicaoAtual;
        switch (casa.tipo) {
            case INICIO:
                jogador.atualizarSaldo(salario);
                System.out.println("Passou pelo início! Recebeu R$" + salario);
                break;
            case IMOVEL:
                if (casa.disponivelParaCompra()) {
                    if (jogador.saldo >= casa.valor) {
                        jogador.atualizarSaldo(-casa.valor);
                        casa.proprietario = jogador;
                        jogador.adicionarPropriedade(casa);
                        System.out.println("Comprou o imóvel: " + casa.nome);
                    } else {
                        System.out.println("Saldo insuficiente para comprar o imóvel!");
                    }
                } else if (casa.proprietario != jogador) {
                    double aluguel = casa.calcularAluguel();
                    jogador.atualizarSaldo(-aluguel);
                    casa.proprietario.atualizarSaldo(aluguel);
                    System.out.println("Pagou aluguel de R$" + aluguel + " para " + casa.proprietario.nome);
                }
                break;
            case IMPOSTO:
                double imposto = jogador.saldo * 0.05;
                jogador.atualizarSaldo(-imposto);
                System.out.println("Pagou imposto de R$" + imposto);
                break;
            case RESTITUICAO:
                double recompensa = salario * 0.1;
                jogador.atualizarSaldo(recompensa);
                System.out.println("Recebeu restituição de R$" + recompensa);
                break;
            case SORTE:
                double bonus = new Random().nextInt(200) + 50; // Bônus entre 50 e 250
                jogador.atualizarSaldo(bonus);
                System.out.println("Sorte! Ganhou R$" + bonus);
                break;
            case REVES:
                double perda = new Random().nextInt(200) + 50; // Perda entre 50 e 250
                jogador.atualizarSaldo(-perda);
                System.out.println("Revés! Perdeu R$" + perda);
                break;
        }
    }

    private void finalizarJogo() {
        Jogador vencedor = jogadores.stream()
                .filter(j -> !j.estaFalido())
                .max((j1, j2) -> Double.compare(j1.saldo, j2.saldo))
                .orElse(null);

        System.out.println("\n=== Fim do Jogo ===");
        if (vencedor != null) {
            System.out.println("Vencedor: " + vencedor.nome + " com saldo de R$" + vencedor.saldo);
        } else {
            System.out.println("Todos os jogadores faliram!");
        }
    }
}
