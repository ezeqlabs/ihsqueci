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
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class ListaLugaresActivity extends AppCompatActivity {
    private RecyclerView listaLugares;
    private LugaresHelper helper = new LugaresHelper(ListaLugaresActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        FloatingActionButton adicionaLugar = (FloatingActionButton) findViewById(R.id.floating_adiciona_lugar);

        trataListagem();
        trataFloatingButton(adicionaLugar);
        trataTutorial(adicionaLugar);

        registerForContextMenu(listaLugares);
    }

    protected void onResume(){
        super.onResume();
        populaRecyclerView();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        MenuItem editar = menu.add(R.string.editar);
        editar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        MenuItem apagar = menu.add(R.string.apagar);
        apagar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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

    private void trataFloatingButton(FloatingActionButton adicionaLugar){
        adicionaLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaLugaresActivity.this, FormularioLugaresActivity.class);
                startActivity(intent);
            }
        });
    }

    private void trataTutorial(FloatingActionButton adicionaLugar){
        new MaterialShowcaseView.Builder(this)
                .setTarget(adicionaLugar)
                .setDismissText(R.string.tutorial_botao)
                .setContentText(R.string.tutorial_texto)
                .setDelay(500)
                .singleUse("1")
                .show();
    }

}