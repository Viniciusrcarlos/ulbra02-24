package Pilhas;

import java.util.Scanner;

public class Palindromo {

    public static boolean verificarPolindromo(String s) {
        int tamanho = s.length();

        for (int i = 0; i < tamanho / 2; i++) {
            if (s.charAt(i) != s.charAt(tamanho - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a sequência de caracteres: ");
        String sequencia = scanner.nextLine();

        if (verificarPolindromo(sequencia)) {
            System.out.println("Sim, é um palíndromo.");
        } else {
            System.out.println("Não, não é um palíndromo.");
        }

        scanner.close();
    }
}