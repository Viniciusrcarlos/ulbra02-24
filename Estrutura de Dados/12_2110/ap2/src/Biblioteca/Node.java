package Biblioteca;

class Node {
    int id;
    String titulo;
    String autor;
    Node prev;
    Node next;

    public Node(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.prev = null;
        this.next = null;
    }
}
