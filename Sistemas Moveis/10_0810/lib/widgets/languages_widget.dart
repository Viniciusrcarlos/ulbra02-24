import 'package:flutter/material.dart';

List<String> languages = [
  'Dart',
  'Java',
  'Kotlin',
  'Swift',
  'Objective-C',
  'JavaScript',
  'Python',
  'C#',
  'C++',
  'Ruby',
  'Go',
  'Rust',
  'PHP',
  'TypeScript',
  'CSS',
  'SQL',
  'Shell',
  'Scala',
  'R',
  'Perl',
  'Haskell',
  'Lua',
  'Julia',
  'Groovy',
];

List<String> languagesSubtitle = [
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Você não',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
  'Melhor linguagem do mundo!',
];

class Languages extends StatefulWidget {
  final String filter;
  const Languages({super.key, required this.filter});

  _filterLanguages() {
    return languages.where((element) => element.toLowerCase().contains(filter.toLowerCase())).toList();
  }

  @override
  State<Languages> createState() => _LanguageState();

}


class _LanguageState extends State<Languages> {
  List<String> languagesFiltered = [];

  @override
  void didUpdateWidget(Languages oldWidget) {
    if (oldWidget.filter != widget.filter) {
      languagesFiltered = widget._filterLanguages();
    }
    super.didUpdateWidget(oldWidget);
  }

  @override
  void initState() {
    languagesFiltered = widget._filterLanguages();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 90, top: 5),
      child: ListView.separated(
          itemBuilder: (BuildContext context, int indexLanguages) {
            return ListTile(
              leading: Icon(Icons.computer),
              title: Text(languagesFiltered[indexLanguages]),
              subtitle: Text(languagesSubtitle[indexLanguages]),
            );
          },
          separatorBuilder: (BuildContext context, int indexLanguages) {
            return const Divider();
          },
          itemCount: languagesFiltered.length),
    );
  }
}