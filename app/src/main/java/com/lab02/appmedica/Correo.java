package com.lab02.appmedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Correo extends AppCompatActivity {
    TextView correo, asunto, mensaje;
    Paciente paciente;
    Visita nuevaVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);

        paciente = (Paciente)getIntent().getSerializableExtra("Paciente");

        nuevaVisita = paciente.getVisita(paciente.getVisitaSize() - 1);

        correo = findViewById(R.id.correoMedico);
        correo.setText("Correo: " + paciente.correo);

        asunto = findViewById(R.id.Asunto);
        asunto.setText("Ultima Visita Medica");

        mensaje = findViewById(R.id.Mensaje);
        mensaje.setText("Peso: " + nuevaVisita.getPeso() + "\nTemperatura: " + nuevaVisita.getTemperatura() +
                "\nPresión: " + nuevaVisita.getPresion() + "\nNivel Saturación: " + nuevaVisita.getNivelSaturacion());

        String enviarcorreo = correo.getText().toString();
        String enviarasunto = asunto.getText().toString();
        String enviarmensaje = mensaje.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[] { enviarcorreo });
        intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
        intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Elije un cliente de Correo:"));
        finish();
    }
}