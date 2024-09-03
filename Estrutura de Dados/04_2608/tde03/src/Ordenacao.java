public class Ordenacao {

    public void insertionSortPorMedia(Aluno[] alunos) {
        int n = alunos.length;
        for (int i = 1; i < n; i++) {
            Aluno chave = alunos[i];
            int j = i - 1;
            while (j >= 0 && alunos[j].getMedia() > chave.getMedia()) {
                alunos[j + 1] = alunos[j];
                j = j - 1;
            }
            alunos[j + 1] = chave;
        }
        for (int i = 0; i < alunos.length; i++) {
            System.out.println(alunos[i].getNome() + ": " + alunos[i].getMedia());
        }
    }

    public void filtrarAlunosPorMedia(Aluno[] alunos, boolean aprovado) {
        Aluno[] filtrados = new Aluno[alunos.length];
        int count = 0;
        for (Aluno aluno : alunos) {
            if (aprovado && aluno.getMedia() >= 7.0) {
                filtrados[count++] = aluno;
            } else if (!aprovado && aluno.getMedia() < 7.0) {
                filtrados[count++] = aluno;
            }
        }
        Aluno[] resultado = new Aluno[count];
        System.arraycopy(filtrados, 0, resultado, 0, count);

        for (Aluno aluno : resultado) {
            System.out.println(aluno.getNome() + ": " + aluno.getMedia());
        }

    }





}
