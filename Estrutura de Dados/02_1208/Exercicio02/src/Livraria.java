import java.util.ArrayList;

public class Livraria {
    private final ArrayList<Livro> livros = new ArrayList<>();

    public void inserirLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void listarLivros() {
        System.out.println("****** Listagem de todos os livros ******");
        for (Livro livro : livros) {
            livro.exibirDetalhes();
            System.out.println("-------------------------");
        }
        System.out.println("*************************");
    }

    public void listarDisponiveis() {
        System.out.println("****** Listagem dos livros disponiveis ******");
        for (Livro livro : livros) {
            if (livro.disponivel()) {
                livro.exibirDetalhes();
                System.out.println("-------------------------");
            }
        }
        System.out.println("*********************************");
    }

}
