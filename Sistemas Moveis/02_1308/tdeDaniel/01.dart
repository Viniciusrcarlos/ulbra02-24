void main(List<String> args) {
  List<int> numeros = [10, 15, 20, 25, 30];

  if (numeros.isEmpty) {
    print("A lista está vazia");
  } else {
    int soma = 0;
    for (int numero in numeros) {
      soma += numero;
    }
    double media = soma / numeros.length;
    print("A média é: $media");
  }
}
