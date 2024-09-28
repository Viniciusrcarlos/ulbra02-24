public class Pilha {
    private String[] elementos;
    private int tamanho;

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new String[tamanho];
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == this.elementos.length;
    }

    public boolean empilhar(String elemento) {
        if (!estaCheia()) {
            this.elementos[tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    public String desempilhar(){
        if(!estaVazia()){
            tamanho--;
            return this.elementos[tamanho];
        }
        return null;
    };





}
