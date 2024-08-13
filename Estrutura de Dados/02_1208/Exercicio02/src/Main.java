public class Main {
    public static void main(String[] args) {

        var l1 = new Livro("The Witcher", "Não sei", 230);
        var l2 = new Livro("Harry Potter", "Não sei", 334);
        var livraraia = new Livraria();

        livraraia.inserirLivro(l1);
        livraraia.inserirLivro(l2);

        l1.reservar();

        livraraia.listarDisponiveis();
        livraraia.listarLivros();

        l1.devolver();

    }
}