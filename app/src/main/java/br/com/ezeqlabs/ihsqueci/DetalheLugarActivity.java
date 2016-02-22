package br.com.ezeqlabs.ihsqueci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class DetalheLugarActivity extends AppCompatActivity {
    private Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_lugar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView estou = (TextView) findViewById(R.id.detalhe_lugar_estou);
        TextView trouxe = (TextView) findViewById(R.id.detalhe_lugar_trouxe);

        lugar = (Lugar) getIntent().getSerializableExtra("lugarSelecionado");

        estou.setText(lugar.getNome());
        trouxe.setText(lugar.getTrouxe());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_detalhe_lugar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String naoImplementado = "Funcionalidade ainda não implementada :(";
        switch(item.getItemId()){
            case R.id.menu_detalhe_editar:
                Toast.makeText(this, naoImplementado, Toast.LENGTH_SHORT).show();
                return false;
            case R.id.menu_detalhe_apagar:
                Toast.makeText(this, naoImplementado, Toast.LENGTH_SHORT).show();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
