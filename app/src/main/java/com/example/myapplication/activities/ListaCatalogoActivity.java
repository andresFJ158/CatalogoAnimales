package com.example.myapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapte.AnimalAdapter;
import com.example.myapplication.manager.DataManager;
import com.example.myapplication.model.Animal;
import java.util.List;

public class ListaCatalogoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_catalogo);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Animal> animals = DataManager.getInstance().getAnimals();

        adapter = new AnimalAdapter(animals, this);
        recyclerView.setAdapter(adapter);

        // Botón de volver
        findViewById(R.id.btnVolver).setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Actualizar la lista si hay cambios
        adapter.notifyDataSetChanged();
    }
}