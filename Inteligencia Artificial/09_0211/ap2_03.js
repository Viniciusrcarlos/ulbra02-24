const tamanhoPopulacao = 500;
const mutationRate = 0.01;
const geracoes = 100;

let cidades = [
    [-4, 5], 
    [-1, 4],
    [-3, 3],
    [2, 5],
    [1, 1],
    [5, 1],
    [3, -4],
    [-3, -3],
    [-4, -5],
    [-2, -2]
];

function calculoDistanciaEntrePontos(cidadeA, cidadeB) {
    return Math.sqrt(Math.pow((cidadeB[0] - cidadeA[0]), 2) + Math.pow((cidadeB[1] - cidadeA[1]), 2));
}

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

function criarPopulacao(tamanho) {
    const populacao = [];
    for (let i = 0; i < tamanho; i++) {
        populacao.push(criarIndividuo());
    }
    return populacao;
}

function aptidao(individuo) {
    let distancia = 0.0;
    for (let i = 0; i < individuo.length - 1; i++) {
        distancia += calculoDistanciaEntrePontos(individuo[i], individuo[i + 1]);
    }
    distancia += calculoDistanciaEntrePontos(individuo[individuo.length - 1], individuo[0]);
    return 1 / distancia;
}

function selecao(populacao) {
    const torneio = [];
    for (let i = 0; i < 5; i++) {
        torneio.push(populacao[Math.floor(Math.random() * populacao.length)]);
    }
    torneio.sort((a, b) => aptidao(b) - aptidao(a));
    return torneio[0];
}

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

function mutacao(individuo) {
    for (let i = 0; i < individuo.length; i++) {
        if (Math.random() < mutationRate) {
            const j = Math.floor(Math.random() * individuo.length);
            [individuo[i], individuo[j]] = [individuo[j], individuo[i]];
        }
    }
    return individuo;
}

function algoritmoGenetico() {
    let populacao = criarPopulacao(tamanhoPopulacao);

    for (let geracao = 0; geracao < geracoes; geracao++) {
        populacao.sort((a, b) => aptidao(b) - aptidao(a)); 
        const melhorIndividuo = populacao[0];
        const melhorDistancia = 1 / aptidao(melhorIndividuo);
        console.log(`Geração ${geracao + 1}: Melhor distância: ${melhorDistancia.toFixed(2)}`);

        if (melhorDistancia <= 10) {
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

        populacao = novaPopulacao;
    }

    populacao.sort((a, b) => aptidao(b) - aptidao(a));
    const melhorIndividuoFinal = populacao[0];
    console.log("Melhor rota encontrada:", melhorIndividuoFinal);
    console.log("Distância total:", (1 / aptidao(melhorIndividuoFinal)).toFixed(2));
}

algoritmoGenetico();