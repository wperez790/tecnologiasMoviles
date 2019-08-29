package com.example.act_clase_12_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.act_clase_12_08.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText inputUser;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gym");

        btn = findViewById(R.id.button_login);
        inputUser = findViewById(R.id.input_user);
        inputPassword= findViewById(R.id.input_password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });
    }

    private void login(View view){

        Usuario u =  new Usuario(
                inputUser.getText().toString(),
                inputPassword.getText().toString());

        Intent listIntent = new Intent(MainActivity.this, MenuActivity.class);
        listIntent.putExtra(Constants.USUARIO, u);
        startActivity(listIntent);


    }
}
