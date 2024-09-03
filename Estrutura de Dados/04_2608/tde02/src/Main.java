import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var f1 = new Funcionario("Vinicius", 1500);
        var f2 = new Funcionario("Juliano", 2200);
        var f3 = new Funcionario("Lucas", 2250);
        var f4 = new Funcionario("Ramon", 1800);
        var f5 = new Funcionario("Thiago", 3500);

        Funcionario[] funcionario = {f1, f2, f3, f4, f5};
        var ordenacao = new Ordenacoes();

        ordenacao.ordenarCrescente(funcionario);
        System.out.println();
        ordenacao.ordenacaoDecrescente(funcionario);
        System.out.println();
        ordenacao.ordemAlfabetica(funcionario);

    }
}
