public class Aluno extends Pessoa{

    // Constructor
    public Aluno(String name, String email) {
        super(name, email);
    }

    @Override
    public void logar() {
        System.out.println("Aluno logado");
    }
}
