package Biblioteca;

public class Gerenciamento {
    private ListaDuplamenteLigada listaLivros = new ListaDuplamenteLigada();
    private int idAtual = 1;

    public void adicionarLivroInicio(String titulo, String autor) {
        listaLivros.adicionarInicio(idAtual++, titulo, autor);
    }

    public void adicionarLivroFim(String titulo, String autor) {
        listaLivros.adicionarFim(idAtual++, titulo, autor);
    }

    public void removerPrimeiroLivro() {
        listaLivros.removerInicio();
    }

    public void removerUltimoLivro() {
        listaLivros.removerFim();
    }

    public void buscarLivroPorID(int id) {
        listaLivros.buscarPorID(id);
    }

    public void imprimirLivrosOrdemOriginal() {
        listaLivros.imprimirOrdemOriginal();
    }

    public void imprimirLivrosOrdemReversa() {
        listaLivros.imprimirOrdemReversa();
    }
}
