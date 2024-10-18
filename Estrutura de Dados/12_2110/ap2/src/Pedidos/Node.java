package Pedidos;

class Node {
    int id;
    String descricao;
    Node next;

    public Node(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.next = null;
    }
}
