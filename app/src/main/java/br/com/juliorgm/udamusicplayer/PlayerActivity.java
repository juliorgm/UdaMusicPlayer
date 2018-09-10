package br.com.juliorgm.udamusicplayer;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.juliorgm.udamusicplayer.adapter.PlayerAdapter;
import br.com.juliorgm.udamusicplayer.model.Musica;

public class PlayerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewMusicas;
    private Button mBtnPlay, mBtnProximo, mBtnVolta, mBtnHome;
    private TextView mTxtTitutoPagina, mTxtInicioMusica, mTxtFimMusica, mTxtNomeMusica, mTxtBanda;
    private ArrayList<Musica> mLista;
    private PlayerAdapter mAdapter;
    private boolean mPlay;
    private Musica mMusicaAtual;
    private int mPosicao;
    PagerSnapHelper snapHelper;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mPlay = false;
        mPosicao = 0;

        carregaCampos();
        pegaIntent();
        carregaRecycler();
        cliqueBotoes();
    }

    private void pegaMusicaAtual(int posicao) {
        mMusicaAtual = mLista.get(posicao);
    }

    private void carregaRecycler() {
        mRecyclerViewMusicas.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewMusicas.setLayoutManager(layoutManager);
        mAdapter = new PlayerAdapter(this, mLista);
        mRecyclerViewMusicas.setAdapter(mAdapter);

        snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerViewMusicas);
    }

    private void carregaCampos() {
        mRecyclerViewMusicas = findViewById(R.id.recyclerPlayer);
        mTxtTitutoPagina = findViewById(R.id.txtTituloPagina);
        mTxtInicioMusica=findViewById(R.id.txtInicioMusica);
        mTxtFimMusica=findViewById(R.id.txtFimMusica);
        mTxtNomeMusica =findViewById(R.id.txtTituloMusica);
        mTxtBanda=findViewById(R.id.txtBanda);

        mBtnPlay=findViewById(R.id.btnPlayMusic);
        mBtnProximo=findViewById(R.id.btnProximo);
        mBtnVolta=findViewById(R.id.btnVolta);
        mBtnHome=findViewById(R.id.btnHome);
    }

    private void pegaIntent() {
        Intent intent = getIntent();
        mLista = (ArrayList<Musica>) intent.getSerializableExtra("MUSICA");
        mTxtTitutoPagina.setText(intent.getStringExtra("TITULO"));
        pegaMusicaAtual(mPosicao);
        carregaTextos();
    }

    private void cliqueBotoes() {
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mPlay){
                    mPlay = true;
                    mBtnPlay.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_button_play_pause));
                }else{
                    mBtnPlay.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_button_play_foreground));
                    mPlay = false;
                }
            }
        });

        mBtnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avancaMusica();
            }
        });

        mBtnVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltaMusica();
            }
        });

        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        mRecyclerViewMusicas.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                mPosicao = snapHelper.findTargetSnapPosition(layoutManager,velocityX, velocityY);
                atualizaMusica();

                return true;
            }
        });

    }

    private void avancaMusica() {
        if (mPosicao < mLista.size())mPosicao++;
        else mPosicao = mLista.size();

        atualizaMusica();
    }

    private void atualizaMusica() {
        pegaMusicaAtual(mPosicao);
        carregaTextos();
        mRecyclerViewMusicas.getLayoutManager().scrollToPosition(mPosicao);
    }

    private void voltaMusica() {
        if (mPosicao>0)mPosicao--;
        else mPosicao=0;

        atualizaMusica();
    }

    public void carregaTextos(){
        mTxtBanda.setText(mMusicaAtual.getmArtista());
        mTxtNomeMusica.setText(mMusicaAtual.getmMusica());
        mTxtInicioMusica.setText(R.string.tempo_inicio);
        mTxtFimMusica.setText(R.string.tempo_fim);
    }
}