public class VetorClientes {
    private Cliente[] clientes;
    private int tamanhoAtual;

    public VetorClientes(int tamanho) {
        clientes = new Cliente[tamanho];
        tamanhoAtual = 0;
    }

    public boolean adicionarCliente(Cliente cliente) {
        if (tamanhoAtual < clientes.length) {
            clientes[tamanhoAtual++] = cliente;
            return true;
        }
        return false; // Vetor cheio
    }

    public boolean removerCliente(int indice) {
        if (indice >= 0 && indice < tamanhoAtual) {
            for (int i = indice; i < tamanhoAtual - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[--tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public boolean alterarCliente(int indice, Cliente novoCliente) {
        if (indice >= 0 && indice < tamanhoAtual) {
            clientes[indice] = novoCliente;
            return true;
        }
        return false;
    }

    public Cliente[] listarClientes() {
        Cliente[] listaClientes = new Cliente[tamanhoAtual];
        System.arraycopy(clientes, 0, listaClientes, 0, tamanhoAtual);
        return listaClientes;
    }

    public String buscarClientePorNome(String name) {
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getName().equals(name)) {
                return cliente.toString();
            }
        }
        return null;
    }

    public Cliente[] filtrarPorDominioEmail(String dominio) {
        Cliente[] filtrados = new Cliente[tamanhoAtual];
        int count = 0;
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getEmail().endsWith(dominio)) {
                filtrados[count++] = cliente;
            }
        }
        Cliente[] resultado = new Cliente[count];
        System.arraycopy(filtrados, 0, resultado, 0, count);
        return resultado;
    }
}
