import java.util.*;

public class CargoFast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        while (true) {
            System.out.println("\n=== CargoFast - Otimização de Rotas ===");
            System.out.println("1. Adicionar Cidade");
            System.out.println("2. Adicionar Estrada");
            System.out.println("3. Remover Estrada (Bloqueio)");
            System.out.println("4. Calcular Rota");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da cidade: ");
                    String nomeCidade = scanner.nextLine();
                    grafo.adicionarCidade(nomeCidade);
                    System.out.println("Cidade adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a cidade de origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Digite a cidade de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Digite a distância: ");
                    int distancia = scanner.nextInt();
                    System.out.print("Digite o custo: ");
                    int custo = scanner.nextInt();
                    grafo.adicionarEstrada(origem, destino, distancia, custo);
                    System.out.println("Estrada adicionada com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite a cidade de origem: ");
                    origem = scanner.nextLine();
                    System.out.print("Digite a cidade de destino: ");
                    destino = scanner.nextLine();
                    grafo.removerEstrada(origem, destino);
                    System.out.println("Estrada bloqueada com sucesso!");
                    break;

                case 4:
                    System.out.print("Digite a cidade de origem: ");
                    origem = scanner.nextLine();
                    System.out.print("Digite a cidade de destino: ");
                    destino = scanner.nextLine();
                    System.out.print("Digite o limite de custo (ou -1 para ignorar): ");
                    int limiteCusto = scanner.nextInt();
                    System.out.print("Deseja otimizar pela menor distância? (true/false): ");
                    boolean menorDistancia = scanner.nextBoolean();
                    List<String> rota = grafo.calcularRota(origem, destino, limiteCusto, menorDistancia);
                    System.out.println("Rota calculada: " + rota);
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
