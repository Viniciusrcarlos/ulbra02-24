public class Main {
    public static void main(String[] args) {
        double salarioJogador = 5000.0;
        int numeroMaximoRodadas = 50;

        Jogo jogo = new Jogo(salarioJogador, numeroMaximoRodadas);

        jogo.adicionarCasa("Início", "Início", 0, 0);
        jogo.adicionarCasa("Casa do Bosque", "Imóvel", 200000.0, 1100.0);
        jogo.adicionarCasa("Apartamento Central", "Imóvel", 350000.0, 1800.0);
        jogo.adicionarCasa("Vila das Flores", "Imóvel", 400000.0, 2200.0);
        jogo.adicionarCasa("Imposto", "Imposto", 0, 0);
        jogo.adicionarCasa("Restituição", "Restituição", 0, 0);
        jogo.adicionarCasa("Pousada da Praia", "Imóvel", 500000.0, 2700.0);
        jogo.adicionarCasa("Mansão da Colina", "Imóvel", 600000.0, 3300.0);
        jogo.adicionarCasa("Residência do Lago", "Imóvel", 450000.0, 2500.0);
        jogo.adicionarCasa("Cobertura Diamante", "Imóvel", 700000.0, 3700.0);

        jogo.adicionarJogador("Alice", 100000.0);
        jogo.adicionarJogador("Bob", 150000.0);

        System.out.println("Tabuleiro Inicial:");
        jogo.getTabuleiro().exibirTabuleiro();

        jogo.iniciarJogo();
    }
}
