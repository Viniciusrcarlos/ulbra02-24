package Pilhas;

import java.util.Random;

public class ParImpar {
    public static void main(String[] args) {

        Pilha pilhaPar = new Pilha(10);
        Pilha pilhaImpar = new Pilha(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(51);

            if (valor == 0) {
                if (pilhaImpar.vazia()) {
                    System.out.println("Lista de Impar vazia");
                } else if (pilhaPar.cheia()) {
                    System.out.println("Lista de Par vazia");
                }

                System.out.println(pilhaPar.desempilhar());
                System.out.println(pilhaImpar.desempilhar());
            }

            if (valor%2 == 1) {
                pilhaImpar.empilhar(valor);
            } else {
                pilhaPar.empilhar(valor);
            }

        }

        System.out.println("Pilhas.Pilha impar: ");
        for (int i = 0; i < pilhaImpar.tamanho(); i++) {
            System.out.println(pilhaImpar.desempilhar());
        }

        System.out.println("Pilhas.Pilha Par:");
        for (int i = 0; i < pilhaPar.tamanho(); i++) {
            System.out.println(pilhaPar.desempilhar());
        }
    }
}
