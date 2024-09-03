public class Main {
    public static void main(String[] args) {

        /*

        Bom...depois de me matar tentando descobrir pq meu programa estava printando o mesmo nome e
        mesma média...descobri que na verdade, esqueci de alterar os nomes e os valores das notas
        das variáveis...deixei aqui pra você se solidarizar (e rir) do meu erro.

        sério... fiquei uns bons 30 minutos quebrando a cabeça.

        var al1 = new Aluno("Vinicius", 7, 7);
        var al2 = new Aluno("Vinicius", 7, 7);
        var al3 = new Aluno("Vinicius", 7, 7);
        var al4 = new Aluno("Vinicius", 7, 7);
        var al5 = new Aluno("Vinicius", 7, 7);
        var al6 = new Aluno("Vinicius", 7, 7);
        var al7 = new Aluno("Vinicius", 7, 7);
        var al8 = new Aluno("Vinicius", 7, 7);

        */

        var al1 = new Aluno("Vinicius", 8,5);
        var al2 = new Aluno("Juliano", 6,6);
        var al3 = new Aluno("Ramon", 4,3);
        var al4 = new Aluno("Thiago", 8,6);
        var al5 = new Aluno("Lucas", 5,7);
        var al6 = new Aluno("Andreza", 9,8);
        var al7 = new Aluno("Lauren", 10,9);
        var al8 = new Aluno("Vicente", 2,7);

        Aluno[] values = {al1, al2, al3, al4, al5, al6, al7, al8};
        var ordenacao = new Ordenacao();


        ordenacao.insertionSortPorMedia(values);
        System.out.println();
        ordenacao.filtrarAlunosPorMedia(values, true);
        System.out.println();
        ordenacao.filtrarAlunosPorMedia(values, false);

    }
}