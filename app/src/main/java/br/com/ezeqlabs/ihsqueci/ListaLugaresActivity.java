package br.com.ezeqlabs.ihsqueci;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ezeqlabs.ihsqueci.dao.LugarDAO;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class ListaLugaresActivity extends AppCompatActivity {
    private List<Lugar> lugares;
    private ListView listaLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        adicionaToolBar();
        //alteraCorBarraStatus();
        populaListagem();
        trataFloatingButton();

        registerForContextMenu(listaLugares);

        listaLugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalhe = new Intent(ListaLugaresActivity.this, DetalheLugarActivity.class);

                detalhe.putExtra("lugarSelecionado", (Lugar) listaLugares.getItemAtPosition(position));
                startActivity(detalhe);
            }
        });
    }

    protected void onResume(){
        super.onResume();
        this.populaListagem();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Lugar lugarSelecionado = (Lugar) listaLugares.getAdapter().getItem(info.position);

        MenuItem apagar = menu.add(R.string.apagar_lugar);
        apagar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                deletaLugar(lugarSelecionado);
                return false;
            }
        });
    }

    private void adicionaToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
    }

    /*
    private void alteraCorBarraStatus(){
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }
    */

    private void populaListagem(){
        listaLugares = (ListView) findViewById(R.id.lista_lugares);
        LugarDAO dao = new LugarDAO(this);
        lugares = dao.getListaLugares();
        dao.close();

        ArrayAdapter<Lugar> adapter = new ArrayAdapter<Lugar>(this, android.R.layout.simple_list_item_1, lugares);
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

    private void deletaLugar(final Lugar lugar){
        new AlertDialog.Builder(ListaLugaresActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.title_dialog)
                .setMessage(R.string.message_dialog)
                .setPositiveButton(R.string.sim,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LugarDAO dao = new LugarDAO(ListaLugaresActivity.this);
                                dao.deletar(lugar);
                                dao.close();

                                Toast.makeText(ListaLugaresActivity.this, (lugar.getNome() + " apagado com sucesso"), Toast.LENGTH_SHORT).show();

                                populaListagem();
                            }
                        })
                .setNegativeButton(R.string.nao, null)
                .show();
    }

}
