//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criar vetor
        Vetor vetor = new Vetor(3);

        // Adicinando elementos
        vetor.adicionarAoFinal("Elemento 1");
        vetor.adicionarAoFinal("Elemento 2");
        vetor.adicionarAoFinal("Elemento 3");

        // Tentar adicionar mais elementos em um vetor cheio, porém com o metodo aumentarCapacidade() ele dobra o tamanho.
        try {
            vetor.adicionarAoFinal("Elemento 4");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentar obter elemento em posição inválida
        try {
            System.out.println(vetor.obter(50));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Altera o valor do vetor
        vetor.alterar(0, "Vetor Alterado");

        // Tentar alterar elemento em posição inválida
        try {
            vetor.alterar(50, "Outro Elemento");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentar remover elemento em posição inválida
        try {
            vetor.remover(50);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Tentar remover um elemento que não existe
        try {
            vetor.removerPeloValor("Elemento Inexistente");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage()); // Saída: Erro: Elemento não encontrado no vetor
        }

        // Verifica se tem o elemento
        System.out.println(vetor.contem("Elemento 1")); // Retorna false
        System.out.println(vetor.contem("Elemento 2")); // Retorna true

        //Obter tamanho atual do vetor: Retorne o número de elementos atualmente armazenados no vetor.
        System.out.println(vetor.getTamanho());

        //Mostra na tela se o vetor está vazio ou cheio
        vetor.vazioOuCheio(); // Fala que o vetor não está vazio
        Vetor vetor2 = new Vetor(3);
        vetor2.vazioOuCheio(); // Fala que o vetor está vazio.

        // Lista os elementos do vetor
        System.out.println(vetor);
    }
}
