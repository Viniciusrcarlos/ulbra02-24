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
            System.out.println("Posição inválida!");
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

}
