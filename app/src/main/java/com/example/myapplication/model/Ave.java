package com.example.myapplication.model;
public class Ave extends Animal {
    private String envergadura;
    public String color;
    public String pico;


    public String getPico() {
        return pico;
    }

    public void setPico(String pico) {
        this.pico = pico;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(String envergadura) {
        this.envergadura = envergadura;
    }
    public Ave(int id, String especie, String nomCientifico, String habitat, int pesoProm, String estadoConserv, String envergadura, String color, String pico, int precio) {
        super(id, especie, nomCientifico, habitat, pesoProm, estadoConserv,precio);
        this.envergadura = envergadura;
        this.color = color;
        this.pico = pico;
    }
}
