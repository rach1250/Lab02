package com.lab02.appmedica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button registro, visita, correo;
    TextView nombre, detalle;
    Paciente paciente;
    Visita nuevaVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(getIntent().getSerializableExtra("Paciente") != null){
            paciente = (Paciente)getIntent().getSerializableExtra("Paciente");
            nombre = findViewById(R.id.NombrePaciente);
            nombre.setText("Paciente " + paciente.nombre);
        }*/

        registro = (Button) findViewById(R.id.Registro);
        visita = (Button) findViewById(R.id.Visita);
        correo = (Button) findViewById(R.id.Correo);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boton_RegistrarPaciente();
            }
        });

        visita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paciente != null){
                    Boton_VisitaPaciente();
                }
                else{
                    Boton_RegistrarPaciente();
                }
            }
        });

        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paciente != null){
                    Boton_EnviarCorreo();
                }
                else{
                    Boton_RegistrarPaciente();
                }
            }
        });
    }

    private void Boton_RegistrarPaciente(){
        Intent intent = new Intent(this, RegistroPaciente.class);
        startActivityForResult(intent, 1);
    }

    private void Boton_VisitaPaciente(){
        Intent intent = new Intent(this, NuevaVisita.class);
        intent.putExtra("Paciente", paciente);
        startActivityForResult(intent, 2);
    }

    private void Boton_EnviarCorreo(){
        Intent intent = new Intent(this, Correo.class);
        intent.putExtra("Paciente", paciente);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            paciente = (Paciente) data.getSerializableExtra("Paciente");
            nombre = findViewById(R.id.NombrePaciente);
            nombre.setText("Paciente: " + paciente.nombre + "\nDNI: " + paciente.dni);
        }

        if(requestCode == 2){
            paciente = (Paciente) data.getSerializableExtra("Paciente");
            nombre = findViewById(R.id.NombrePaciente);
            nombre.setText("Paciente: " + paciente.nombre + "\nDNI: " + paciente.dni);

            nuevaVisita = paciente.getVisita(paciente.getVisitaSize() - 1);
            detalle = findViewById(R.id.DetallePaciente);
            detalle.setText("Peso: " + nuevaVisita.getPeso() + "\nTemperatura: " + nuevaVisita.getTemperatura() +
                    "\nPresión: " + nuevaVisita.getPresion() + "\nNivel Saturación: " + nuevaVisita.getNivelSaturacion());
        }
    }
}