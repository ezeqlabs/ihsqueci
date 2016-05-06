package br.com.ezeqlabs.ihsqueci;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.ezeqlabs.ihsqueci.adapters.ListaLugaresAdapter;
import br.com.ezeqlabs.ihsqueci.helpers.LugaresHelper;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class ListaLugaresActivity extends AppCompatActivity {
    private RecyclerView listaLugares;
    private LugaresHelper helper = new LugaresHelper(ListaLugaresActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        trataListagem();
        trataFloatingButton();

        registerForContextMenu(listaLugares);

        /*
        listaLugares.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalhe = new Intent(ListaLugaresActivity.this, DetalheLugarActivity.class);

                detalhe.putExtra("lugarSelecionado", (Lugar) listaLugares.getItemAtPosition(position));
                startActivity(detalhe);
            }
        });
        */
    }

    protected void onResume(){
        super.onResume();
        populaRecyclerView();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        //final Lugar lugarSelecionado = (Lugar) listaLugares.getAdapter().getItemId(info.position);

        MenuItem editar = menu.add(R.string.editar);
        editar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
          //      helper.abreEdicaoLugar(lugarSelecionado);
                return false;
            }
        });

        MenuItem apagar = menu.add(R.string.apagar);
        apagar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //helper.deletaLugar(lugarSelecionado);
                return false;
            }
        });
    }

    private void trataListagem(){
        listaLugares = (RecyclerView) findViewById(R.id.lista_lugares);
        listaLugares.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaLugares.setLayoutManager(linearLayoutManager);

        populaRecyclerView();
    }

    private void populaRecyclerView(){
        ListaLugaresAdapter adapter = new ListaLugaresAdapter(helper.populaListagem(), ListaLugaresActivity.this);
        listaLugares.setAdapter(adapter);
    }

    private void trataFloatingButton(){
        FloatingActionButton adicionaLugar = (FloatingActionButton) findViewById(R.id.floating_adiciona_lugar);
        adicionaLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaLugaresActivity.this, FormularioLugaresActivity.class);
                startActivity(intent);
            }
        });
    }

}
