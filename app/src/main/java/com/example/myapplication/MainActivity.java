package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edCliente;
    private Button btnIngresar,btnSalir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCliente=findViewById(R.id.edEmpleado);
        btnIngresar=findViewById(R.id.btnIngresar);
        btnSalir=findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Cliente=edCliente.getText().toString().trim();
                if (edCliente.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "No ingreso cliente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intento=new Intent(MainActivity.this, MainActivity2.class);
                    intento.putExtra("Cliente",Cliente);
                    startActivity(intento);
                    finish();
                }

            }
        });

    }
}