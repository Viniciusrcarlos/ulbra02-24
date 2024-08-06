import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculadora Básica");
        System.out.println("Escolha uma operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Digite o número da operação desejada: ");

        int escolha = scanner.nextInt();

        System.out.print("Digite o primeiro valor: ");
        double valor1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = scanner.nextDouble();

        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = valor1 + valor2;
                System.out.printf("Resultado da soma: %.2f\n", resultado);
                break;
            case 2:
                resultado = valor1 - valor2;
                System.out.printf("Resultado da subtração: %.2f\n", resultado);
                break;
            case 3:
                resultado = valor1 * valor2;
                System.out.printf("Resultado da multiplicação: %.2f\n", resultado);
                break;
            case 4:
                if (valor2 != 0) {
                    resultado = valor1 / valor2;
                    System.out.printf("Resultado da divisão: %.2f\n", resultado);
                } else {
                    System.out.println("Erro: Divisão por zero!");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}