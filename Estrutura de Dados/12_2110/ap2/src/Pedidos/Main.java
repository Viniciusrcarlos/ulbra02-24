package Pedidos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciamento sistema = new Gerenciamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido Cancelado");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    sistema.adicionarPedido(descricao);
                    break;
                case 2:
                    sistema.atenderPedido();
                    break;
                case 3:
                    sistema.cancelarPedido();
                    break;
                case 4:
                    sistema.restaurarPedido();
                    break;
                case 5:
                    sistema.imprimirPedidosPendentes();
                    break;
                case 6:
                    sistema.imprimirPedidosCancelados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
