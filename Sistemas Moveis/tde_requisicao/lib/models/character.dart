class Character {
  final String name;
  final String img;

  const Character({required this.name, required this.img});

  factory Character.fromJson(Map<String, dynamic> json) {
    return Character(name: json["name"], img: json["image"]);
  }
}