package br.com.juliorgm.udamusicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import br.com.juliorgm.udamusicplayer.R;
import br.com.juliorgm.udamusicplayer.interfaces.ItemClickListener;
import br.com.juliorgm.udamusicplayer.model.Playlist;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{
    private Context mContext;
    private List<Playlist> mPlaylist;
    private static ItemClickListener sItemClickListener;

    public PlaylistAdapter(Context mContext, List<Playlist> mPlaylist) {
        this.mContext = mContext;
        this.mPlaylist = mPlaylist;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNomePlaylist;
        private ImageView mImagemMusica;

        private ViewHolder(View itemView) {
            super(itemView);
            mNomePlaylist = itemView.findViewById(R.id.txtItemNomePlaylist);
            mImagemMusica = itemView.findViewById(R.id.imgItemImagemPlaylist);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (sItemClickListener!=null){
                sItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = mPlaylist.get(position);

        holder.mNomePlaylist.setText(playlist.getmNomePlaylist());
        holder.mImagemMusica.setImageResource(playlist.getmImagemId());
    }

    @Override
    public int getItemCount() {
        return mPlaylist.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.sItemClickListener = itemClickListener;
    }
}
