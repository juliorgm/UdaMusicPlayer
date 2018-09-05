package br.com.juliorgm.udamusicplayer.model;

public class Musica {

    private String mMusica, mArtista, mGenero;
    private int mImagemId;

    public Musica(String mMusica, String mArtista, String mGenero, int mImagemId) {
        this.mMusica = mMusica;
        this.mArtista = mArtista;
        this.mGenero = mGenero;
        this.mImagemId = mImagemId;
    }

    public String getmMusica() {
        return mMusica;
    }

    public String getmArtista() {
        return mArtista;
    }

    public String getmGenero() {
        return mGenero;
    }

    public int getmImagemId() {
        return mImagemId;
    }
}
