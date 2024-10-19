package Biblioteca;

class ListaDuplamenteLigada {
    private Node inicio;
    private Node fim;

    public ListaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarInicio(int id, String titulo, String autor) {
        Node novoLivro = new Node(id, titulo, autor);
        if (inicio == null) {
            inicio = fim = novoLivro;
        } else {
            novoLivro.next = inicio;
            inicio.prev = novoLivro;
            inicio = novoLivro;
        }
        System.out.println("Livro adicionado no início: " + titulo);
    }

    public void adicionarFim(int id, String titulo, String autor) {
        Node novoLivro = new Node(id, titulo, autor);
        if (fim == null) {
            inicio = fim = novoLivro;
        } else {
            fim.next = novoLivro;
            novoLivro.prev = fim;
            fim = novoLivro;
        }
        System.out.println("Livro adicionado no fim: " + titulo);
    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        System.out.println("Livro removido do início: " + inicio.titulo);
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.next;
            inicio.prev = null;
        }
    }

    public void removerFim() {
        if (fim == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        System.out.println("Livro removido do fim: " + fim.titulo);
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.prev;
            fim.next = null;
        }
    }

    public void buscarPorID(int id) {
        Node atual = inicio;
        while (atual != null) {
            if (atual.id == id) {
                System.out.println("Livro encontrado: ID: " + atual.id + ", Título: " + atual.titulo + ", Autor: " + atual.autor);
                return;
            }
            atual = atual.next;
        }
        System.out.println("Livro com ID " + id + " não encontrado.");
    }

    public void imprimirOrdemOriginal() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node atual = inicio;
        System.out.println("Livros na ordem original:");
        while (atual != null) {
            System.out.println("ID: " + atual.id + ", Título: " + atual.titulo + ", Autor: " + atual.autor);
            atual = atual.next;
        }
    }

    public void imprimirOrdemReversa() {
        if (fim == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node atual = fim;
        System.out.println("Livros na ordem inversa:");
        while (atual != null) {
            System.out.println("ID: " + atual.id + ", Título: " + atual.titulo + ", Autor: " + atual.autor);
            atual = atual.prev;
        }
    }
}

