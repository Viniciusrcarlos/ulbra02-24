public class Ordenacoes {

    public void ordenarCrescente(Funcionario[] funcionarios) {
        int n = funcionarios.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (funcionarios[j].getSalario() > funcionarios[j + 1].getSalario()) {
                    Funcionario temp = funcionarios[j];
                    funcionarios[j] = funcionarios[j + 1];
                    funcionarios[j + 1] = temp;
                }
            }
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ": " + funcionario.getSalario());
        }
    }

    public void ordenacaoDecrescente(Funcionario[] funcionarios) {
        int n = funcionarios.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (funcionarios[j].getSalario() < funcionarios[j + 1].getSalario()) {
                    Funcionario temp = funcionarios[j];
                    funcionarios[j] = funcionarios[j + 1];
                    funcionarios[j + 1] = temp;
                }
            }
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ": " + funcionario.getSalario());
        }
    }

    public void ordemAlfabetica(Funcionario[] funcionarios) {
        int n = funcionarios.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (funcionarios[j].getNome().compareTo(funcionarios[j + 1].getNome()) > 0) {
                    Funcionario temp = funcionarios[j];
                    funcionarios[j] = funcionarios[j + 1];
                    funcionarios[j + 1] = temp;
                }
            }
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + ": " + funcionario.getSalario());
        }
    }


}
