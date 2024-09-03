public class VetorClientes {
    private Cliente[] clientes;
    private int tamanhoAtual;

    public VetorClientes(int tamanho) {
        clientes = new Cliente[tamanho];
        tamanhoAtual = 0;
    }

    // Adicionar cliente
    public void adicionarCliente(Cliente novoCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = novoCliente;
            }
        }
    }

    //Obter elemento de uma posição: Retorne o valor do elemento armazenado em uma determinada posição.
    public String obter(int posicao) {
        if (posicao < 0 || posicao >= tamanhoAtual) {
            throw new IllegalArgumentException("Posição inválida");
        } else {
            return clientes[posicao];
        }
    }

    //Alterar elemento de uma posição: Altere o valor do elemento armazenado em uma determinada posição.
    public void alterar(int posicao, String novoElemento) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        elementos[posicao] = novoElemento;
    }

    // Aumentar a capacidade: Aumente a capacidade do Vetor quando estiver cheio. (dobra a capacidade)
    private void aumentarCapacidade() {
        if (elementos.length == 0) {
            elementos = new String[1]; // Caso inicial, o vetor está vazio
        } else {
            String[] elementosNovos = new String[elementos.length * 2];
            for (int i = 0; i < tamanho; i++) {
                elementosNovos[i] = elementos[i];
            }
            elementos = elementosNovos;

        }
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }

    //Remover elemento pelo valor: Encontre e remova a primeira ocorrência de um valor específico no vetor.
    public void removerPeloValor(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                remover(i);
                return; // Encontrou e removeu, então sai do método
            }
        }
        throw new IllegalArgumentException("Elemento não encontrado no vetor");
    }

    // Verificar se um elemento existe: Verifique se um determinado valor está presente no vetor.
    public boolean contem(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    // Retorna o tamanho do Vetor
    public int getTamanho() {
        return tamanho;
    }

    //Verificar se o vetor está vazio: Indique se o vetor está vazio (ou seja, sem nenhum elemento armazenado).
    public void vazioOuCheio() {
        if (tamanho == 0) {
            System.out.println("Vazio");
        } else {
            System.out.println("Não está vazio");
        }
    }

    //Limpar: Remova todos os elementos do vetor, tornando-o vazio.
    public void limparVetor() {
        for (int i = 0; i < tamanho; i++) {
            elementos[i] = null;
        }
    }

    //Listar Elementos: Reescreva o mtodo toString() para listar todos os elementos contidos no vetor
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < tamanho - 1; i++) {
            s.append(elementos[i]);
            s.append(", ");
        }

        if (tamanho > 0) {
            s.append(elementos[tamanho - 1]);
        }

        s.append("]");
        return s.toString();
    }
}
