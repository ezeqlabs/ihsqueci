package br.com.ezeqlabs.ihsqueci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class EzeqlabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ezeqlabs);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent lugares = new Intent(EzeqlabsActivity.this, BoasVindasActivity.class);
                startActivity(lugares);
                finish();
            }
        }, 2000);
    }
}
