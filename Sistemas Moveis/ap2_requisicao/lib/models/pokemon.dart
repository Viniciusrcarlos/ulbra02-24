class Pokemon {
  final String name;
  String img;
  final String url;

  Pokemon({required this.name, required this.img, required this.url});

  factory Pokemon.fromJson(Map<String, dynamic> json) {
    return Pokemon(
      name: json["name"],
      img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${
        json["url"].toString().split("/")[6]
      }.svg",
      url: json["url"],
    );
  }
}
