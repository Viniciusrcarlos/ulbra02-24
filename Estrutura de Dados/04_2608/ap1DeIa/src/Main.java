import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] numeroParaTestar = {
                {1,1,1,1,1,0},
                {0,0,0,0,0,1},
                {0,0,0,0,1,0},
                {0,0,1,1,1,0},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {1,1,1,1,1,0}
        };

        // Ajustar a rede para ter 48 entradas, já que a matriz 8x6 tem 48 valores
        RedeNeural rede = new RedeNeural(48, 96, 10);

        rede.treinar(2,2,2);

        // Simulando treinamento da rede com os dados fictícios do treinamento
        // Aqui você adicionaria seu dataset de treinamento e o loop de treinamento

        // Executar o feedforward com a entrada de teste
        double[] entradaTeste = RedeNeural.achatarMatriz(numeroParaTestar);
        double[] resultado = rede.feedforward(entradaTeste);

        // Exibir o resultado bruto da rede
        System.out.println("Resultado bruto da rede: " + Arrays.toString(resultado));

        // Arredondar os valores para 0 ou 1
        int[] resultadoArredondado = Arrays.stream(resultado)
                .mapToInt(valor -> valor >= 0.5 ? 1 : 0)
                .toArray();

        System.out.println("Resultado após arredondar: " + Arrays.toString(resultadoArredondado));

        // Encontrar o índice do valor 1 (ou o índice com o maior valor)
        int indice = -1;
        for (int i = 0; i < resultadoArredondado.length; i++) {
            if (resultadoArredondado[i] == 1) {
                indice = i;
                break;
            }
        }

        // Se não houver um valor exato de 1, encontrar o índice do valor mais próximo de 1
        if (indice == -1) {
            double maxValor = Arrays.stream(resultado).max().getAsDouble();
            for (int i = 0; i < resultado.length; i++) {
                if (resultado[i] == maxValor) {
                    indice = i;
                    break;
                }
            }
        }

        System.out.println("A rede identificou o número: " + indice);
    }
}
