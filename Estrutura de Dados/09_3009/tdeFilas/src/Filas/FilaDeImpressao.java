package Filas;

import Filas.Documento;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaDeImpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Documento> fila = new LinkedList<>();

        int totalPaginasImpressas = 0;
        Documento documentoComMaisPaginas = null;

        System.out.println("Insira os documentos na fila de impressão (digite 'fim' para parar):");
        while (true) {
            System.out.print("Nome do documento: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Número de páginas: ");
            int numeroPaginas = scanner.nextInt();
            scanner.nextLine();

            Documento doc = new Documento(nome, numeroPaginas);
            fila.add(doc);

            if (documentoComMaisPaginas == null || doc.getNumeroPaginas() > documentoComMaisPaginas.getNumeroPaginas()) {
                documentoComMaisPaginas = doc;
            }
        }

        int contadorImpressao = 0;
        System.out.println("\nIniciando a impressão dos documentos:");
        while (!fila.isEmpty()) {
            Documento documento = fila.poll();
            System.out.println("Imprimindo documento: " + documento.getNome() + ", Páginas: " + documento.getNumeroPaginas());

            totalPaginasImpressas += documento.getNumeroPaginas();
            contadorImpressao++;

            if (contadorImpressao % 2 == 0 && !fila.isEmpty()) {
                Documento proximoDocumento = fila.peek();
                System.out.println("Próximo documento na fila: " + proximoDocumento.getNome() + ", Páginas: " + proximoDocumento.getNumeroPaginas());
            }
        }
        
        System.out.println("\nSimulação de impressão finalizada.");
        System.out.println("Documento com maior número de páginas: " + documentoComMaisPaginas.getNome() + " (" + documentoComMaisPaginas.getNumeroPaginas() + " páginas)");
        System.out.println("Total de páginas impressas: " + totalPaginasImpressas);

        scanner.close();
    }
}