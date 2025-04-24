package com.example.myapplication.activities;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.Animal;
import com.example.myapplication.model.Mamifero;
import com.example.myapplication.model.Ave;
import com.example.myapplication.model.AveRapaz;

public class DetalleAnimalesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_animal);

        Animal animal = (Animal) getIntent().getSerializableExtra("Animal");

        TextView tvDetalle = findViewById(R.id.tvDetalle);
        ImageView ivImg = findViewById(R.id.Img);

        StringBuilder detalle = new StringBuilder();
        detalle.append("Nombre: ").append(animal.getNomCientifico()).append("\n\n");
        detalle.append("Tipo: ").append(animal.getClass().getSimpleName()).append("\n\n");
        detalle.append("Habitat: ").append(animal.getHabitat()).append("\n\n");
        detalle.append("Peso promedio: ").append(animal.getPesoProm()).append("\n\n");

        if (animal instanceof Mamifero) {
            Mamifero mamifero = (Mamifero) animal;
            detalle.append("Temperatura Corporal: ").append(mamifero.getTemperatura()).append("\n\n");
            detalle.append("Tiempo Gestion: ").append(mamifero.getTiempoGest()).append(" Hrs").append("\n\n");
            detalle.append("Alimentación: ").append(mamifero.getAlimentacion());
        } else if (animal instanceof AveRapaz) {
            AveRapaz ts = (AveRapaz) animal;
            int id = ((AveRapaz) animal).getImg();
            ivImg.setImageResource(id);
            detalle.append("Envergadura: ").append(ts.getEnvergadura()).append("\n\n");
            detalle.append("Color Plumaje: ").append(ts.getColor()).append("\n\n");
            detalle.append("Tipo Pico: ").append(ts.getPico()).append("\n\n");
            detalle.append("Velocidad vuelo: ").append(ts.getVelocidad()).append(" Km/H").append("\n\n");
            detalle.append("Tipo de presa: ").append(ts.getVelocidad());
        } else if (animal instanceof Ave) {
            Ave ave = (Ave) animal;
            detalle.append("Envergadura: ").append(ave.getEnvergadura()).append("\n\n");
            detalle.append("Color Plumaje: ").append(ave.getColor()).append("\n\n");
            detalle.append("Tipo Pico: ").append(ave.getPico());
        }

        tvDetalle.setText(detalle.toString());
    }
}