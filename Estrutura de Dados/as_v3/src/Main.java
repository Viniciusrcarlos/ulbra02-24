public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogadores jogadores = new Jogadores();

        jogadores.definirConfiguracoesIniciais(1000, 200, 200000);

        // Cadastro de imóveis
        tabuleiro.cadastrarImovel("Imóvel 1", 200000, 1100);
        tabuleiro.cadastrarImovel("Imóvel 2", 350000, 1800);
        tabuleiro.cadastrarImovel("Imóvel 3", 400000, 2200);
        tabuleiro.cadastrarImovel("Imóvel 4", 500000, 2700);
        tabuleiro.cadastrarImovel("Imóvel 5", 600000, 3300);
        tabuleiro.cadastrarImovel("Imóvel 6", 450000, 2500);
        tabuleiro.cadastrarImovel("Imóvel 7", 700000, 3700);
        tabuleiro.cadastrarImovel("Imóvel 8", 550000, 2900);
        tabuleiro.cadastrarImovel("Imóvel 9", 300000, 1600);
        tabuleiro.cadastrarImovel("Imóvel 10", 250000, 1300);

        // Cadastro de jogadores
        jogadores.cadastrarJogador("Jogador 1", tabuleiro.inicio);
        jogadores.cadastrarJogador("Jogador 2", tabuleiro.inicio);

        // Validar antes de iniciar o jogo
        if (tabuleiro.validarImoveis() && jogadores.validarJogadores()) {
            System.out.println("Tudo pronto para iniciar o jogo!");
            for (int rodada = 1; rodada <= jogadores.maxRodadas; rodada++) {
                System.out.println("Rodada " + rodada);
                jogadores.jogarRodada(tabuleiro);
            }
            Jogador vencedor = jogadores.obterVencedor();
            System.out.println("O vencedor é " + vencedor.nome + " com saldo de R$" + vencedor.saldo);
        } else {
            System.out.println("Configurações insuficientes para iniciar o jogo.");
        }
    }
}
