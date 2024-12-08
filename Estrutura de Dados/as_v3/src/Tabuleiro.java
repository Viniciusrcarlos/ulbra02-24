import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Tabuleiro {
    Casa inicio;
    List<Imovel> listaImoveis;
    Random random;

    public Tabuleiro() {
        listaImoveis = new ArrayList<>();
        // Criar as casas do tabuleiro
        Casa casaInicio = new Casa("Início");
        Casa casaImovel1 = new Casa("Imóvel 1");
        Casa casaImposto = new Casa("Imposto");
        Casa casaRestituicao = new Casa("Restituição");
        Casa casaImovel2 = new Casa("Imóvel 2");

        // Conectar as casas de forma circular
        casaInicio.proxima = casaImovel1;
        casaImovel1.proxima = casaImposto;
        casaImposto.proxima = casaRestituicao;
        casaRestituicao.proxima = casaImovel2;
        casaImovel2.proxima = casaInicio;

        // Definir o início do tabuleiro
        this.inicio = casaInicio;

        // Inicializar o gerador de números aleatórios
        random = new Random();
    }

    public int lancarDado() {
        return random.nextInt(6) + 1; // Lança um dado (1 a 6)
    }

    public void cadastrarImovel(String nome, int preco, int aluguel) {
        if (listaImoveis.size() < 40) {
            Imovel imovel = new Imovel(nome, preco, aluguel);
            listaImoveis.add(imovel);
            System.out.println("Imóvel cadastrado: " + nome);
        } else {
            System.out.println("Limite máximo de imóveis atingido.");
        }
    }

    public void listarImoveis() {
        for (Imovel imovel : listaImoveis) {
            System.out.println("Nome: " + imovel.nome + ", Preço: " + imovel.preco + ", Aluguel: " + imovel.aluguel);
        }
    }

    public void atualizarImovel(String nome, int novoPreco, int novoAluguel) {
        for (Imovel imovel : listaImoveis) {
            if (imovel.nome.equals(nome)) {
                imovel.preco = novoPreco;
                imovel.aluguel = novoAluguel;
                System.out.println("Imóvel atualizado: " + nome);
                return;
            }
        }
        System.out.println("Imóvel não encontrado: " + nome);
    }

    public void removerImovel(String nome) {
        Imovel imovelARemover = null;
        for (Imovel imovel : listaImoveis) {
            if (imovel.nome.equals(nome)) {
                imovelARemover = imovel;
                break;
            }
        }
        if (imovelARemover != null) {
            listaImoveis.remove(imovelARemover);
            System.out.println("Imóvel removido: " + nome);
        } else {
            System.out.println("Imóvel não encontrado: " + nome);
        }
    }

    public boolean validarImoveis() {
        return listaImoveis.size() >= 10;
    }

    public void interagirComCasa(Jogador jogador) {
        switch (jogador.posicaoAtual.nome) {
            case "Imóvel 1":
            case "Imóvel 2":
                if (!jogador.propriedades.contains(jogador.posicaoAtual.nome)) {
                    jogador.comprarPropriedade(jogador.posicaoAtual.nome);
                    System.out.println("Parabéns pela compra do imóvel " + jogador.posicaoAtual.nome);
                } else {
                    jogador.pagar(50); // Exemplo de aluguel
                    System.out.println("Você pagou R$50 de aluguel.");
                }
                break;
            case "Imposto":
                int imposto = (int) (jogador.saldo * 0.05);
                if (jogador.saldo >= imposto) {
                    jogador.pagar(imposto);
                    System.out.println("Você pagou R$" + imposto + " de imposto.");
                } else {
                    System.out.println("Saldo insuficiente para pagar o imposto.");
                }
                break;
            case "Restituição":
                int restituição = (int) (jogador.saldo * 0.10);
                jogador.receber(restituição);
                System.out.println("Você recebeu R$" + restituição + " de restituição.");
                break;
            default:
                break;
        }
    }
}
