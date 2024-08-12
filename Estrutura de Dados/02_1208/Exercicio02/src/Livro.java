public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean disponibilidade;

    //Constructor
    public Livro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponibilidade = true;
    }

    // gets and sets
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    // methods
    public void exibirDetalhes() {
        System.out.println("*******************************");
        System.out.println("Detalhes do livro:");
        System.out.println();
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Numero de páginas: " + this.numeroPaginas);
        if (this.disponibilidade) {
            System.out.println("Disponóvel");
        } else {
            System.out.println("Indisponível");
        }
        System.out.println("*******************************");
    }

    public void reservar() {
        if (this.disponibilidade) {
            System.out.println("Reserva feita com sucesso!");
            this.disponibilidade = false;
        } else {
            System.out.println("O livro já está reservado.");
        }
    }

    public void devolver() {
        if (disponibilidade) {
            System.out.println("O livro não está reservado.");
        } else {
            System.out.println("Devolução feita com sucesso!");
        }
    }

    public boolean disponivel() {
        if (disponibilidade) {
            return true;
        }
        return false;
    }

}
