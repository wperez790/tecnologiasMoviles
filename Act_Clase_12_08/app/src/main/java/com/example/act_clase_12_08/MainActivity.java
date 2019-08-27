package com.example.act_clase_12_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gym");

        btn = findViewById(R.id.button_login);
        input = findViewById(R.id.input_user);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });
    }

    private void login(View view){
        String user = input.getText().toString();

        Intent mainIntent = new Intent(MainActivity.this , MenuActivity.class);
        mainIntent.putExtra("Usuario", user);
        startActivity(mainIntent);
    }
}
