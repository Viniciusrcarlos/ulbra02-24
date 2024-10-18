package Pedidos;

import java.util.Scanner;

public class Gerenciamento {
    private Fila filaPedidosPendentes = new Fila();
    private Pilha pilhaPedidosCancelados = new Pilha();
    private int idAtual = 1;

    public void adicionarPedido(String descricao) {
        filaPedidosPendentes.enqueue(idAtual++, descricao);
    }

    public void atenderPedido() {
        filaPedidosPendentes.dequeue();
    }

    public void cancelarPedido() {
        Node pedidoCancelado = filaPedidosPendentes.dequeue();
        if (pedidoCancelado != null) {
            pilhaPedidosCancelados.push(pedidoCancelado.id, pedidoCancelado.descricao);
        }
    }

    public void restaurarPedido() {
        Node pedidoRestaurado = pilhaPedidosCancelados.pop();
        if (pedidoRestaurado != null) {
            filaPedidosPendentes.enqueue(pedidoRestaurado.id, pedidoRestaurado.descricao);
        }
    }

    public void imprimirPedidosPendentes() {
        filaPedidosPendentes.printQueue();
    }

    public void imprimirPedidosCancelados() {
        pilhaPedidosCancelados.printStack();
    }
}
