const cidades = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
]; // matriz de distâncias entre cidades

const numCidades = cidades.length;
const tamanhoPopulacao = 5000;
const taxaMutacao = 0.01;
const maxGeracoes = 100;

// Função para criar um indivíduo (permutação das cidades)
function criarIndividuo() {
    const individuo = Array.from({ length: numCidades }, (_, i) => i);
    for (let i = numCidades - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [individuo[i], individuo[j]] = [individuo[j], individuo[i]]; // Embaralha as cidades
    }
    return individuo;
}

// Função para criar a população inicial
function criarPopulacao(tamanhoPopulacao) {
    const populacao = [];
    for (let i = 0; i < tamanhoPopulacao; i++) {
        populacao.push(criarIndividuo());
    }
    return populacao;
}

// Função de aptidão (soma das distâncias percorridas no percurso)
function aptidao(individuo) {
    let distanciaTotal = 0;
    for (let i = 0; i < individuo.length - 1; i++) {
        distanciaTotal += cidades[individuo[i]][individuo[i + 1]];
    }
    distanciaTotal += cidades[individuo[individuo.length - 1]][individuo[0]]; // Retorno ao ponto de partida
    return 1 / distanciaTotal; // Aptidão inversamente proporcional à distância (quanto menor, melhor)
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

// Cruzamento de dois indivíduos
function cruzamento(individuo1, individuo2) {
    const pontoInicio = Math.floor(Math.random() * individuo1.length);
    const pontoFim = Math.floor(Math.random() * (individuo1.length - pontoInicio)) + pontoInicio;
    const filho = Array(individuo1.length).fill(null);

    // Copia segmento de individuo1
    for (let i = pontoInicio; i < pontoFim; i++) {
        filho[i] = individuo1[i];
    }

    // Preenche o resto das cidades em ordem a partir de individuo2
    let idx = 0;
    for (let i = 0; i < individuo2.length; i++) {
        const cidade = individuo2[i];
        if (!filho.includes(cidade)) {
            while (filho[idx] !== null) idx++;
            filho[idx] = cidade;
        }
    }

    return filho;
}

// Mutação por troca de duas cidades
function mutacao(individuo) {
    for (let i = 0; i < individuo.length; i++) {
        if (Math.random() < taxaMutacao) {
            const j = Math.floor(Math.random() * individuo.length);
            [individuo[i], individuo[j]] = [individuo[j], individuo[i]];
        }
    }
    return individuo;
}

// Função principal do algoritmo genético
function algoritmoGenetico() {
    let populacao = criarPopulacao(tamanhoPopulacao);

    for (let geracao = 0; geracao < maxGeracoes; geracao++) {
        populacao.sort((a, b) => aptidao(b) - aptidao(a));
        const melhorIndividuo = populacao[0];
        console.log(`Geração ${geracao}, Melhor percurso: ${melhorIndividuo}, Distância: ${1 / aptidao(melhorIndividuo)}`);

        if (1 / aptidao(melhorIndividuo) < 10) { // ou outro valor que represente uma boa solução
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

        populacao = novaPopulacao; // Atualiza a população
    }
}

algoritmoGenetico();
