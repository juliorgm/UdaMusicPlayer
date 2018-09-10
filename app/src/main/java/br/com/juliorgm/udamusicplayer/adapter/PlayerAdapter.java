package br.com.juliorgm.udamusicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import br.com.juliorgm.udamusicplayer.R;
import br.com.juliorgm.udamusicplayer.interfaces.ItemClickListener;
import br.com.juliorgm.udamusicplayer.model.Musica;
import jp.wasabeef.glide.transformations.BlurTransformation;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private Context mContext;
    private List<Musica> mListaMusica;
    private static ItemClickListener itemClickListener;

    public PlayerAdapter(Context mContext, List<Musica> mListaMusica) {
        this.mContext = mContext;
        this.mListaMusica = mListaMusica;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_play, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Musica musica = mListaMusica.get(position);
        holder.mImagemMusica.setImageResource(musica.getmImagemId());

        Glide.with(mContext).load(musica.getmImagemId())
                .apply(bitmapTransform(new BlurTransformation(25, 3)))
                .into(holder.mImgemFundo);
    }

    @Override
    public int getItemCount() {
        return mListaMusica.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mMusica, mArtista, mGenero;
        private ImageView mImagemMusica, mImgemFundo;
        private View view;

        private ViewHolder(View itemView) {
            super(itemView);
            mImagemMusica = itemView.findViewById(R.id.imgItemPlay);
            mImgemFundo = itemView.findViewById(R.id.imgItemFundo);
            view = itemView;
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
}
