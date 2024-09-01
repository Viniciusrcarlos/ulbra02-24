public class Ordenacao {

    public static void bubbleSortCrescente(int[] vetor, String logica) {

        if (logica == "crescente") {
            int n = vetor.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (vetor[j] > vetor[j + 1]) {
                        int aux = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = aux;
                    }
                }
            }

            for (int j : vetor) {
                System.out.print(j + " ");
            }
        } else if (logica == "decrescente") {
            int n = vetor.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (vetor[j] < vetor[j + 1]) {
                        int aux = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = aux;
                    }
                }
            }

            for (int j : vetor) {
                System.out.print(j + " ");
            }
        }
    }

    public static void selectionSortCrescente(int[] vetor, String logica) {

        if (logica == "crescente") {
            int n = vetor.length;
            for (int i = 0; i < n - 1; i++) {
                int indiceMenor = i;
                for (int j = i + 1; j < n; j++) {
                    if (vetor[j] < vetor[indiceMenor]) {
                        indiceMenor = j;
                    }
                }
                int temp = vetor[indiceMenor];
                vetor[indiceMenor] = vetor[i];

                vetor[i] = temp;
            }

            for(int u : vetor) {
                System.out.print(u + " ");
            }
        } else if (logica == "decrescente") {
            int n = vetor.length;
            for (int i = 0; i < n - 1; i++) {
                int indiceMaior = i;
                for (int j = i + 1; j < n; j++) {
                    if (vetor[j] > vetor[indiceMaior]) {
                        indiceMaior = j;
                    }
                }
                int temp = vetor[indiceMaior];
                vetor[indiceMaior] = vetor[i];
                vetor[i] = temp;
            }

            for(int u : vetor) {
                System.out.print(u + " ");
            }
        }
    }

    public static void insertionSortCrescente(int[] vetor, String logica) {

        if (logica == "crescente") {
            int n = vetor.length;
            for (int i = 1; i < n; ++i) {
                int chave = vetor[i];
                int j = i - 1;

                while (j >= 0 && vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    j = j - 1;
                }
                vetor[j + 1] = chave;
            }
            for(int u : vetor) {
                System.out.print(u + " ");
            }

        } else if (logica == "decrescente") {
            int n = vetor.length;
            for (int i = 1; i < n; ++i) {
                int chave = vetor[i];
                int j = i - 1;

                while (j >= 0 && vetor[j] < chave) { // Inverte a comparação
                    vetor[j + 1] = vetor[j];
                    j = j - 1;
                }
                vetor[j + 1] = chave;
            }
            for(int u : vetor) {
                System.out.print(u + " ");
            }
        }

    }







}
