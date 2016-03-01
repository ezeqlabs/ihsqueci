package br.com.ezeqlabs.ihsqueci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class BoasVindasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent teste = new Intent(BoasVindasActivity.this, ListaLugaresActivity.class);
                startActivity(teste);
            }
        }, 2000);
    }
}
