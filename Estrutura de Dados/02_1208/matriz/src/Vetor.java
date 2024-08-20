public class Vetor {
    private String elementos[];
    private int tamanho;


    public Vetor(int qtdd) {
        elementos = new String[qtdd];
        tamanho = 0;
    }

    public void adicionarElemento(int valor) {
        if (tamanho < elementos.length){
            elementos[tamanho] = valor;
            tamanho++;
        }
    }
}
