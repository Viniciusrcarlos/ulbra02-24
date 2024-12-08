import java.util.ArrayList;
import java.util.List;

class Jogadores {
    List<Jogador> listaJogadores;
    int saldoInicial;
    int salario;
    int maxRodadas;

    public Jogadores() {
        listaJogadores = new ArrayList<>();
    }

    public void definirConfiguracoesIniciais(int saldoInicial, int salario, int maxRodadas) {
        this.saldoInicial = saldoInicial;
        this.salario = salario;
        this.maxRodadas = maxRodadas;
    }

    public void cadastrarJogador(String nome, Casa posicaoInicial) {
        if (listaJogadores.size() < 6) {
            Jogador novoJogador = new Jogador(nome, saldoInicial, posicaoInicial);
            listaJogadores.add(novoJogador);
            System.out.println("Jogador cadastrado: " + nome);
        } else {
            System.out.println("Limite máximo de jogadores atingido.");
        }
    }

    public void listarJogadores() {
        for (Jogador jogador : listaJogadores) {
            System.out.println("Nome: " + jogador.nome + ", Saldo: " + jogador.saldo + ", Posição: " + jogador.posicaoAtual.nome);
        }
    }

    public void atualizarJogador(String nome, int novoSaldo, Casa novaPosicao) {
        for (Jogador jogador : listaJogadores) {
            if (jogador.nome.equals(nome)) {
                jogador.saldo = novoSaldo;
                jogador.posicaoAtual = novaPosicao;
                System.out.println("Jogador atualizado: " + nome);
                return;
            }
        }
        System.out.println("Jogador não encontrado: " + nome);
    }

    public void removerJogador(String nome) {
        Jogador jogadorARemover = null;
        for (Jogador jogador : listaJogadores) {
            if (jogador.nome.equals(nome)) {
                jogadorARemover = jogador;
                break;
            }
        }
        if (jogadorARemover != null) {
            listaJogadores.remove(jogadorARemover);
            System.out.println("Jogador removido: " + nome);
        } else {
            System.out.println("Jogador não encontrado: " + nome);
        }
    }

    public boolean validarJogadores() {
        return listaJogadores.size() >= 2;
    }

    public void jogarRodada(Tabuleiro tabuleiro) {
        for (Jogador jogador : listaJogadores) {
            int passos = tabuleiro.lancarDado();
            jogador.mover(passos);
            tabuleiro.interagirComCasa(jogador);
            exibirStatusJogador(jogador);
        }
    }

    public void exibirStatusJogador(Jogador jogador) {
        System.out.println("Nome: " + jogador.nome);
        System.out.println("Saldo: " + jogador.saldo);
        System.out.println("Posição: " + jogador.posicaoAtual.nome);
        System.out.println("Propriedades: " + jogador.propriedades);
        System.out.println("---------------------");
    }

    public Jogador obterVencedor() {
        Jogador vencedor = null;
        int maiorSaldo = 0;
        for (Jogador jogador : listaJogadores) {
            if (jogador.saldo > maiorSaldo) {
                maiorSaldo = jogador.saldo;
                vencedor = jogador;
            }
        }
        return vencedor;
    }
}
