import java.util.Scanner;
import java.util.Stack;

public class ParImparTeste {

    public static void main(String[] args) {
        // Criar duas pilhas: uma para números pares e outra para ímpares
        Stack<Integer> pilhaPar = new Stack<>();
        Stack<Integer> pilhaImpar = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        // Ler 10 números do usuário
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                // Desempilha um elemento de cada pilha (se possível)
                if (!pilhaPar.isEmpty()) {
                    System.out.println("Desempilhando da pilha PAR: " + pilhaPar.pop());
                } else {
                    System.out.println("Erro: Pilha PAR está vazia.");
                }

                if (!pilhaImpar.isEmpty()) {
                    System.out.println("Desempilhando da pilha ÍMPAR: " + pilhaImpar.pop());
                } else {
                    System.out.println("Erro: Pilha ÍMPAR está vazia.");
                }
            } else if (numero % 2 == 0) {
                // Número par, empilhar na pilha de pares
                pilhaPar.push(numero);
                System.out.println("Número " + numero + " empilhado na pilha PAR.");
            } else {
                // Número ímpar, empilhar na pilha de ímpares
                pilhaImpar.push(numero);
                System.out.println("Número " + numero + " empilhado na pilha ÍMPAR.");
            }
        }

        // Desempilhar todos os elementos da pilha PAR
        System.out.println("\nDesempilhando todos os números da pilha PAR:");
        while (!pilhaPar.isEmpty()) {
            System.out.println(pilhaPar.pop());
        }

        // Desempilhar todos os elementos da pilha ÍMPAR
        System.out.println("\nDesempilhando todos os números da pilha ÍMPAR:");
        while (!pilhaImpar.isEmpty()) {
            System.out.println(pilhaImpar.pop());
        }

        scanner.close();
    }
}
