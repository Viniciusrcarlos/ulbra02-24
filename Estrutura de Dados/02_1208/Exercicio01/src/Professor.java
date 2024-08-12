public class Professor extends Pessoa{

    // Constructor
    public Professor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void logar() {
        System.out.println("Professor logado");
    }

}
