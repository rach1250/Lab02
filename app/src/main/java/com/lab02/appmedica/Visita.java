package com.lab02.appmedica;

import java.io.Serializable;

public class Visita implements Serializable {
    int peso, temperatura, presion, nivelSaturacion;

    public Visita(){}

    public Visita(int peso, int temperatura, int presion, int nivelSaturacion){
        this.peso = peso;
        this.temperatura = temperatura;
        this.presion = temperatura;
        this.nivelSaturacion = nivelSaturacion;
    }

    public int getPeso() {
        return peso;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getPresion() {
        return presion;
    }

    public int getNivelSaturacion() {
        return nivelSaturacion;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public void setNivelSaturacion(int nivelSaturacion) {
        this.nivelSaturacion = nivelSaturacion;
    }
}
