public class Casa {
    private String nome;
    private String tipo;
    private double precoCompra;
    private double precoAluguel;
    private Casa proxima;

    public Casa(String nome, String tipo, double precoCompra, double precoAluguel) {
        this.nome = nome;
        this.tipo = tipo;
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
        this.proxima = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Casa getProxima() {
        return proxima;
    }

    public void setProxima(Casa proxima) {
        this.proxima = proxima;
    }
}
