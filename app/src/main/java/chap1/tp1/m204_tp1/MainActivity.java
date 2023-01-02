package chap1.tp1.m204_tp1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edInc;
    TextView compteur;
Button btnFinish,btnSuivant,btnInc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSuivant = findViewById(R.id.btnSuivant);
        edInc = findViewById(R.id.edInc);
        edInc.setText("0");
        compteur = findViewById(R.id.tv);
        btnInc = findViewById(R.id.btnIncrementer);
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cnt = Integer.parseInt(edInc.getText().toString());
                cnt+=1;
                edInc.setText(cnt+"");
                compteur.setText(cnt+"");
            }
        });
        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,RESULT_OK);
            }
        });

        Log.d("onCreate","Activité crée"); //LOG.D / UNE JOURNALISATION DANS LA CATEGORIE DEBUG

    }

    private Boolean partagerData(){
        Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                .setType("text/plain")
                .setText("Partager les données de l'application")
                .getIntent();
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
            return true;
        } else {
            Toast.makeText(getApplicationContext(),
                    "impossible de partager les données de l'application",
                    Toast.LENGTH_LONG).show();
            return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

      Log.d("onStart","Activité demarrée");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","Activité disponible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","Activité Detruite");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","Activité en pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onPause","Activité stopée");
    }

}