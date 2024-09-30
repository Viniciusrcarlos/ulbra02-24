package Pilhas;

import java.util.Scanner;

public class VerificacaoParenteses {

    public static boolean verificaParentesesBalanceados(String expressao) {
        Pilha pilha = new Pilha(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.empilhar(c);
            }
            else if (c == ')') {
                if (pilha.vazia()) {
                    return false;
                }
                pilha.desempilhar();
            }
        }

        return pilha.vazia();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão matemática: ");
        String expressao = scanner.nextLine();

        if (verificaParentesesBalanceados(expressao)) {
            System.out.println("Os parênteses estão balanceados.");
        } else {
            System.out.println("Os parênteses não estão balanceados.");
        }

        scanner.close();
    }
}