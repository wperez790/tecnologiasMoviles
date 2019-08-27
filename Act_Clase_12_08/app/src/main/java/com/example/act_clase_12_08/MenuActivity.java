package com.example.act_clase_12_08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity {

    private TextView usuario;
    private FrameLayout ly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        setTitle("Menu");

        usuario = findViewById(R.id.usuario);


        Intent intent = getIntent();
        String texto = intent.getStringExtra("Usuario");

        String welcome = getString(R.string.welcome) + " ";
        usuario.setText(welcome + texto + "!!!");

        FloatingActionButton btnEmail = findViewById(R.id.email);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(v);
            }
        });
    }


    private void sendEmail(View v){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Este es un mail de prueba");
        email.putExtra(Intent.EXTRA_TEXT, "Mensaje texto");
        Intent mailer = Intent.createChooser(email, "Enviar mail usando");
        startActivityForResult(email,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if (resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_LONG);
            }else if(resultCode == Activity.RESULT_OK){
                Toast.makeText(getApplicationContext(),"Enviado",Toast.LENGTH_LONG);
            }
        }
    }
}
