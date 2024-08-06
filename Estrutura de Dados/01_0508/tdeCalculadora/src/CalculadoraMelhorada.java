import java.util.Scanner;

public class CalculadoraMelhorada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalOperacoes = 0;
        int adicoes = 0;
        int subtracoes = 0;
        int multiplicacoes = 0;
        int divisoes = 0;

        do {
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.println("Escolha a operação:");
            System.out.println("1. Adição (+)");
            System.out.println("2. Subtração (-)");
            System.out.println("3. Multiplicação (*)");
            System.out.println("4. Divisão (/)");

            int escolha = scanner.nextInt();
            double resultado = 0;

            switch (escolha) {
                case 1:
                    resultado = num1 + num2;
                    adicoes++;
                    break;
                case 2:
                    resultado = num1 - num2;
                    subtracoes++;
                    break;
                case 3:
                    resultado = num1 * num2;
                    multiplicacoes++;
                    break;
                case 4:
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        divisoes++;
                    } else {
                        System.out.println("Erro: Divisão por zero!");
                        continue; // Volta para o início do loop em caso de divisão por zero
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue; // Volta para o início do loop em caso de opção inválida
            }

            System.out.println("Resultado: " + resultado);
            totalOperacoes++;

            System.out.print("Deseja continuar? (S/N): ");
        } while (scanner.next().equalsIgnoreCase("S"));

        System.out.println("\nTotal de operações realizadas: " + totalOperacoes);
        System.out.println("Adições: " + adicoes);
        System.out.println("Subtrações: " + subtracoes);
        System.out.println("Multiplicações: " + multiplicacoes);
        System.out.println("Divisões: " + divisoes);
    }
}


