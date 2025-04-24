package com.example.myapplication.model;

import java.io.Serializable;
public class Animal implements Serializable {
    private String especie;
    private String nomCientifico;
    private String habitat;
    private int pesoProm;
    private String estadoConserv;
    private int price;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomCientifico() {
        return nomCientifico;
    }

    public void setNomCientifico(String nomCientifico) {
        this.nomCientifico = nomCientifico;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getPesoProm() {
        return pesoProm;
    }

    public void setPesoProm(int pesoProm) {
        this.pesoProm = pesoProm;
    }

    public String getEstadoConserv() {
        return estadoConserv;
    }

    public void setEstadoConserv(String estadoConserv) {
        this.estadoConserv = estadoConserv;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Animal(int id, String especie, String nomCientifico, String habitat, int pesoProm, String estadoConserv, int precio) {
        this.id = id;
        this.especie = especie;
        this.nomCientifico = nomCientifico;
        this.habitat = habitat;
        this.pesoProm = pesoProm;
        this.estadoConserv = estadoConserv;
        price = precio;
    }
}