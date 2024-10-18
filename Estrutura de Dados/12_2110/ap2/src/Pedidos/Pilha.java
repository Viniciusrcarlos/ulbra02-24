package Pedidos;

class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(int id, String descricao) {
        Node novoPedido = new Node(id, descricao);
        novoPedido.next = topo;
        topo = novoPedido;
        System.out.println("Pedido cancelado: " + descricao);
    }

    public Node pop() {
        if (topo == null) {
            System.out.println("A pilha de pedidos cancelados está vazia.");
            return null;
        }
        Node pedidoCancelado = topo;
        topo = topo.next;
        System.out.println("Pedido restaurado: " + pedidoCancelado.descricao);
        return pedidoCancelado;
    }

    public void printStack() {
        if (topo == null) {
            System.out.println("A pilha de pedidos cancelados está vazia.");
            return;
        }
        Node atual = topo;
        System.out.println("Pedidos cancelados:");
        while (atual != null) {
            System.out.println("ID: " + atual.id + ", Descrição: " + atual.descricao);
            atual = atual.next;
        }
    }
}
