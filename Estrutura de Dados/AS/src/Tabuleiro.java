class Tabuleiro {
    Casa inicio;

    public void adicionarCasa(Casa novaCasa) {
        if (inicio == null) {
            inicio = novaCasa;
            inicio.proxima = inicio;
        } else {
            Casa temp = inicio;
            while (temp.proxima != inicio) {
                temp = temp.proxima;
            }
            temp.proxima = novaCasa;
            novaCasa.proxima = inicio;
        }
    }

    public Casa buscarCasa(String nome) {
        if (inicio == null) return null;
        Casa temp = inicio;
        do {
            if (temp.nome.equalsIgnoreCase(nome)) {
                return temp;
            }
            temp = temp.proxima;
        } while (temp != inicio);
        return null;
    }

    public void imprimirTabuleiro() {
        if (inicio == null) return;
        System.out.println("\n[Tabuleiro]");
        Casa temp = inicio;
        do {
            System.out.println("- " + temp.nome + " (" + temp.tipo + ")");
            temp = temp.proxima;
        } while (temp != inicio);
    }
}
