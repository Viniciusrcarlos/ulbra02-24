import 'dart:math';

import 'package:flutter/material.dart';
import 'package:tde_aula_10/widgets/languages_widget.dart';

class MyHomePage extends StatefulWidget {
  final String title;

  const MyHomePage({super.key, required this.title});

  @override
  State<StatefulWidget> createState() => _MyHomePage();
}



class _MyHomePage extends State<MyHomePage> {
  late Color _appBarColor; // inicializacao tardia
  final TextEditingController _controller = TextEditingController();
  String _filter = "";

  _changeColorAppBar() {
    _appBarColor = Colors.primaries[Random().nextInt(Colors.primaries.length)];
  }

  @override
  void initState() {
    super.initState();
    _appBarColor = Colors.red;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
              shape: const RoundedRectangleBorder(
                borderRadius: BorderRadius.vertical(
                  bottom: Radius.circular(20),
                ),
              ),
              toolbarHeight: 70,
              backgroundColor: _appBarColor,
              title: Text(
                widget.title,
                style: const TextStyle(color: Colors.black),
              ),
              actions: [
                IconButton(
                    onPressed: () {
                      setState(() {
                        _changeColorAppBar();
                      });
                    },
                    icon: const Icon(
                      Icons.color_lens_outlined,
                      size: 32,
                      color: Colors.black,
                    ))
              ],
            ),
            body: Languages(filter: _filter,),
            bottomSheet: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Row(
                children: [
                  Expanded(
                      child: TextField(
                          controller: _controller,
                          onChanged: (Text) {
                            _controller.text = Text;
                          },
                          decoration: const InputDecoration(
                              border: OutlineInputBorder(),
                              hintText: "Filtro",
                              label: Text("Filtro")),
                        )),
                  ElevatedButton(
                      onPressed: () {
                        setState(() {
                          _filter = _controller.text;
                        });
                      },
                      child: const Text("Filtrar"))
                ],
              ),
            )));
  }
}
