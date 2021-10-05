package com.lab02.appmedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NuevaVisita extends AppCompatActivity {
    EditText peso, temperatura, presion, nivelSaturacion;
    TextView dni;
    Button registro;
    Paciente paciente;
    Visita nuevaVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_visita);

        paciente = (Paciente)getIntent().getSerializableExtra("Paciente");
        dni = findViewById(R.id.dniPaciente);
        dni.setText("Paciente: " + paciente.dni);

        peso = (EditText) findViewById(R.id.peso);
        temperatura = (EditText) findViewById(R.id.temperatura);
        presion = (EditText) findViewById(R.id.presion);
        nivelSaturacion = (EditText) findViewById(R.id.nivelSaturacion);

        registro = (Button) findViewById(R.id.RegistroVisita);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int text_peso = Integer.parseInt(peso.getText().toString());
                int text_temperatura = Integer.parseInt(temperatura.getText().toString());
                int text_presion = Integer.parseInt(presion.getText().toString());
                int text_nivelSaturacion = Integer.parseInt(nivelSaturacion.getText().toString());

                nuevaVisita = new Visita(text_peso, text_temperatura, text_presion, text_nivelSaturacion);
                paciente.setVisita(nuevaVisita);

                Boton_RegistrarVisita();
            }
        });
    }

    private void Boton_RegistrarVisita(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Paciente", paciente);
        setResult(1, intent);
        finish();
    }
}