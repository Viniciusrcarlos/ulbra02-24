public class Matriz {
    private int[][] matriz;

    // Construtor
    public Matriz(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("A matriz não pode ser nula.");
        }

        if (matriz.length == 0 || matriz[0].length == 0) {
            throw new IllegalArgumentException("A matriz não pode ser vazia.");
        }

        this.matriz = matriz;
    }

    // Obter maior elemento
    public int obterMaiorElemento() {
        int maior = Integer.MIN_VALUE;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento > maior) {
                    maior = elemento;
                }
            }
        }

        return maior;
    }

    // Obter o menor elemento
    public int obterMenorElemento() {
        int menor = Integer.MAX_VALUE;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento < menor) {
                    menor = elemento;
                }
            }
        }

        return menor;
    }

    // Retorna a media dos elementos
    public double calcularMedia() {
        int soma = 0;
        int totalElementos = 0;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                soma += elemento;
                totalElementos++;
            }
        }

        return (double) soma / totalElementos;
    }

    // Soma os elementos por linha
    public int[] somarElementosPorLinha() {
        int[] somas = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            int somaLinha = 0;
            for (int elemento : matriz[i]) {
                somaLinha += elemento;
            }
            somas[i] = somaLinha;
        }

        return somas;
    }

    // Soma os elementos por colunas
    public int[] somarElementosPorColuna() {

        if (matriz.length == 0 || matriz[0].length == 0) {
            return new int[0];
        }

        int numColunas = matriz[0].length;
        int[] somas = new int[numColunas];

        for (int j = 0; j < numColunas; j++) {
            int somaColuna = 0;
            for (int i = 0; i < matriz.length; i++) {
                somaColuna += matriz[i][j];
            }
            somas[j] = somaColuna;
        }

        return somas;
    }

    // Somar o total da matriz
    public int calcularSomaTotal() {
        int somaTotal = 0;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                somaTotal += elemento;
            }
        }

        return somaTotal;
    }

    // Retorna a quantidade de vezes que um numero aparece na Matriz
    public int contarOcorrencias(int valor) {
        int contador = 0;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento == valor) {
                    contador++;
                }
            }
        }

        return contador;
    }

}