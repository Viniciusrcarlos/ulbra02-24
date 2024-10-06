public class Main {
    public static void main(String[] args) {
        // Criação de uma lista encadeada de inteiros
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // 1. Adicionar elementos no início, no fim e em uma posição específica
        lista.adicionarNoInicio(10);
        lista.adicionarNoFim(30);
        lista.adicionarNaPosicao(1, 20); // Insere 20 na posição 1

        System.out.println("Lista após inserções: " + lista); // Esperado: [10, 20, 30]

        // 2. Remover elementos do início, do fim e de uma posição específica
        int removidoInicio = lista.removerDoInicio();
        System.out.println("Elemento removido do início: " + removidoInicio); // Esperado: 10
        System.out.println("Lista após remoção do início: " + lista); // Esperado: [20, 30]

        int removidoFim = lista.removerDoFim();
        System.out.println("Elemento removido do fim: " + removidoFim); // Esperado: 30
        System.out.println("Lista após remoção do fim: " + lista); // Esperado: [20]

        // Inserindo novamente para testar a remoção por posição
        lista.adicionarNoFim(40);
        lista.adicionarNoFim(50);
        System.out.println("Lista antes de remover da posição 1: " + lista); // Esperado: [20, 40, 50]

        int removidoPosicao = lista.removerDaPosicao(1);
        System.out.println("Elemento removido da posição 1: " + removidoPosicao); // Esperado: 40
        System.out.println("Lista após remoção da posição 1: " + lista); // Esperado: [20, 50]

        // 3. Remover elemento por valor
        lista.adicionarNoFim(60);
        System.out.println("Lista antes de remover o valor 50: " + lista); // Esperado: [20, 50, 60]

        int removidoPorValor = lista.removerPorValor(50);
        System.out.println("Elemento removido por valor: " + removidoPorValor); // Esperado: 50
        System.out.println("Lista após remoção do valor 50: " + lista); // Esperado: [20, 60]

        // 4. Buscar elemento por posição
        int valorNaPosicao = lista.buscar(1);
        System.out.println("Valor na posição 1: " + valorNaPosicao); // Esperado: 60

        // 5. Buscar a posição de um valor
        int posicaoDoValor = lista.buscarPosicao(60);
        System.out.println("Posição do valor 60: " + posicaoDoValor); // Esperado: 1

        // 6. Atualizar valor em uma posição específica
        lista.atualizar(1, 70);
        System.out.println("Lista após atualizar a posição 1 com 70: " + lista); // Esperado: [20, 70]

        // 7. Verificar o tamanho da lista
        int tamanhoLista = lista.tamanho();
        System.out.println("Tamanho da lista: " + tamanhoLista); // Esperado: 2

        // 8. Verificar se a lista está vazia
        boolean listaEstaVazia = lista.estaVazia();
        System.out.println("A lista está vazia? " + listaEstaVazia); // Esperado: false

        // 9. Limpar a lista
        lista.limpar();
        System.out.println("Lista após limpar: " + lista); // Esperado: []
        System.out.println("Tamanho da lista após limpar: " + lista.tamanho()); // Esperado: 0

        listaEstaVazia = lista.estaVazia();
        System.out.println("A lista está vazia após limpar? " + listaEstaVazia); // Esperado: true
    }
}
