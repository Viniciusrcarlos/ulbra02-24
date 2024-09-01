class Pessoa {
  final String nome;
  final int idade;

  Pessoa({required this.nome, required this.idade});

  factory Pessoa.fromJson(Map<String, dynamic> json) {
    return Pessoa(
      nome: json['nome'] as String,
      idade: json['idade'] as int,
    );
  }
}

void main() {
  final jsonPessoa = {
    'nome': 'João',
    'idade': 30,
  };

  final JsonP2 = {
    'nome': 'vini',
    'idade': 20
  };

  final p1 = Pessoa.fromJson(JsonP2);
  final p2 = Pessoa.fromJson(jsonPessoa);

  print(p1.nome);
  print(p1.idade);

  print(p2.nome); 
  print(p2.idade);
}