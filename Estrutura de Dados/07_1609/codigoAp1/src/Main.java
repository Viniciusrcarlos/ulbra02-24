public class Main {
    public static void main(String[] args) {

        var matriz = new Matriz(3,5);

        matriz.preencherMatriz(true);
        matriz.exibirMatriz();

        matriz.ordenarPorColunas();
        matriz.ordenarPorLinhas();
        matriz.ordenarMatrizCompleta();



    }
}