const tamanhoPopulacao = 500;
const mutationRate = 0.01; // 1%
const geracoes = 100;

let cidades = [
    [-5, -5], // Curitiba
    [-2, -3],
    [3, -3],
    [-3, -2],
    [1, 0],
    [4, 2],
    [5, 5],
    [2, 4],
    [-1, 4],
    [-5, 5]
];

// Cálculo da distância entre dois pontos
function calculoDistanciaEntrPontos(cidadeA, cidadeB) {
    return Math.sqrt(Math.pow((cidadeB[0] - cidadeA[0]), 2) + Math.pow((cidadeB[1] - cidadeA[1]), 2));
}

// Função para criar um novo indivíduo (rota aleatória)
function criarIndividuo() {
    let individuo = [];
    let listaCidades = JSON.parse(JSON.stringify(cidades));
    while (listaCidades.length > 0) {
        const cidadeEscolhida = Math.floor(Math.random() * listaCidades.length);
        individuo.push(listaCidades[cidadeEscolhida]);
        listaCidades.splice(cidadeEscolhida, 1);
    }
    return individuo;
}

// Função para criar uma população inicial
function criarPopulacao(tamanho) {
    const populacao = [];
    for (let i = 0; i < tamanho; i++) {
        populacao.push(criarIndividuo());
    }
    return populacao;
}

// Função de aptidão (fitness)
function aptidao(individuo) {
    let distancia = 0.0;
    for (let i = 0; i < individuo.length - 1; i++) {
        distancia += calculoDistanciaEntrPontos(individuo[i], individuo[i + 1]);
    }
    distancia += calculoDistanciaEntrPontos(individuo[individuo.length - 1], individuo[0]); // Retorno à cidade inicial
    return 1 / distancia; // Inverso da distância, pois queremos minimizar a distância
}

// Seleção por torneio
function selecao(populacao) {
    const torneio = [];
    for (let i = 0; i < 5; i++) {
        torneio.push(populacao[Math.floor(Math.random() * populacao.length)]);
    }
    torneio.sort((a, b) => aptidao(b) - aptidao(a));
    return torneio[0];
}

// Função de cruzamento (order crossover)
function cruzamento(pai, mae) {
    const pontoInicio = Math.floor(Math.random() * pai.length);
    const pontoFim = Math.floor(Math.random() * (pai.length - pontoInicio)) + pontoInicio;

    const filho = new Array(pai.length).fill(null);
    for (let i = pontoInicio; i < pontoFim; i++) {
        filho[i] = pai[i];
    }

    let pos = pontoFim;
    for (let cidade of mae) {
        if (!filho.includes(cidade)) {
            if (pos >= filho.length) pos = 0;
            filho[pos] = cidade;
            pos++;
        }
    }
    return filho;
}

// Função de mutação (swap mutation)
function mutacao(individuo) {
    for (let i = 0; i < individuo.length; i++) {
        if (Math.random() < mutationRate) {
            const j = Math.floor(Math.random() * individuo.length);
            [individuo[i], individuo[j]] = [individuo[j], individuo[i]];
        }
    }
    return individuo;
}

// Algoritmo Genético
function algoritmoGenetico() {
    let populacao = criarPopulacao(tamanhoPopulacao);

    for (let geracao = 0; geracao < geracoes; geracao++) {
        populacao.sort((a, b) => aptidao(b) - aptidao(a)); // Ordena pela aptidão
        const melhorIndividuo = populacao[0];
        const melhorDistancia = 1 / aptidao(melhorIndividuo);
        console.log(`Geração ${geracao + 1}: Melhor distância: ${melhorDistancia.toFixed(2)}`);

        if (melhorDistancia <= 10) { // Critério de parada
            console.log("Solução satisfatória encontrada!");
            break;
        }

        const novaPopulacao = [];
        while (novaPopulacao.length < tamanhoPopulacao) {
            const pai = selecao(populacao);
            const mae = selecao(populacao);
            let filho = cruzamento(pai, mae);
            filho = mutacao(filho);
            novaPopulacao.push(filho);
        }

        populacao = novaPopulacao; // Atualiza a população com a nova geração
    }

    populacao.sort((a, b) => aptidao(b) - aptidao(a));
    const melhorIndividuoFinal = populacao[0];
    console.log("Melhor rota encontrada:", melhorIndividuoFinal);
    console.log("Distância total:", (1 / aptidao(melhorIndividuoFinal)).toFixed(2));
}

// Executa o algoritmo genético
algoritmoGenetico();
