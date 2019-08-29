package com.example.act_clase_12_08;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.act_clase_12_08.model.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuActivity extends AppCompatActivity {

    private TextView usuarioTextView;
    private FrameLayout ly;
    private Usuario user;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        usuarioTextView = findViewById(R.id.usuario);
        btn = findViewById(R.id.pagina);


        setTitle("Menu");



        FloatingActionButton btnEmail = findViewById(R.id.email);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(v);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHtml(v);
            }
        });

        savedInstanceState = getIntent().getExtras();
        if(savedInstanceState != null) {
            user = (Usuario) savedInstanceState.get(Constants.USUARIO);
            usuarioTextView.setText(getString(R.string.welcome)+ " " + user.getUsuario() + "!!! y tu password es: "+user.getPassword());
        }
        else{
            usuarioTextView.setText("ERROR");
        }



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
                Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_LONG).show();
            }else if(resultCode == Activity.RESULT_OK){
                Toast.makeText(getApplicationContext(),"Enviado",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void openHtml(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://iua.edu.ar"));
        startActivity(i);

    }/*
    private void openImage(View v){

    }
    private void open(View v){

    }
    private void openHtml(View v){

    }
    private void openHtml(View v){

    }*/
}
