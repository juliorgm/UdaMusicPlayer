package br.com.juliorgm.udamusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.juliorgm.udamusicplayer.Adapter.GeneroAdapter;
import br.com.juliorgm.udamusicplayer.Adapter.MusicaAdapter;
import br.com.juliorgm.udamusicplayer.model.Musica;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewMusicas, mRecyclerViewGeneros, mRecyclerViewPlaylists;
    private RecyclerView.Adapter mAdapter, mAdapterGenero;
    private ArrayList<Musica> mListaMusicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaLista();
        carregaGenero();
    }

    private void carregaLista(){

        mListaMusicas = new ArrayList<>();

        mListaMusicas.add(new Musica("Sweet Child O' Mine", "Guns N'Roses","Rock", R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Gostava Tanto de Você","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Go Back","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Flores","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Família","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Resposta","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sam","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("O Beijo E A Reza (Album Version)","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("In (Dig) Nação","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Garota Nacional","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Epitáfio","Titãs","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Bete Balanço","Herbert Vianna e Frejat","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Um Amor Puro","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sina","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Se Eu Não Te Amasse Tanto Assim","Ivete Sangalo","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Olhar 43","RPM","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Como Dois Animais","Alceu Valença","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Tú Vens","Alceu Valença","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Coração Bobo","Alceu Valença","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Anunciação","Alceu Valença","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Samurai (Ao Vivo)","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Meu Ursinho Blau-Blau","Absyntho","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Flor de Lis (Ao Vivo)","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Last Kiss","Pearl Jam","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Jeremy","Pearl Jam","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Lilás","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Enquanto Houver Sol","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Domingo","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Diversão","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Ciúme","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Aonde Quer Que Eu Vá","Herbert Vianna e Frejat","Romantica",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Jackie Tequila","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Nem Um Dia","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Meu Bem Querer","Djavan","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Resposta","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sou Dela","Nando Reis","Romatica",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Pra Você Guardei O Amor","Nando Reis","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("E.C.T","Nando Reis","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("O Segundo Sol","Nando Reis","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Borbulhas de Amor","Fagner","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Canteiros","Fagner","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Deslizes","Fagner","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("A Coisa Mais Linda Que Existe","Gal Costa","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Moça Bonita","Geraldo Azevedo","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Táxi Lunar","Geraldo Azevedo","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Fã nº 1","Guilherme Arantes","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Lindo Balao Azul (Ao Vivo)","Guilherme Arantes","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Muito Diferente","Guilherme Arantes","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Um Dia, um Adeus","Guilherme Arantes","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Lembra de Mim","Ivan Lins","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Vitoriosa","Ivan Lins","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Garotos II","Leoni","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Amor De Índio","Milton Nascimento","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Ainda Bem","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Amor I Love You","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Beija Eu","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Chocolate","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("De Noite Na Cama","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("O Xote Das Meninas - Severina Xique Xique","Marisa Monte","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Você","Os Paralamas Do Sucesso","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Fogo","Capital Inicial","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("A Novidade","Os Paralamas Do Sucesso","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Aonde Quer Que Eu Vá","Os Paralamas Do Sucesso","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Cuide Bem Do Seu Amor","Os Paralamas Do Sucesso","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Uma Brasileira (part. Djavan)","Os Paralamas Do Sucesso","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Bandolins","Oswaldo Montenegro","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Lua e Flor","Oswaldo Montenegro","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Já Sei Namorar","Os Tribalistas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Velha Infância","Os Tribalistas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("A Cruz E A Espada","Paulo Ricardo","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Lua Cheia (ao vivo)","Papas Da Língua","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Começo, Meio e Fim","Roupa Nova","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Bem-te-vi","Paulinho Pedra Azul","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("A Maçã","Raul Seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Meu Amigo Pedro","Raul Seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("O Trem das Sete","Raul Seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Ouro do Tolo","Raul Seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Tu és o MDC da minha vida","Raul seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("É Fim De Mês","Raul Seixas","MPB",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Dona","Roupa Nova","Romatica",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Frisson","Roupa Nova","Romatica",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Agora Só Falta Você","Rita Lee","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Amor e Sexo","Rita Lee","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Mania De Você","Rita Lee","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Ovelha Negra","Rita Lee","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Bye Bye Tristeza","Sandra de Sá","Romatica",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Ainda Gosto Dela","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Acima do Sol","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Dois Rios","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Esmola","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Estivador","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Eu Disse A Ela","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Garota Nacional","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Homem Q Sabia Demais","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("In (Dig) Nação","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Jackie Tequila","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Mil Acasos","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("O Beijo e a Reza (Multishow - Mineirão)","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Pacato Cidadão - Let 'Em In","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sam","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sutilmente","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Tanto","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Te Ver","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Tão Seu","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("É uma Partida de Futebol","Skank","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Insensível","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Marvin","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Não Vou Me Adaptar","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Os Cegos do Castelo","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Porque Eu Sei Que É Amor","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sonífera Ilha","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("É Preciso Saber Viver","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Hotel California","Eagles","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Palpite","Vanessa Rangel","Pop",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("E.C.T. (Acústico)","Cássia Eller","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Primeiros Erros","Kiko Zambianchi","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("É uma Partida de Futebol","Skank","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Enquanto Houver Sol","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Sonífera Ilha","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Porque Eu Sei Que É Amor","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Go Back (Acústico)","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Isso","Titãs","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Na Rua, Na Chuva, Na Fazenda (part. Lenine) (acústico)","Kid Abelha","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Primeiros Erros (Acústico MTV)","Capital Inicial","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Cai A Noite (Acústico MTV)","Capital Inicial","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Independência (Acústico MTV)","Capital Inicial","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Musica Urbana","Capital Inicial","Rock",R.drawable.sweet_child));
        mListaMusicas.add(new Musica("Rolam as Pedras","Kiko Zambianchi","Rock",R.drawable.sweet_child));

        mRecyclerViewMusicas = findViewById(R.id.recycleMusicas);
        mRecyclerViewMusicas.setHasFixedSize(true);
        mRecyclerViewMusicas.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MusicaAdapter(this, mListaMusicas);
        mRecyclerViewMusicas.setAdapter(mAdapter);
    }

    private void carregaGenero(){

        ArrayList<String> listaGeneros = new ArrayList<>();
        listaGeneros.add(mListaMusicas.get(0).getmGenero());
        for (Musica m:mListaMusicas) {
            if (!listaGeneros.contains(m.getmGenero())){
                listaGeneros.add(m.getmGenero());
            }
        }

        mRecyclerViewGeneros = findViewById(R.id.recyclerGenero);
        mRecyclerViewGeneros.setHasFixedSize(true);
        mRecyclerViewGeneros.setLayoutManager(new LinearLayoutManager(this));
        mAdapterGenero = new GeneroAdapter(this,listaGeneros);
        mRecyclerViewGeneros.setAdapter(mAdapterGenero);
    }


}
