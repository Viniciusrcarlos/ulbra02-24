import java.util.Random;

public class Main {

    public static void mergeSort(int [] vetor, int inicio, int fim) {
        if (inicio < fim ){
            int meio = (inicio + fim)/2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio , fim);
        }

    }

    private static void merge(int [] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio +1;
        int n2 = fim -meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int i = 0; i < n2; i++) {
            direita[i] = vetor[meio + 1 + i];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] < direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }

    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o vetor e retorna o índice do pivô
            int indicePivo = particionar(vetor, inicio, fim);
            // Ordena a sublista à esquerda do pivô
            quickSort(vetor, inicio, indicePivo - 1);
            //Ordena a sublista à direita do pivô
            quickSort(vetor, indicePivo + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = (inicio - 1); // Índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) { // Se o elemento atual é menor ou igual ao pivô
                i++;
                // Troca vetor[i] e vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        // Troca vetor[i+1] com o pivô (vetor[fim])
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] vetor = new int[10];

        Random random = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100);
        }

        imprimirVetor(vetor);
        quickSort(vetor, 0, vetor.length - 1);
        imprimirVetor(vetor);



    }
}