package Pilhas;

public class Main {
    public static void main(String[] args) {

        Pilha pilha = new Pilha(3);

        pilha.empilhar(20);
        pilha.empilhar(30);
        pilha.empilhar(40);

        System.out.println(pilha.desempilhar());
        System.out.println(pilha.desempilhar());
        System.out.println(pilha.desempilhar());

        System.out.println(pilha);

    }
}