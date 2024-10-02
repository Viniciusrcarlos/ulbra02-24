import 'dart:ffi';

void main(List<String> args) {

  
  

}

int calc(int a, int b, String operacao) {
  
  int resultado = 0;
  
  switch (operacao) {
    case "+":
      resultado =  a + b;
      break;
    case "-":
      resultado =  a - b;
      break;
    case "*":
      resultado = a * b;
      break;
    case "/":
      resultado = a ~/ b;
      break;
    default:
      resultado = 0;
      break;
  }

  return resultado;
}

List<int> listaDobro(List<int> lista) {

  for (int i = 0; i < lista.length; i++) {
    lista[i] = lista[i] * 2;
  }


  return lista;
}

List listaPares(List<int> lista) {

  var listaNova = [];

  for (int i = 0; i < lista.length; i++) {
    if ((lista[i] % 2) != 1) {
      listaNova.add(lista[i]);
    }
  }

  return listaNova;
  
}




