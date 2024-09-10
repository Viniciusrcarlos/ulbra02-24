class RedeNeural {
    constructor(tamanhoEntrada, tamanhoOculto, tamanhoSaida) {
        this.tamanhoEntrada = tamanhoEntrada;
        this.tamanhoOculto = tamanhoOculto;
        this.tamanhoSaida = tamanhoSaida;

        // Inicializando pesos aleatórios para a camada oculta e a camada de saída
        this.pesosEntradaOculto = this.inicializarPesos(tamanhoEntrada, tamanhoOculto);
        this.pesosOcultoSaida = this.inicializarPesos(tamanhoOculto, tamanhoSaida);
    }

    // Função para inicializar os pesos com valores aleatórios
    inicializarPesos(linhas, colunas) {
        let pesos = [];
        for (let i = 0; i < linhas; i++) {
            let linhaPesos = [];
            for (let j = 0; j < colunas; j++) {
                linhaPesos.push(Math.random() * 2 - 1); // valores entre -1 e 1
            }
            pesos.push(linhaPesos);
        }
        return pesos;
    }

    // Função sigmóide e sua derivada
    sigmoide(x) {
        return 1 / (1 + Math.exp(-x));
    }

    derivadaSigmoide(x) {
        return x * (1 - x);
    }

    // Feedforward: Propagação das entradas através da rede
    feedforward(entrada) {
        this.entrada = entrada;

        // Camada oculta
        this.saidaOculta = this.multiplicarMatriz(entrada, this.pesosEntradaOculto).map(this.sigmoide);

        // Camada de saída
        this.saidaFinal = this.multiplicarMatriz(this.saidaOculta, this.pesosOcultoSaida).map(this.sigmoide);

        return this.saidaFinal;
    }

    // Backpropagation: Ajuste dos pesos com base no erro
    treinar(entrada, saidaEsperada, taxaAprendizagem) {
        this.feedforward(entrada);

        // Calculando o erro da camada de saída
        let erroSaida = [];
        for (let i = 0; i < saidaEsperada.length; i++) {
            erroSaida.push(saidaEsperada[i] - this.saidaFinal[i]);
        }

        // Calculando os ajustes para os pesos da camada de saída
        let ajustesSaida = [];
        for (let i = 0; i < erroSaida.length; i++) {
            ajustesSaida.push(erroSaida[i] * this.derivadaSigmoide(this.saidaFinal[i]));
        }

        // Ajuste dos pesos da camada oculta para a camada de saída
        for (let i = 0; i < this.pesosOcultoSaida.length; i++) {
            for (let j = 0; j < this.pesosOcultoSaida[i].length; j++) {
                this.pesosOcultoSaida[i][j] += taxaAprendizagem * ajustesSaida[j] * this.saidaOculta[i];
            }
        }

        // Calculando o erro da camada oculta
        let erroOculto = [];
        for (let i = 0; i < this.pesosOcultoSaida.length; i++) {
            let erro = 0;
            for (let j = 0; j < ajustesSaida.length; j++) {
                erro += ajustesSaida[j] * this.pesosOcultoSaida[i][j];
            }
            erroOculto.push(erro);
        }

        // Calculando os ajustes para os pesos da camada de entrada para a camada oculta
        let ajustesOculto = [];
        for (let i = 0; i < erroOculto.length; i++) {
            ajustesOculto.push(erroOculto[i] * this.derivadaSigmoide(this.saidaOculta[i]));
        }

        // Ajuste dos pesos da camada de entrada para a camada oculta
        for (let i = 0; i < this.pesosEntradaOculto.length; i++) {
            for (let j = 0; j < this.pesosEntradaOculto[i].length; j++) {
                this.pesosEntradaOculto[i][j] += taxaAprendizagem * ajustesOculto[j] * entrada[i];
            }
        }
    }

    // Função auxiliar para multiplicar matrizes
    multiplicarMatriz(vetor, matriz) {
        let resultado = [];
        for (let j = 0; j < matriz[0].length; j++) {
            let soma = 0;
            for (let i = 0; i < vetor.length; i++) {
                soma += vetor[i] * matriz[i][j];
            }
            resultado.push(soma);
        }
        return resultado;
    }
}

// Exemplo de uso

// Criando uma rede neural com 3 neurônios na entrada, 4 na camada oculta e 1 na saída
let rede = new RedeNeural(3, 4, 1);

// Dados de treinamento: entradas e saídas esperadas
let treinamento = [
    { entrada: [0, 0, 0], saida: [0] },
    { entrada: [0, 0, 1], saida: [0] },
    { entrada: [0, 1, 0], saida: [0] },
    { entrada: [0, 1, 1], saida: [0] },
    { entrada: [1, 0, 0], saida: [1] },
    { entrada: [1, 0, 1], saida: [1] },
    { entrada: [1, 1, 0], saida: [1] },
    { entrada: [1, 1, 1], saida: [1] }
];

// Treinando a rede
for (let i = 0; i < 10000; i++) {  // 10.000 iterações de treinamento
    for (let dados of treinamento) {
        rede.treinar(dados.entrada, dados.saida, 0.1);
    }
}

// Testando a rede
console.log(rede.feedforward([0, 0, 0]));  // Espera-se uma saída próxima de 0
console.log(rede.feedforward([1, 1, 1]));  // Espera-se uma saída próxima de 1