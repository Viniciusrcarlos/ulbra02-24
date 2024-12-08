class Casa {
    String nome;
    Casa proxima; // Referência para a próxima casa na lista ligada

    public Casa(String nome) {
        this.nome = nome;
        this.proxima = null;
    }
}
