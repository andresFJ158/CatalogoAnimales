package com.example.myapplication.manager;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.model.Animal;
import com.example.myapplication.model.Mamifero;
import com.example.myapplication.model.Ave;
import com.example.myapplication.model.AveRapaz;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager instance;
    private final List<Animal> animals = new ArrayList<>();
    private RequestQueue requestQueue;
    private final String BASE_URL = "https://raw.githubusercontent.com/adancondori/TareaAPI/refs/heads/main";

    private DataManager(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    public static DataManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("DataManager no inicializado. Llama primero a getInstance(Context)");
        }
        return instance;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public interface OnDataLoadedListener {
        void onSuccess();
        void onError(String error);
    }

    public void fetchAnimals(OnDataLoadedListener listener) {
        String url = "https://raw.githubusercontent.com/adancondori/TareaAPI/refs/heads/main/api/animales.json";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    animals.clear();
                    try {
                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONArray animalesArray = jsonResponse.getJSONArray("animales");

                        for (int i = 0; i < animalesArray.length(); i++) {
                            JSONObject obj = animalesArray.getJSONObject(i);

                            // Detectamos el tipo de animal
                            String tipo = obj.getString("tipo");

                            Animal animal;
                            if ("mamifero".equalsIgnoreCase(tipo)) {
                                // Crear un objeto Mamifero
                                animal = new Mamifero(i, "", "", "", 0, "", "",0,"",0);
                                animal.setEspecie(obj.getString("especie"));
                                animal.setNomCientifico(obj.getString("nombreCientifico"));
                                animal.setHabitat(obj.getString("habitat"));
                                animal.setPesoProm(obj.getInt("pesoPromedio"));
                                animal.setEstadoConserv(obj.getString("estadoConservacion"));
                            } else if ("ave".equalsIgnoreCase(tipo)) {
                                // Crear un objeto Ave
                                animal = new Ave(i, "", "", "", 0, "", "","","",0);
                                animal.setEspecie(obj.getString("especie"));
                                animal.setNomCientifico(obj.getString("nombreCientifico"));
                                animal.setHabitat(obj.getString("habitat"));
                                animal.setPesoProm(obj.getInt("pesoPromedio"));
                                animal.setEstadoConserv(obj.getString("estadoConservacion"));
                            } else if ("ave_rapaz".equalsIgnoreCase(tipo)) {
                                // Crear un objeto AveRapaz
                                animal = new AveRapaz(i, "", "", "", 0, "", "", "","",0,"",0,0); // Asegúrate de que AveRapaz tenga el constructor adecuado
                                animal.setEspecie(obj.getString("especie"));
                                animal.setNomCientifico(obj.getString("nombreCientifico"));
                                animal.setHabitat(obj.getString("habitat"));
                                animal.setPesoProm(obj.getInt("pesoPromedio"));
                                animal.setEstadoConserv(obj.getString("estadoConservacion"));
                                // Por ejemplo, si AveRapaz tiene un campo para la imagen:
                                ((AveRapaz) animal).setImg(obj.getInt("imagen")); // Asumiendo que "imagen" es el campo en el JSON
                            } else {
                                // Si el tipo no es mamífero, ave o ave rapaz, creamos un animal genérico
                                animal = new Animal(i, "", "", "", 0, "", 0);
                                animal.setEspecie(obj.getString("especie"));
                                animal.setNomCientifico(obj.getString("nombreCientifico"));
                                animal.setHabitat(obj.getString("habitat"));
                                animal.setPesoProm(obj.getInt("pesoPromedio"));
                                animal.setEstadoConserv(obj.getString("estadoConservacion"));
                            }

                            animals.add(animal);
                        }
                        listener.onSuccess();
                    } catch (JSONException e) {
                        listener.onError("Error al procesar JSON: " + e.getMessage());
                    }
                },
                error -> listener.onError("Error de red: " + error.getMessage())
        );

        requestQueue.add(request);
    }

}
