import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();

        lista.add("teste01");
        lista.add("teste02");
        lista.add("teste03");

        lista.remove(1);

        System.out.println(lista);
    }
}