package com.lab02.appmedica;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable {
    String nombre, direccion, dni;
    ArrayList<Visita> visitas = new ArrayList<Visita>();

    public Paciente(){}
    public Paciente(String nombre, String dni, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setVisita(Visita visita) {
        visitas.add(visita);
    }

    public Visita getVisita(int i) {
        return visitas.get(i);
    }
}
