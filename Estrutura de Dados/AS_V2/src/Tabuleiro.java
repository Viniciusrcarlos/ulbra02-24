public class Tabuleiro {
    private Casa inicio;
    private int totalCasas;

    public Tabuleiro() {
        this.inicio = null;
        this.totalCasas = 0;
    }

    public void adicionarCasa(String nome, String tipo, double precoCompra, double precoAluguel) {
        Casa novaCasa = new Casa(nome, tipo, precoCompra, precoAluguel);

        if (inicio == null) {
            inicio = novaCasa;
            inicio.setProxima(inicio);
        } else {
            Casa atual = inicio;
            while (atual.getProxima() != inicio) {
                atual = atual.getProxima();
            }
            atual.setProxima(novaCasa);
            novaCasa.setProxima(inicio);
        }
        totalCasas++;
    }

    public void exibirTabuleiro() {
        if (inicio == null) {
            System.out.println("O tabuleiro está vazio.");
            return;
        }

        Casa atual = inicio;
        do {
            System.out.println("Casa: " + atual.getNome() + " | Tipo: " + atual.getTipo());
            atual = atual.getProxima();
        } while (atual != inicio);
    }

    public int getTotalCasas() {
        return totalCasas;
    }

    public Casa getInicio() {
        return inicio;
    }
}
