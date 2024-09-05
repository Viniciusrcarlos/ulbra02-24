import 'dart:math';

List<Map<String, dynamic>> treinamento = [
  // Número 0
  {
    'entrada': [
      [0, 0, 1, 1, 1, 0],
      [0, 1, 0, 0, 0, 1],
      [0, 1, 0, 0, 0, 1],
      [0, 1, 0, 0, 0, 1],
      [0, 1, 0, 0, 0, 1],
      [0, 1, 0, 0, 0, 1],
      [0, 1, 0, 0, 0, 1],
      [0, 0, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
  },
  // Número 1
  {
    'entrada': [
      [0, 0, 0, 1, 0, 0],
      [0, 0, 1, 1, 0, 0],
      [0, 1, 0, 1, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 1, 1, 1, 1, 1]
    ],
    'resultadoEsperado': [0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
  },
  // Número 2
  {
    'entrada': [
      [0, 1, 1, 1, 1, 0],
      [1, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 1, 0, 0, 0],
      [0, 1, 0, 0, 0, 0],
      [1, 0, 0, 0, 0, 0],
      [1, 1, 1, 1, 1, 1]
    ],
    'resultadoEsperado': [0, 0, 1, 0, 0, 0, 0, 0, 0, 0]
  },
  // Número 3
  {
    'entrada': [
      [1, 1, 1, 1, 1, 0],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 1, 1, 1, 0],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [1, 1, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 1, 0, 0, 0, 0, 0, 0]
  },
  // Número 4
  {
    'entrada': [
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 1, 1, 0],
      [0, 0, 1, 0, 1, 0],
      [0, 1, 0, 0, 1, 0],
      [1, 1, 1, 1, 1, 1],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 0, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
  },
  // Número 5
  {
    'entrada': [
      [1, 1, 1, 1, 1, 1],
      [1, 0, 0, 0, 0, 0],
      [1, 1, 1, 1, 1, 0],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 0, 1, 0, 0, 0, 0]
  },
  // Número 6
  {
    'entrada': [
      [0, 0, 1, 1, 1, 0],
      [0, 1, 0, 0, 0, 0],
      [1, 0, 0, 0, 0, 0],
      [1, 1, 1, 1, 1, 0],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 0, 0, 1, 0, 0, 0]
  },
  // Número 7
  {
    'entrada': [
      [1, 1, 1, 1, 1, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 0, 1, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 0, 1, 0, 0, 0],
      [0, 0, 1, 0, 0, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
  },
  // Número 8
  {
    'entrada': [
      [0, 1, 1, 1, 1, 0],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 0],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 0, 0, 0, 0, 1, 0]
  },
  // Número 9
  {
    'entrada': [
      [0, 1, 1, 1, 1, 0],
      [1, 0, 0, 0, 0, 1],
      [1, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 0, 0, 0, 0, 1],
      [0, 1, 1, 1, 1, 0]
    ],
    'resultadoEsperado': [0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
  }];


// Definindo a classe RedeNeural
class RedeNeural {
  List<List<double>> pesosEntradaOculto;
  List<List<double>> pesosOcultoSaida;

  RedeNeural(int tamanhoEntrada, int tamanhoOculto, int tamanhoSaida)
      : pesosEntradaOculto = inicializarPesos(tamanhoEntrada, tamanhoOculto),
        pesosOcultoSaida = inicializarPesos(tamanhoOculto, tamanhoSaida);

  // Função para inicializar pesos aleatórios
  static List<List<double>> inicializarPesos(int linhas, int colunas) {
    var random = Random();
    return List.generate(linhas,
        (_) => List.generate(colunas, (_) => random.nextDouble() * 2 - 1));
  }

  // Função sigmoide
  double sigmoide(double x) => 1 / (1 + exp(-x));

  // Feedforward
  List<double> feedforward(List<double> entrada) {
    var saidaOculta = multiplicarMatriz(entrada, pesosEntradaOculto)
        .map(sigmoide)
        .toList();
    var saidaFinal = multiplicarMatriz(saidaOculta, pesosOcultoSaida)
        .map(sigmoide)
        .toList();
    return saidaFinal;
  }

  // Função para multiplicar matrizes
  List<double> multiplicarMatriz(List<double> vetor, List<List<double>> matriz) {
    List<double> resultado = [];
    for (var j = 0; j < matriz[0].length; j++) {
      double soma = 0;
      for (var i = 0; i < vetor.length; i++) {
        soma += vetor[i] * matriz[i][j];
      }
      resultado.add(soma);
    }
    return resultado;
  }
}

void main() {
  // Definindo a rede neural
  var rede = RedeNeural(38, 96, 10);

  // Entrada de teste (número 3, por exemplo)
  List<List<int>> numeroParaTestar = [
    [1, 1, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 1, 0],
    [0, 0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 0]
  ];

  // Achatando a matriz de entrada
  var entradaTeste = numeroParaTestar.expand((i) => i).toList();

  // Convertendo para double
  List<double> entradaTesteDouble =
      entradaTeste.map((e) => e.toDouble()).toList();

  // Executar feedforward
  var resultado = rede.feedforward(entradaTesteDouble);

  print("Resultado bruto da rede: $resultado");

  // Arredondando os valores para 0 ou 1
  var resultadoArredondado =
      resultado.map((valor) => valor >= 0.5 ? 1 : 0).toList();

  print("Resultado após arredondar: $resultadoArredondado");

  // Encontrar o índice do valor 1 (ou o índice com o maior valor)
  var indice = resultadoArredondado.indexOf(1);

  if (indice == -1) {
    // Se não houver 1 exato, encontrar o valor mais próximo de 1
    indice = resultado.indexOf(resultado.reduce(max));
  }

  print("A rede identificou o número: $indice");
}