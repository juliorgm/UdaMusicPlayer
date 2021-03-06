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
import br.com.juliorgm.udamusicplayer.model.Musica;

public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.ViewHolder> {
    private Context mContext;
    private List<Musica> mListaMusica;
    private static ItemClickListener sItemClickListener;

    public MusicaAdapter(Context mContext, List<Musica> mListaMusica) {
        this.mContext = mContext;
        this.mListaMusica = mListaMusica;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mMusica, mArtista, mGenero;
        private ImageView mImagemMusica;

        private ViewHolder(View itemView) {
            super(itemView);
            mMusica = itemView.findViewById(R.id.txtItemMusica);
            mArtista = itemView.findViewById(R.id.txtItemArtista);
            mGenero = itemView.findViewById(R.id.txtItemGenero);
            mImagemMusica = itemView.findViewById(R.id.imgItemMusica);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(sItemClickListener != null) {
                sItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musica, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicaAdapter.ViewHolder holder, int position) {
        Musica musica = mListaMusica.get(position);

        holder.mMusica.setText(musica.getmMusica());
        holder.mArtista.setText(musica.getmArtista());
        holder.mGenero.setText(musica.getmGenero());
        holder.mImagemMusica.setImageResource(musica.getmImagemId());

    }

    @Override
    public int getItemCount() {
        return mListaMusica.size();
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.sItemClickListener = itemClickListener;
    }
}
