let x11 = 0, x12 = 0, resultado1 = 0
let x21 = 0, x22 = 1, resultado2 = 0
let x31 = 1, x32 = 0, resultado3 = 1
let x41 = 1, x42 = 1, resultado4 = 1

let p1 = -1, p2 = -1

let soma, ajustes, quantidadeAjustesTotais = 0
let repeticoes = 0

do {
    ajustes = 0

    soma = somar(x11, x12)
    y = transferencia(soma)
    if (y != resultado1) {
        ajustar(x11, x12, resultado1, y)
        ajustes++
        quantidadeAjustesTotais++
    }


    soma = somar(x21, x22)
    y = transferencia(soma)
    if (y != resultado2) {
        ajustar(x21, x22, resultado2, y)
        ajustes++
        quantidadeAjustesTotais++
    }


    soma = somar(x31, x32)
    y = transferencia(soma)
    if (y != resultado3) {
        ajustar(x31, x32, resultado3, y)
        ajustes++
        quantidadeAjustesTotais++
    }


    soma = somar(x41, x42)
    y = transferencia(soma)
    if (y != resultado4) {
        ajustar(x41, x42, resultado4, y)
        ajustes++
        quantidadeAjustesTotais++
    }


} while (ajustes != 0)

console.log("Rede Neural");
console.log("\nPeso 1: " + p1);
console.log("\nPeso 2: " + p2);
console.log("\nQuantidade de ajustes: " + quantidadeAjustesTotais);

function somar(x1, x2) {
    return (x1*p1) + (x2*p2)
}

function transferencia() {
    return soma <= 0 ? 0 : 1;
}

function ajustar(entrada1, entrada2, resultadoEsperado, resultadoObtido) {
    p1 = p1 + 1 * (resultadoEsperado - resultadoObtido) * entrada1
    p2 = p2 + 1 * (resultadoEsperado - resultadoObtido) * entrada2
}