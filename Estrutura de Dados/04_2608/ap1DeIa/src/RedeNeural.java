import java.util.Arrays;
import java.util.Random;

class RedeNeural {
    private int tamanhoEntrada;
    private int tamanhoOculto;
    private int tamanhoSaida;
    private double[][] pesosEntradaOculto;
    private double[][] pesosOcultoSaida;
    private double[] saidaOculta;
    private double[] saidaFinal;

    public RedeNeural(int tamanhoEntrada, int tamanhoOculto, int tamanhoSaida) {
        this.tamanhoEntrada = tamanhoEntrada;
        this.tamanhoOculto = tamanhoOculto;
        this.tamanhoSaida = tamanhoSaida;

        // Inicializando pesos aleatórios para a camada oculta e a camada de saída
        this.pesosEntradaOculto = inicializarPesos(tamanhoEntrada, tamanhoOculto);
        this.pesosOcultoSaida = inicializarPesos(tamanhoOculto, tamanhoSaida);
    }

    private double[][] inicializarPesos(int linhas, int colunas) {
        double[][] pesos = new double[linhas][colunas];
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                pesos[i][j] = random.nextDouble() * 2 - 1; // valores entre -1 e 1
            }
        }
        return pesos;
    }

    private double sigmoide(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double derivadaSigmoide(double x) {
        return x * (1 - x);
    }

    public double[] feedforward(double[] entrada) {
        // Camada oculta
        saidaOculta = new double[tamanhoOculto];
        for (int i = 0; i < tamanhoOculto; i++) {
            double soma = 0;
            for (int j = 0; j < tamanhoEntrada; j++) {
                soma += entrada[j] * pesosEntradaOculto[j][i];
            }
            saidaOculta[i] = sigmoide(soma);
        }

        // Camada de saída
        saidaFinal = new double[tamanhoSaida];
        for (int i = 0; i < tamanhoSaida; i++) {
            double soma = 0;
            for (int j = 0; j < tamanhoOculto; j++) {
                soma += saidaOculta[j] * pesosOcultoSaida[j][i];
            }
            saidaFinal[i] = sigmoide(soma);
        }

        return saidaFinal;
    }

    public void treinar(double[] entrada, double[] saidaEsperada, double taxaAprendizagem) {
        feedforward(entrada);

        // Calculando o erro da camada de saída
        double[] erroSaida = new double[tamanhoSaida];
        for (int i = 0; i < tamanhoSaida; i++) {
            erroSaida[i] = saidaEsperada[i] - saidaFinal[i];
        }

        // Ajustes na camada de saída
        double[] ajustesSaida = new double[tamanhoSaida];
        for (int i = 0; i < tamanhoSaida; i++) {
            ajustesSaida[i] = erroSaida[i] * derivadaSigmoide(saidaFinal[i]);
        }

        for (int i = 0; i < tamanhoOculto; i++) {
            for (int j = 0; j < tamanhoSaida; j++) {
                pesosOcultoSaida[i][j] += taxaAprendizagem * ajustesSaida[j] * saidaOculta[i];
            }
        }

        // Calculando o erro da camada oculta
        double[] erroOculto = new double[tamanhoOculto];
        for (int i = 0; i < tamanhoOculto; i++) {
            double erro = 0;
            for (int j = 0; j < tamanhoSaida; j++) {
                erro += ajustesSaida[j] * pesosOcultoSaida[i][j];
            }
            erroOculto[i] = erro;
        }

        // Ajustes na camada oculta
        double[] ajustesOculto = new double[tamanhoOculto];
        for (int i = 0; i < tamanhoOculto; i++) {
            ajustesOculto[i] = erroOculto[i] * derivadaSigmoide(saidaOculta[i]);
        }

        for (int i = 0; i < tamanhoEntrada; i++) {
            for (int j = 0; j < tamanhoOculto; j++) {
                pesosEntradaOculto[i][j] += taxaAprendizagem * ajustesOculto[j] * entrada[i];
            }
        }
    }

    public static double[] achatarMatriz(int[][] matriz) {
        return Arrays.stream(matriz).flatMapToInt(Arrays::stream).asDoubleStream().toArray();
    }

}