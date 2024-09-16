import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new int[linhas][colunas];
    }

    public void preencherMatriz(boolean aleatorio) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (aleatorio) {
                    matriz[i][j] = random.nextInt(100);
                } else {
                    System.out.printf("Digite o valor para a posição [%d][%d]: ", i, j);
                    matriz[i][j] = scanner.nextInt();
                }
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
        } else {
            System.out.println("Posicao invalida");
        }
    }

    // Nesse caso, vou remover o elemento original e alterar o valor para 0
    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Ordenar por linhas usando Bubble Sort (iterativo)
    public void ordenarPorLinhas() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(matriz[i]);
        }
        System.out.println("Matriz ordenada por linhas:");
        exibirMatriz();
    }

    // Ordenar por colunas
    public void ordenarPorColunas() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            bubbleSort(coluna); // Ordenação por Bubble Sort
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
        System.out.println("Matriz ordenada por colunas:");
        exibirMatriz();
    }

    // Ordenar a matriz como um vetor e reconstruí-la
    public void ordenarMatrizCompleta() {
        int[] vetor = new int[linhas * colunas];
        int index = 0;

        // Convertendo a matriz para um vetor
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = matriz[i][j];
            }
        }

        // Ordenar o vetor usando Merge Sort (recursivo)
        vetor = mergeSort(vetor);

        // Reconstruir a matriz com os valores ordenados
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[index++];
            }
        }

        System.out.println("Matriz ordenada completamente:");
        exibirMatriz();
    }

    // Função de ordenação Bubble Sort (iterativo)
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Função de ordenação Merge Sort (recursivo)
    private int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int meio = array.length / 2;
        int[] esquerda = Arrays.copyOfRange(array, 0, meio);
        int[] direita = Arrays.copyOfRange(array, meio, array.length);

        return merge(mergeSort(esquerda), mergeSort(direita));
    }

    // Função auxiliar do Merge Sort para combinar dois arrays
    private int[] merge(int[] esquerda, int[] direita) {
        int[] resultado = new int[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                resultado[k++] = esquerda[i++];
            } else {
                resultado[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            resultado[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            resultado[k++] = direita[j++];
        }

        return resultado;
    }




}