package br.com.ezeqlabs.ihsqueci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import br.com.ezeqlabs.ihsqueci.dao.LugarDAO;
import br.com.ezeqlabs.ihsqueci.helpers.FormularioLugaresHelper;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class FormularioLugaresActivity extends AppCompatActivity {
    private FormularioLugaresHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_lugares);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.helper = new FormularioLugaresHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_formulario_lugares, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Lugar lugar = helper.pegaLugarDoFormulario();

                if(helper.temNome()){
                    if(helper.trouxeAlgo()){
                        LugarDAO dao = new LugarDAO(this);
                        dao.insere(lugar);
                        dao.close();

                        Toast.makeText(this, (lugar.getNome().toString() + " adicionado com sucesso"), Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        helper.erroTrouxe();
                    }
                }else{
                    helper.erroNome();
                }

                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
