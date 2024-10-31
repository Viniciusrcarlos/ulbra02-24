import 'dart:convert';

import 'package:ap2_requisicao/constants.dart';
import 'package:ap2_requisicao/models/pokemon.dart';
import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

class PokemonService {

  Future<List<Pokemon>> getPokemons () async {
    final response = await http.get(Uri.parse(BASE_URL));

    //debugPrint(response.statusCode.toString());

    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body)['results'];
      List<Pokemon> pokemaos = jsonResponse.map((item) => Pokemon.fromJson(item)).toList();
      return pokemaos;
    } else {
      throw Exception("Erro ao buscar os personagens.");
    }
  }
}