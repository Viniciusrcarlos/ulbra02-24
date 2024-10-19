public class Musica {
    String titulo;
    String artista;
    String album;
    int duracao; // duração em segundos

    public Musica(String titulo, String artista, String album, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Artista: " + artista + " | Álbum: " + album + " | Duração: " + duracao + "s";
    }
}
