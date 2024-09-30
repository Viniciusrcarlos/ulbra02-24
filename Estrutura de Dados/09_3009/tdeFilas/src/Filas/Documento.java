package Filas;

public class Documento {
    private String nome;
    private int numeroPaginas;

    public Documento(String nome, int numeroPaginas) {
        this.nome = nome;
        this.numeroPaginas = numeroPaginas;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}