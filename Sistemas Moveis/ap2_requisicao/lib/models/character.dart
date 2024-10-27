class Character {
  final String name;
  final String image;


  const Character({required this.name, required this.image});

  factory Character.fromJson(Map<String, dynamic> json){
    return Character(name: json["name"], image: json["image"]);
  }

}