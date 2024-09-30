package Filas;

import Filas.Cliente;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaDeAtendimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Cliente> fila = new LinkedList<>();

        System.out.println("Insira os clientes na fila (digite 'fim' para parar):");
        while (true) {
            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Tempo de atendimento (em minutos): ");
            int tempo = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha após o número

            fila.add(new Cliente(nome, tempo));
        }

        // Variáveis para armazenar estatísticas
        int totalClientesAtendidos = 0;
        int totalTempoGasto = 0;

        // Atendendo os clientes
        System.out.println("\nAtendendo os clientes:");
        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll(); // Remove o primeiro cliente da fila
            System.out.println("Atendendo cliente: " + cliente.getNome() + ", Tempo de atendimento: " + cliente.getTempoAtendimento() + " minutos");

            // Atualizando as estatísticas
            totalClientesAtendidos++;
            totalTempoGasto += cliente.getTempoAtendimento();
        }

        // Exibindo o total de clientes atendidos e tempo gasto
        System.out.println("\nTodos os clientes foram atendidos!");
        System.out.println("Total de clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Total de tempo gasto: " + totalTempoGasto + " minutos");

        scanner.close();
    }
}