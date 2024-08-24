import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] dados = {{1, 5, 3}, {8, 2, 6}, {4, 0, 9}};
        Matriz matriz = new Matriz(dados);

        // Testa o metodo: obterMaiorElemento()
        System.out.println("O maior elemento da Matriz é: " + matriz.obterMaiorElemento());

        // Testa o metodo: obterMenorElemento()
        System.out.println("O menor elemento da Matriz é: " + matriz.obterMenorElemento());

        // Testa o metodo: calcularMedia()
        System.out.println("A média dos elementos da Matriz é: " + matriz.calcularMedia());

        // Testa o metodo: somarElementosPorLinha()
        int[] somasPorLinha = matriz.somarElementosPorLinha();
        System.out.println("Somas por linha: " + Arrays.toString(somasPorLinha));

        // Testa o metodo: somarElementosPorColuna()
        int[] somasPorColuna = matriz.somarElementosPorColuna();
        System.out.println("Somas por coluna: " + Arrays.toString(somasPorColuna));

        // Testa o metodo: calcularSomaTotal()
        int somaTotal = matriz.calcularSomaTotal();
        System.out.println("Soma total dos elementos: " + somaTotal);

        // Testa o metodo: contarOcorrencias()
        int ocorrencias = matriz.contarOcorrencias(2);
        System.out.println("Ocorrências do valor 2: " + ocorrencias);


    }
}