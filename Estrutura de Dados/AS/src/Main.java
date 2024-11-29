public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        jogo.adicionarCasa(new Casa("Início", TipoCasa.INICIO, 0));
        for (int i = 1; i <= 10; i++) {
            jogo.adicionarCasa(new Casa("Imóvel " + i, TipoCasa.IMOVEL, 150 + i * 10));
        }
        jogo.adicionarCasa(new Casa("Imposto", TipoCasa.IMPOSTO, 0));
        jogo.adicionarCasa(new Casa("Restituição", TipoCasa.RESTITUICAO, 0));
        jogo.adicionarCasa(new Casa("Sorte", TipoCasa.SORTE, 0));
        jogo.adicionarCasa(new Casa("Revés", TipoCasa.REVES, 0));

        jogo.adicionarJogador("Jogador 1");
        jogo.adicionarJogador("Jogador 2");
        jogo.adicionarJogador("Jogador 3");

        jogo.configurarJogo(1000, 200, 50);
        jogo.iniciar();
    }
}