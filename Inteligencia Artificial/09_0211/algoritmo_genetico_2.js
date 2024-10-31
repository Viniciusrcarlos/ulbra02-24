const objetivo = "Vinicius";
const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
const tamanhoPopulacao = 500;
const mutationRate = 0.01;
const geracoes = 1000;

function criarIndividuo() {
    let individuo = "";
    for (let i = 0; i < objetivo.length; i++) {
        individuo += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    }
    return individuo;
}

function criarPopulacao(tamanho) {
    return Array.from({ length: tamanho }, criarIndividuo);
}

function aptidao(individuo) {
    return individuo.split('').reduce((pontos, char, i) => 
        char === objetivo[i] ? pontos + 1 : pontos, 0);
}

function selecaoPorRoleta(populacao) {
    const totalFitness = populacao.reduce((sum, ind) => sum + aptidao(ind), 0);
    const pickFitness = Math.random() * totalFitness;

    let acumulador = 0;
    for (const individuo of populacao) {
        acumulador += aptidao(individuo);
        if (acumulador >= pickFitness) {
            return individuo;
        }
    }
    return populacao[0]; // fallback
}

function cruzamento(individuo1, individuo2) {
    const pontoDeCorte = Math.floor(Math.random() * objetivo.length);
    return individuo1.slice(0, pontoDeCorte) + individuo2.slice(pontoDeCorte);
}

function mutacao(individuo) {
    return individuo.split('').map(char => 
        Math.random() < mutationRate ? caracteres.charAt(Math.floor(Math.random() * caracteres.length)) : char
    ).join('');
}

function algoritmoGenetico() {
    let populacao = criarPopulacao(tamanhoPopulacao);

    for (let geracao = 0; geracao < geracoes; geracao++) {
        populacao.sort((a, b) => aptidao(b) - aptidao(a));
        const melhorIndividuo = populacao[0];

        console.log(`Geração ${geracao}, Melhor: ${melhorIndividuo}, Aptidão: ${aptidao(melhorIndividuo)}`);

        if (aptidao(melhorIndividuo) === objetivo.length) {
            console.log("Solução encontrada!");
            break;
        }

        const novaPopulacao = [];
        while (novaPopulacao.length < tamanhoPopulacao) {
            const pai = selecaoPorRoleta(populacao);
            const mae = selecaoPorRoleta(populacao);
            let filho = cruzamento(pai, mae);
            filho = mutacao(filho);
            novaPopulacao.push(filho);
        }

        populacao = novaPopulacao;
    }
}

algoritmoGenetico();
