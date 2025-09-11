package br.com.mateussm340.cashewmusic.models;

public class Music extends Audio {
    private String album;
    private String genre;

    public void setMusic(String album, String singer, String genre) {
        this.album = album;
        setTitle(singer);
        this.genre = genre;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public int getRating() {
        return getClassificationBySelectedQuantity(getTotalLikes());
    }
}
