import 'package:firebase_tde/services/auth_service.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  final AuthService authService;

  const HomeScreen({super.key, required this.authService});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Home"),
        actions: [
          IconButton(
            onPressed: () {
              authService.logout(context);
            },
            icon: const Icon(Icons.logout),
          ),
        ],
      ),
      body: const Text("Home"),
    );
  }
}
