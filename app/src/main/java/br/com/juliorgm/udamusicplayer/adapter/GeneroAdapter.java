package br.com.juliorgm.udamusicplayer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import br.com.juliorgm.udamusicplayer.R;
import br.com.juliorgm.udamusicplayer.interfaces.ItemClickListener;

public class GeneroAdapter extends RecyclerView.Adapter<GeneroAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mListaGenero;
    private static ItemClickListener sItemClickListener;

    public GeneroAdapter(Context mContext, List<String> mListaGenero) {
        this.mContext = mContext;
        this.mListaGenero = mListaGenero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_genero, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemGenero.setText(mListaGenero.get(position));
    }

    @Override
    public int getItemCount() {
        return mListaGenero.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView itemGenero;
        private View itemView;

        private ViewHolder(View itemView) {
            super(itemView);
            itemGenero = itemView.findViewById(R.id.txtItemGenero);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(sItemClickListener != null) {
                sItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.sItemClickListener = itemClickListener;
    }
}
