package br.com.ezeqlabs.ihsqueci;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaLugaresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares);

        ListView listaLugares = (ListView) findViewById(R.id.lista_lugares);
        String[] lugares = {"Mooca", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus", "São Paulo", "Manaus"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lugares);
        listaLugares.setAdapter(adapter);

        FloatingActionButton adicionaLugar = (FloatingActionButton) findViewById(R.id.floating_adiciona_lugar);
        adicionaLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListaLugaresActivity.this, "Novo lugar", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
