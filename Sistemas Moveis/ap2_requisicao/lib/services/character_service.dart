import 'dart:convert';

import 'package:ap2_requisicao/constants.dart';
import 'package:ap2_requisicao/models/character.dart';
import 'package:http/http.dart' as http;

class CharacterService {

  Future<List<Character>> getCharacters () async {
    final response = await http.get(Uri.parse('$BASE_URL/character'));

    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body)['results'];
      return jsonResponse.map((item) => Character.fromJson(item)).toList();
    } else {
      throw Exception("Erro ao buscar os personagens.");
    }
  }
}