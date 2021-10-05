package com.lab02.appmedica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroPaciente extends AppCompatActivity {
    EditText nombre, direccion, dni;
    Button registro;
    Paciente nuevoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);

        nombre = (EditText) findViewById(R.id.nombreP);
        dni = (EditText) findViewById(R.id.dniP);
        direccion = (EditText) findViewById(R.id.direccionP);

        registro = (Button) findViewById(R.id.RegistroVisita);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String text_nombre = nombre.getText().toString();
                final String text_dni = dni.getText().toString();
                final String text_direccion = direccion.getText().toString();

                nuevoPaciente = new Paciente(text_nombre, text_dni, text_direccion);
                Boton_RegistrarPaciente();
            }
        });
    }

    private void Boton_RegistrarPaciente(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Paciente", nuevoPaciente);
        setResult(1, intent);
        finish();
    }
}