public class Main {
    public static void main(String[] args) {

        var l1 = new Livro("The Witcher", "Não sei", 230);

        l1.exibirDetalhes();
        l1.devolver();
        System.out.println(l1.disponivel());
        l1.reservar();
        System.out.println(l1.disponivel());
        l1.devolver();
    }
}