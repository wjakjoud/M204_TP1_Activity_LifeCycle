package chap1.tp1.m204_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button btnRetour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRetour = findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        Log.d("onStart","Activité2 créee");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("onStart","Activité2 demarrée");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","Activité2 disponible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","Activité2 Detruite");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","Activité2 en pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onPause","Activité2 stopée");
    }
}