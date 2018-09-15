package br.com.juliorgm.udamusicplayer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable{
    private String mNomePlaylist;
    private List<Musica> mPlaylist;
    private int mImagemId;

    public Playlist(String mNomePlaylist, ArrayList<Musica> mPlaylist, int mImagemId) {
        this.mNomePlaylist = mNomePlaylist;
        this.mPlaylist = mPlaylist;
        this.mImagemId = mImagemId;
    }

    public String getmNomePlaylist() {
        return mNomePlaylist;
    }

    public int getmImagemId() {
        return mImagemId;
    }

    public List<Musica> getmPlaylist() {return mPlaylist;}
}
