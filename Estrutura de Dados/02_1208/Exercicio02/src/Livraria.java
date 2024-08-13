import java.util.ArrayList;

public class Livraria {
    private ArrayList<Livro> livros = new ArrayList<>();

    public void inserirLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void listarLivros() {
        System.out.println("****** Listagem de todos os livros ******");
        for (int i = 0; i < livros.size(); i++) {
                livros.get(i).exibirDetalhes();
                System.out.println("-------------------------");
        }
        System.out.println("*************************");
    }

    public void listarDisponiveis() {
        System.out.println("****** Listagem dos livros disponiveis ******");
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).disponivel()) {
                livros.get(i).exibirDetalhes();
                System.out.println("-------------------------");
            } else continue;
        }
        System.out.println("*********************************");
    }

}
