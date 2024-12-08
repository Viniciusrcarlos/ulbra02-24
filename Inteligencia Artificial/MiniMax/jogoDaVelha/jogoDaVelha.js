const prompt = require("prompt-sync")();

function inicializarTabuleiro() {
    return [" ", " ", " ", " ", " ", " ", " ", " ", " "];
}

function mostrarTabuleiro(tabuleiro) {
    console.clear();
    console.log(`${tabuleiro[0]} | ${tabuleiro[1]} | ${tabuleiro[2]}`);
    console.log("--+---+--");
    console.log(`${tabuleiro[3]} | ${tabuleiro[4]} | ${tabuleiro[5]}`);
    console.log("--+---+--");
    console.log(`${tabuleiro[6]} | ${tabuleiro[7]} | ${tabuleiro[8]}`);
} 

function checarVitoria(tabuleiro, jogador) {
    const combinacoesDeVitoria = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],
        [0, 3, 6], [1, 4, 7], [2, 5, 8],
        [0, 4, 8], [2, 4, 6]
    ]

    return combinacoesDeVitoria.some(combinacao => 
        combinacao.every(indice => 
        tabuleiro[indice]) === jogador);

}

function movimentosRestantes(tabuleiro) {
    return tabuleiro.some(celula => celula === " ");
}

function avaliarEstado(tabuleiro) {
    let score = 0;

    const linhas = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],
        [0, 3, 6], [1, 4, 7], [2, 5, 8],
        [0, 4, 8], [2, 4, 6]
    ]

    linhas.forEach(linha => {
        let [a, b, c] = linha;

        if (tabuleiro[a] === "X" && tabuleiro[b] === "X" && tabuleiro[c] === " ") {
            score += 10;
        }
        if (tabuleiro[a] === "O" && tabuleiro[b] === "O" && tabuleiro[c] === " ") {
            score -= 10;
        }
    })

}

let tabuleiro = inicializarTabuleiro();
mostrarTabuleiro(tabuleiro);

let movimento = parseInt(prompt("Escolha sua posição de 0 a 8: "));

console.log("Posição escolhida: " + movimento);