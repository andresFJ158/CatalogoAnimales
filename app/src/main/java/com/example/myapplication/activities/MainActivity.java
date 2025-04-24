package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;
import com.example.myapplication.manager.DataManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar datos
        DataManager.getInstance();

        CardView cardViewVerEmpleados = findViewById(R.id.cardViewVerAnimales);
        cardViewVerEmpleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListaCatalogoActivity.class));
            }
        });

    }
}