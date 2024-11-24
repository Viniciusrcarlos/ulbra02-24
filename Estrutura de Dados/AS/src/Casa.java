class Casa {
    String nome;
    TipoCasa tipo;
    double valor;
    Jogador proprietario;
    Casa proxima;

    public Casa(String nome, TipoCasa tipo, double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.proprietario = null;
        this.proxima = null;
    }

    public boolean disponivelParaCompra() {
        return tipo == TipoCasa.IMOVEL && proprietario == null;
    }

    public double calcularAluguel() {
        return valor * 0.1;
    }
}
