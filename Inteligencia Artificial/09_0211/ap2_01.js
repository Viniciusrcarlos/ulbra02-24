const tamanhoPopulacao = 500;
const mutationRate = 0.01;//1%
const geracoes = 1000;

let cidades = [
    [-5,-5],//curitiba
    [-2,-3],
    [3,-3],
    [-3,-2],
    [1, 0],
    [4, 2],
    [5, 5],
    [2, 4],
    [-1, 4],
    [-5, 5]
];

//Calculo entre pontos
function calculoDistanciaEntrPontos(cidadeA, cidadeB)
{
    let d = Math.sqrt(Math.pow((cidadeB[0] - cidadeA[0]), 2) +  Math.pow((cidadeB[1] - cidadeA[1]),2));
    return d;
}

//Função para criar um novo elemento
function criarIndividuo()
{
    let individuo = [];
    let listaCidades = JSON.parse(JSON.stringify(cidades));
    for (let i = 0; i < cidades.length; i++) {
        cidadeEscolhida = Math.floor(Math.random() * listaCidades.length);
        individuo.push(listaCidades[cidadeEscolhida]);
        listaCidades.splice(cidadeEscolhida, 1);
    }

    return individuo;
}

//Função para criar um conjunto de elementos
function criarPopulacao(tamanho)
{
    const populacao = [];
    for (let i = 0; i < tamanho; i++) {
        populacao.push(criarIndividuo());
    }

    return populacao;
}

//Função fitness
function aptidao(individuo)
{
    let distancia = 0.0;
    for (let i = 0; i < individuo.length; i++) {
        let proximoIndice = i+1;
        if(proximoIndice >=  individuo.length) {
            proximoIndice = 0;
        }

        distancia += calculoDistanciaEntrPontos(individuo[i], individuo[proximoIndice]);
    }
    return 100 / distancia;
}



let individuos = criarPopulacao(500);

individuos.forEach(individuo => {
    let resultado = aptidao(individuo);
    console.log(resultado);
});