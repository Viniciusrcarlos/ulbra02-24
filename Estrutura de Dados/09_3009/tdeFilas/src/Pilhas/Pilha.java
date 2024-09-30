package Pilhas;

import java.util.StringJoiner;

class Pilha {
    private int [] elementos;
    private int tamanho;

    public Pilha(int tamanho) {
        elementos = new int[tamanho];
        this.tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public boolean cheia() {
        return tamanho == this.elementos.length;
    }

    public boolean empilhar(int e) {
        if(!cheia()) {
            this.elementos[tamanho] = e;
            tamanho++;
            return true;
        }
        return false;
    }

    public int desempilhar() {
        if (!vazia()) {
            tamanho--;
            int retorno = this.elementos[tamanho];
            this.elementos[tamanho] = 0;
            return retorno;
        }
        return 000;
    }

    public String toString() {
        StringJoiner s = new StringJoiner(", ", "[", "]");

        for (Object elemento : this.elementos) {
            if (elemento != null) {
                s.add(elemento.toString());
            }
        }

        return s.toString();
    }



}