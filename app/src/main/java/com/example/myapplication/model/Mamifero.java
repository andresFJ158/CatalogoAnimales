package com.example.myapplication.model;

public class Mamifero extends Animal {
    private String temperatura;
    private int tiempoGest;
    private String alimentacion;


    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public int getTiempoGest() {
        return tiempoGest;
    }

    public void setTiempoGest(int tiempoGest) {
        this.tiempoGest = tiempoGest;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    public Mamifero(int id, String especie, String nomCientifico, String habitat, int pesoProm, String estadoConserv, String temperatura, int tiempoGest, String alimentacion, int precio) {
        super(id, especie, nomCientifico, habitat, pesoProm, estadoConserv, precio);
        this.temperatura = temperatura;
        this.tiempoGest = tiempoGest;
        this.alimentacion = alimentacion;
    }
}
