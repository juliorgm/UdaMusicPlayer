package br.com.juliorgm.udamusicplayer.model;

import java.io.Serializable;
import br.com.juliorgm.udamusicplayer.R;

public class Musica implements Serializable{

    private String mMusica, mArtista, mGenero;

    private int mImagemId;

    public Musica(String mMusica, String mArtista, String mGenero, int mImagemId) {
        this.mMusica = mMusica;
        this.mArtista = mArtista;
        this.mGenero = mGenero;

        if (mImagemId ==1)this.mImagemId = R.drawable.ic_unnamed;
        else this.mImagemId = mImagemId;
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
