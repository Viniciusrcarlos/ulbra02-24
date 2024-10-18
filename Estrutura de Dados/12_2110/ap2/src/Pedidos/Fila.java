package Pedidos;

class Fila {
    private Node inicio;
    private Node fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enqueue(int id, String descricao) {
        Node novoPedido = new Node(id, descricao);
        if (fim != null) {
            fim.next = novoPedido;
        }
        fim = novoPedido;
        if (inicio == null) {
            inicio = novoPedido;
        }
        System.out.println("Novo pedido adicionado: " + descricao);
    }

    public Node dequeue() {
        if (inicio == null) {
            System.out.println("A fila de pedidos está vazia.");
            return null;
        }
        Node pedidoAtendido = inicio;
        inicio = inicio.next;
        if (inicio == null) {
            fim = null;
        }
        System.out.println("Pedido atendido: " + pedidoAtendido.descricao);
        return pedidoAtendido;
    }

    public void printQueue() {
        if (inicio == null) {
            System.out.println("A fila de pedidos pendentes está vazia.");
            return;
        }
        Node atual = inicio;
        System.out.println("Pedidos pendentes:");
        while (atual != null) {
            System.out.println("ID: " + atual.id + ", Descrição: " + atual.descricao);
            atual = atual.next;
        }
    }
}
