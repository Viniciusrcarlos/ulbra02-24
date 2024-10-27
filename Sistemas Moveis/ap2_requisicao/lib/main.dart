import 'package:ap2_requisicao/models/character.dart';
import 'package:ap2_requisicao/services/character_service.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CharacterService service = CharacterService();
  late Future<List<Character>> personagens_future;

  late List<Character> personagens;
  late List<Character> personagensFiltrados;

  @override
  void initState() {
    super.initState();
    personagens_future = service.getCharacters();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.deepPurple,
        title: const Text(
          "Consumo de uma API",
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
      ),
      body: FutureBuilder<List<Character>>(
        future: personagens_future,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            return Expanded(
              child: ListView.separated(
                  itemBuilder: (context, index) {
                    return ListTile(
                      title: Text(snapshot.data![index].name),
                      leading: Image.network(snapshot.data![index].image),
                    );
                  },
                  separatorBuilder: (context, int) {
                    return Divider();
                  },
                  itemCount: snapshot.data!.length),
            );
          }
          if (snapshot.hasError) {
            return Text("Erro ao buscar characters");
          }

          return Center(child: CircularProgressIndicator());
        },
      ),
    ));
  }
}