import 'package:ap2_requisicao/models/pokemon.dart';
import 'package:ap2_requisicao/services/pokemon_service.dart';
import 'package:flutter/material.dart';
import 'package:svg_pic_editor/svg_pic_editor.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  PokemonService service = PokemonService();
  late Future<List<Pokemon>> futureCharacters;
  late List<Pokemon> characters;
  late List<Pokemon> filteredCharacters;

  @override
  void initState() {
    super.initState();
    futureCharacters = getCharactersForApi();
  }

  Future<List<Pokemon>> getCharactersForApi() async {
    characters = await service.getPokemons();
    filteredCharacters = characters;
    return characters;
  }

  filterCharacters(String filter) {
    setState(() {
      filteredCharacters = characters
          .where(
              (item) => item.name.toLowerCase().contains(filter.toLowerCase()))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.deepPurple,
            title: const Text(
              "Consumo de uma API",
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          body: Column(
            children: [
              Padding(
                padding: const EdgeInsets.all(
                  8.0,
                ),
                child: TextField(
                  onChanged: (value) {
                    filterCharacters(value);
                  },
                  decoration: const InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: "Filtro",
                  ),
                ),
              ),
          FutureBuilder<List<Pokemon>>(
            future: futureCharacters,
            builder: (
              context,
              snapshot,
            ) {
              if (snapshot.hasData) {
                return Expanded(
                  child: ListView.separated(
                      itemBuilder: (
                        context,
                        index,
                      ) {
                        return ListTile(
                          title: Text(filteredCharacters[index].name),
                          leading: SvgPicEditor.network(
                              width: 60,
                              filteredCharacters[index].img),
                        );
                      },
                      separatorBuilder: (context, int) {
                        return const Divider();
                      },
                      itemCount: filteredCharacters.length),
                );
              }
              if (snapshot.hasError) {
                return const Text("Erro ao buscar characters aaa");
              }

              return const Center(child: CircularProgressIndicator());
            },
          ),
        ],
      ),
    ));
  }
}
