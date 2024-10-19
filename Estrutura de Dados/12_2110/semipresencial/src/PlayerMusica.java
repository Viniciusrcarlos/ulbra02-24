import java.util.Scanner;

public class PlayerMusica {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Playlist ---");
            System.out.println("1. Adicionar música no fim");
            System.out.println("2. Adicionar música no início");
            System.out.println("3. Próxima música");
            System.out.println("4. Música anterior");
            System.out.println("5. Tocar música atual");
            System.out.println("6. Remover música por título");
            System.out.println("7. Listar músicas");
            System.out.println("8. Ordenar por título");
            System.out.println("9. Ordenar por artista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Digite o álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Digite a duração (em segundos): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    Musica musica = new Musica(titulo, artista, album, duracao);
                    playlist.adicionarMusicaFim(musica);
                }
                case 2 -> {
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Digite o álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Digite a duração (em segundos): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();
                    Musica musica = new Musica(titulo, artista, album, duracao);
                    playlist.adicionarMusicaInicio(musica);
                }
                case 3 -> playlist.proximaMusica();
                case 4 -> playlist.musicaAnterior();
                case 5 -> playlist.tocarMusica();
                case 6 -> {
                    System.out.print("Digite o título da música a remover: ");
                    String titulo = scanner.nextLine();
                    playlist.removerMusica(titulo);
                }
                case 7 -> playlist.listarMusicas();
                case 8 -> playlist.ordenarPorTitulo();
                case 9 -> playlist.ordenarPorArtista();
                case 0 -> System.out.println("Saindo do programa...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
