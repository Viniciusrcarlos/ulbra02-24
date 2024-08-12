public class Main {
    public static void main(String[] args) {

        var p1 = new Professor("teste", "teste@gmail.com");
        var a1 = new Aluno("joao", "joao@gmail.com");
        var a2 = new Aluno("alexandre", "joao@gmail.com");
        var a3 = new Aluno("vinicius", "joao@gmail.com");
        var a4 = new Aluno("juliano", "joao@gmail.com");
        var c1 = new Turma("Turma 01", p1);

        c1.inserirAluno(a1);
        c1.inserirAluno(a2);
        c1.inserirAluno(a3);
        c1.inserirAluno(a4);

        c1.listarAlunos();

    }
}