package Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciamento sistema = new Gerenciamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar Livro no Início");
            System.out.println("2. Adicionar Livro no Fim");
            System.out.println("3. Remover Primeiro Livro");
            System.out.println("4. Remover Último Livro");
            System.out.println("5. Buscar Livro por ID");
            System.out.println("6. Imprimir Livros na Ordem Original");
            System.out.println("7. Imprimir Livros na Ordem Reversa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloInicio = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorInicio = scanner.nextLine();
                    sistema.adicionarLivroInicio(tituloInicio, autorInicio);
                    break;
                case 2:
                    System.out.print("Digite o título do livro: ");
                    String tituloFim = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autorFim = scanner.nextLine();
                    sistema.adicionarLivroFim(tituloFim, autorFim);
                    break;
                case 3:
                    sistema.removerPrimeiroLivro();
                    break;
                case 4:
                    sistema.removerUltimoLivro();
                    break;
                case 5:
                    System.out.print("Digite o ID do livro: ");
                    int id = scanner.nextInt();
                    sistema.buscarLivroPorID(id);
                    break;
                case 6:
                    sistema.imprimirLivrosOrdemOriginal();
                    break;
                case 7:
                    sistema.imprimirLivrosOrdemReversa();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
