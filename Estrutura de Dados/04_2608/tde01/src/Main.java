public class Main {
    public static void main(String[] args) {

        int[] numeros = {5, 3, 8, 1, 6};

        Ordenacao.bubbleSortCrescente(numeros, "crescente");
        System.out.println();
        Ordenacao.bubbleSortCrescente(numeros, "decrescente");
        System.out.println();
        Ordenacao.selectionSortCrescente(numeros, "crescente");
        System.out.println();
        Ordenacao.selectionSortCrescente(numeros, "decrescente");
        System.out.println();
        Ordenacao.insertionSortCrescente(numeros, "crescente");
        System.out.println();
        Ordenacao.insertionSortCrescente(numeros, "decrescente");



    }
}