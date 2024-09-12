/* Crie uma função javascript que receba uma lista inteiros como parâmetro e 
diga qual número é par e qual é ímpar. */

function parOuImpar(numeros) {
    numeros.forEach(numero => {
        if (numero % 2 === 0) {
            console.log(`${numero} é par`);
        } else {
            console.log(`${numero} é ímpar`);
        }
    });
}

const listaNumeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
parOuImpar(listaNumeros)