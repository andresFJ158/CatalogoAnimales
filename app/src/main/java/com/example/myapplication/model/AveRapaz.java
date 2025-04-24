package com.example.myapplication.model;

// TecnicoSenior.java
public class AveRapaz extends Ave {
    private int velocidad;
    private String presa;
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getPresa() {
        return presa;
    }

    public void setPresa(String presa) {
        this.presa = presa;
    }

    public AveRapaz(int id, String especie, String nomCientifico, String habitat, int pesoProm, String estadoConserv, String envergadura, String color, String pico, int velocidad, String presa,int img,int precio) {
        super(id, especie, nomCientifico, habitat, pesoProm, estadoConserv, envergadura, color, pico,precio);
        this.velocidad = velocidad;
        this.presa = presa;
        this.img = img;
    }
}