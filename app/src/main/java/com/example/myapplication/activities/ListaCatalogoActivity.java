package com.example.myapplication.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapte.AnimalAdapter;
import com.example.myapplication.manager.DataManager;
import com.example.myapplication.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class ListaCatalogoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalAdapter adapter;
    private Button btnVolver, btnCargar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_catalogo);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Iniciar con una lista vacía
        adapter = new AnimalAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        // Botones
        ImageButton btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> finish());

        btnCargar = findViewById(R.id.btnCargar);

        // Volver atrás
        btnVolver.setOnClickListener(v -> finish());

        // Cargar datos desde la API
        btnCargar.setOnClickListener(v -> {
            DataManager.getInstance(this).fetchAnimals(new DataManager.OnDataLoadedListener() {
                @Override
                public void onSuccess() {
                    List<Animal> animals = DataManager.getInstance().getAnimals();
                    adapter = new AnimalAdapter(animals, ListaCatalogoActivity.this);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(ListaCatalogoActivity.this, "Datos cargados correctamente", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String error) {
                    Toast.makeText(ListaCatalogoActivity.this, "Error al cargar: " + error, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
