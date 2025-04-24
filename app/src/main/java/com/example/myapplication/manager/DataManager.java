package com.example.myapplication.manager;

import com.example.myapplication.R;
import com.example.myapplication.model.Animal;
import com.example.myapplication.model.Ave;
import com.example.myapplication.model.AveRapaz;
import com.example.myapplication.model.Mamifero;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private List<Animal> animals;

    private DataManager() {
        animals = new ArrayList<>();
        // Datos de ejemplo (opcional)
        animals.add(new Mamifero(1, "Elefante Africano", "Loxodonta Africana", "Sabana", 4500, "Peligro", "36", 22,"Hierbas",15000));
        animals.add(new Mamifero(2, "Ballena Azul", "Balaenoptera musculus", "Oceano", 125000, "Peligro", "37", 11,"Carnivoro",600000));
        animals.add(new Mamifero(3, "Oso Polar", "Ursus Maritimus", "Artantica", 400, "Vulnerable", "37", 7,"Carnivoro",999999));
        animals.add(new AveRapaz(1, "Aguila real", "diurna", "Montañas", 5, "Preocupacion menor", "1,8", "Marron","Ganchudo",240,"Mamiferos medianos", R.drawable.ic_aguila,5000));
        animals.add(new AveRapaz(2, "Halcon peregrino", "Falcon peregrinus", "Montañas", 2, "Preocupacion menor", "0,8", "Gris Azulado","Ganchudo",389,"Aves en vuelo",R.drawable.ic_falcon,7000));
        animals.add(new AveRapaz(3, "Buho real", "Bubo bubo", "Bosques", 3, "Preocupacion menor", "2", "Marron, beige y negro","Corto",80,"Mamiferos pequeños",R.drawable.ic_buho,500));
        animals.add(new Ave(1, "Paloma", "Columba livia", "Areas urbanas", 1, "Preocupacion menor", "0,5", "Gris","Corto y recto",100));
        animals.add(new Ave(1, "Gorrion", "Passer", "Areas urbanas", 1, "Preocupacion menor", "0,5", "Gris","Corto y recto",50));

    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void agregarAnimal(Animal animal) {
        animals.add(animal);
    }
    public int generarNuevoId() {
        if (animals.isEmpty()) {
            return 1;
        }
        return animals.get(animals.size() - 1).getId() + 1;
    }
}