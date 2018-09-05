package br.com.juliorgm.udamusicplayer.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.juliorgm.udamusicplayer.R;
import br.com.juliorgm.udamusicplayer.model.Musica;

public class GeneroAdapter extends RecyclerView.Adapter<GeneroAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mListaGenero;

    public GeneroAdapter(Context mContext, List<String> mListaGenero) {
        this.mContext = mContext;
        this.mListaGenero = mListaGenero;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemGenero;
        public ViewHolder(View itemView) {
            super(itemView);
            itemGenero = itemView.findViewById(R.id.txtItemGenero);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_genero,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemGenero.setText(mListaGenero.get(position));
    }

    @Override
    public int getItemCount() {
        return mListaGenero.size();
    }


}
