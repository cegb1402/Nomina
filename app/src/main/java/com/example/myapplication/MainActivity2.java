package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvCliente,subtotal,impuesto,totalPagar;
    private EditText edRecibo,nombre,horastrabajadas,horasextras;
    private Button calcular,limpiar,cerrar;

    public void objeto(){
        tvCliente=findViewById(R.id.tvCliente);
        subtotal=findViewById(R.id.tvSubtotall);
        impuesto=findViewById(R.id.tviMPUESTO);
        totalPagar=findViewById(R.id.tvtotal);
        edRecibo=findViewById(R.id.edRecibo);
        nombre=findViewById(R.id.edNombre);
        horastrabajadas=findViewById(R.id.edHorasTrabajadas);
        horasextras=findViewById(R.id.edHorasExtras);
        calcular=findViewById(R.id.btnCalcular);
        limpiar=findViewById(R.id.btnlimpiar);
        cerrar=findViewById(R.id.btncERRAR);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        objeto();
        String cliente= getIntent().getStringExtra("Cliente");
        tvCliente.setText(cliente);
        nombre.setText(cliente);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtotal.setText("Subtotal: $");
                impuesto.setText("Impuesto: $");
                totalPagar.setText("TotalPagar: $");
                edRecibo.setText("");
                horastrabajadas.setText("");
                horasextras.setText("");

            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edRecibo.getText().toString().matches("")|| horasextras.getText().toString().matches("")||horastrabajadas.getText().toString().matches("")
                ){
                    Toast.makeText(MainActivity2.this, "no ingreso datos suficientes para calcular", Toast.LENGTH_SHORT).show();
                }
                else {
                    nominaClass nomima = new nominaClass();
                    nomima.setNombre(tvCliente.getText().toString());
                    nomima.setHorasNormal(Float.parseFloat(horastrabajadas.getText().toString()));
                    nomima.setHorasExtras(Float.parseFloat(horasextras.getText().toString()));
                    nomima.setNumRecibo(Integer.parseInt(edRecibo.getText().toString()));
                    nomima.setPuesto(obtenerPuesto());

                    subtotal.setText("Subtotal: $"+nomima.calcularSubtotal());
                    totalPagar.setText("Total: $"+nomima.calcularTotal());
                    impuesto.setText("Impuesto: $"+nomima.calcularImpuesto());
                }




            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intento);
                finish();
            }
        });


    }


    private int obtenerPuesto(){
        int puesto=0;
        RadioButton auxiliar=findViewById(R.id.auxiliar);
        RadioButton albanil=findViewById(R.id.albanil);
        RadioButton ingobra=findViewById(R.id.ingObra);

        if (auxiliar.isChecked()){
            puesto=1;
        } else if (albanil.isChecked()) {
            puesto=2;
        } else if (ingobra.isChecked()) {
            puesto=3;

        }

        return puesto;
    }
}