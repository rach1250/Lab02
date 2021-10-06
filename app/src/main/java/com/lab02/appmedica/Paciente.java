package com.lab02.appmedica;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable {
    String nombre, direccion, dni, correo;
    ArrayList<Visita> visitas = new ArrayList<Visita>();

    public Paciente(){}
    public Paciente(String nombre, String dni, String direccion, String correo){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.correo = correo;
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

    public String getCorreo() { return correo; }

    public int getVisitaSize(){ return visitas.size(); }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) { this.correo = correo; }

    public void setVisita(Visita visita) {
        visitas.add(visita);
    }

    public Visita getVisita(int i) {
        return visitas.get(i);
    }
}
