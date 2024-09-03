public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Vinicius", "998383744", "viniciusrauppcarlos@gmail.com");
        Cliente c2 = new Cliente("Lauren", "997342323", "laurenprusch@gmail.com");
        VetorClientes vetorClientes = new VetorClientes(20);

        vetorClientes.adicionarCliente(c1);
        vetorClientes.adicionarCliente(c2);


    }
}