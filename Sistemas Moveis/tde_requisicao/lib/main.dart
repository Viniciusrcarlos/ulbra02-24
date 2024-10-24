import 'package:flutter/material.dart';
import 'package:tde_requisicao/models/character.dart';
import 'package:tde_requisicao/services/character_service.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CharacterService service = CharacterService()

  late Future<List<Character>> personagens;

  @override
  void initState() {
    super.initState();
    personagens = service.getCharacters();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Lista de personagens"),
        ),
        body: FutureBuilder(
          future: service.getCharacters(),
          initialData: ["Buscando personagens"],
          builder: (context, snapshot) {
            if (snapshot.hasData) {
              return ListView.separated(itemBuilder: (context, index) {
                ListTile(title: snapshot.data![index)
              }, separatorBuilder: (context, int) {
                return Divider();
              }, itemCount: snapshot.data!.length);
            }
          },
        ),
      ),
    );
  }
}
