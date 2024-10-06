public class ListaEncadeada<T> {
    private Node<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Método para adicionar um elemento no início da lista
    public void adicionarNoInicio(T valor) {
        Node<T> novoNo = new Node<>(valor);
        novoNo.setProximo(inicio);
        inicio = novoNo;
        tamanho++;
    }

    // Método para adicionar um elemento no final da lista
    public void adicionarNoFim(T valor) {
        Node<T> novoNo = new Node<>(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            Node<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    // Método para adicionar um elemento em uma posição específica da lista
    public void adicionarNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            adicionarNoInicio(valor);
        } else {
            Node<T> novoNo = new Node<>(valor);
            Node<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
            tamanho++;
        }
    }

    // Método para remover o primeiro elemento da lista
    public T removerDoInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        T valor = inicio.getValor();
        inicio = inicio.getProximo();
        tamanho--;
        return valor;
    }

    // Método para remover o último elemento da lista
    public T removerDoFim() {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        if (tamanho == 1) {
            return removerDoInicio();
        }

        Node<T> atual = inicio;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
        T valor = atual.getProximo().getValor();
        atual.setProximo(null);
        tamanho--;
        return valor;
    }

    // Método para remover um elemento de uma posição específica
    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            return removerDoInicio();
        }

        Node<T> atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }
        T valor = atual.getProximo().getValor();
        atual.setProximo(atual.getProximo().getProximo());
        tamanho--;
        return valor;
    }

    // Método para remover um elemento específico da lista
    public T removerPorValor(T valor) {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        if (inicio.getValor().equals(valor)) {
            return removerDoInicio();
        }

        Node<T> atual = inicio;
        while (atual.getProximo() != null && !atual.getProximo().getValor().equals(valor)) {
            atual = atual.getProximo();
        }

        if (atual.getProximo() == null) {
            throw new IllegalArgumentException("Elemento não encontrado");
        }

        T valorRemovido = atual.getProximo().getValor();
        atual.setProximo(atual.getProximo().getProximo());
        tamanho--;
        return valorRemovido;
    }

    // Método para buscar o valor de um nó em uma posição específica
    public T buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    // Método para buscar a posição de um elemento específico
    public int buscarPosicao(T valor) {
        Node<T> atual = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getValor().equals(valor)) {
                return i;
            }
            atual = atual.getProximo();
        }
        return -1; // Elemento não encontrado
    }

    // Método para atualizar o valor de um nó em uma posição específica
    public void atualizar(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setValor(novoValor);
    }

    // Método que retorna o número de elementos da lista
    public int tamanho() {
        return tamanho;
    }

    // Método que verifica se a lista está vazia
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Método para limpar a lista
    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    // Método para retornar uma representação textual da lista
    @Override
    public String toString() {
        if (estaVazia()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.getValor());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}
