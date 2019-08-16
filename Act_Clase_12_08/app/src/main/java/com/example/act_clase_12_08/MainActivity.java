package com.example.act_clase_12_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gym");
        Toast.makeText(getApplicationContext(),"Gato!!",Toast.LENGTH_SHORT).show();
    }

    private void showSnackBar(View view){

        Snackbar snackbar = Snackbar.make(view, "Inicio Sesion", Snackbar.LENGTH_LONG).setAction("Accion", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("SNACKBAR", "CLICK EN INICIAR SESION");
            }

        });
        snackbar.show();
    }
}
