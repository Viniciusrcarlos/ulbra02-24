import java.util.ArrayList;

public class Turma {
    private String name;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
    }

    public void inserirAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso!!");
    }

    public void listarAlunos() {
        System.out.println("*******************************");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(alunos.get(i).getName());
        }
        System.out.println("*******************************");
    }
}
