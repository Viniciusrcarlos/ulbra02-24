public class Playlist {
    private No inicio;
    private No fim;
    private No atual;

    public Playlist() {
        inicio = null;
        fim = null;
        atual = null;
    }

    // Adicionar música no final da playlist
    public void adicionarMusicaFim(Musica musica) {
        No novoNo = new No(musica);
        if (inicio == null) { // Se a lista está vazia
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        if (atual == null) { // Se for a primeira música, definir como atual
            atual = inicio;
        }
    }

    // Adicionar música no início da playlist
    public void adicionarMusicaInicio(Musica musica) {
        No novoNo = new No(musica);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    // Próxima música
    public void proximaMusica() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
        } else {
            System.out.println("Você já está na última música.");
        }
    }

    // Música anterior
    public void musicaAnterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
        } else {
            System.out.println("Você já está na primeira música.");
        }
    }

    // Tocar música atual
    public void tocarMusica() {
        if (atual != null) {
            System.out.println("Reproduzindo agora: ");
            System.out.println(atual.musica.toString());
        } else {
            System.out.println("Nenhuma música na playlist.");
        }
    }

    // Remover uma música pelo título
    public void removerMusica(String titulo) {
        No temp = inicio;
        while (temp != null) {
            if (temp.musica.titulo.equalsIgnoreCase(titulo)) {
                if (temp == inicio) {
                    inicio = inicio.proximo;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (temp == fim) {
                    fim = fim.anterior;
                    if (fim != null) {
                        fim.proximo = null;
                    }
                } else {
                    temp.anterior.proximo = temp.proximo;
                    temp.proximo.anterior = temp.anterior;
                }

                // Ajustar a música atual se necessário
                if (atual == temp) {
                    atual = inicio;
                }

                System.out.println("Música removida: " + titulo);
                return;
            }
            temp = temp.proximo;
        }
        System.out.println("Música não encontrada: " + titulo);
    }

    // Listar todas as músicas
    public void listarMusicas() {
        No temp = inicio;
        if (temp == null) {
            System.out.println("A playlist está vazia.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.musica.toString());
            temp = temp.proximo;
        }
    }

    // Ordenar por título
    public void ordenarPorTitulo() {
        if (inicio == null) return;
        for (No i = inicio; i != null; i = i.proximo) {
            for (No j = i.proximo; j != null; j = j.proximo) {
                if (i.musica.titulo.compareToIgnoreCase(j.musica.titulo) > 0) {
                    // Trocar as músicas
                    Musica temp = i.musica;
                    i.musica = j.musica;
                    j.musica = temp;
                }
            }
        }
    }

    // Ordenar por artista
    public void ordenarPorArtista() {
        if (inicio == null) return; // Se a lista estiver vazia, não faz nada
        for (No i = inicio; i != null; i = i.proximo) {
            for (No j = i.proximo; j != null; j = j.proximo) {
                if (i.musica.artista.compareToIgnoreCase(j.musica.artista) > 0) {
                    // Troca as músicas entre os nós
                    Musica temp = i.musica;
                    i.musica = j.musica;
                    j.musica = temp;
                }
            }
        }
        System.out.println("Playlist ordenada por artista.");
    }

}