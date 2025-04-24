package com.example.myapplication.adapte;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.DetalleAnimalesActivity;
import com.example.myapplication.model.Animal;
import com.example.myapplication.model.Mamifero;
import com.example.myapplication.model.Ave;
import com.example.myapplication.model.AveRapaz;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private List<Animal> animals;
    private Context context;

    public AnimalAdapter(List<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);

        // Configurar el color según el tipo de empleado
        int colorFondo;
        if (animal instanceof Mamifero) {
            colorFondo = Color.parseColor("#E3F2FD"); // Azul claro
        } else if (animal instanceof AveRapaz) {
            colorFondo = Color.parseColor("#E8F5E9"); // Verde claro
            int id = ((AveRapaz) animal).getImg();
            holder.ivImg.setImageResource(id);
        } else if (animal instanceof Ave) {
            colorFondo = Color.parseColor("#FFF3E0"); // Naranja claro
        } else {
            colorFondo = Color.WHITE;
        }

        holder.itemView.setBackgroundColor(colorFondo);

        holder.tvNombre.setText(animal.getEspecie());
        holder.tvEsp.setText(animal.getNomCientifico());
        holder.tvHabitat.setText("Habitat: " + animal.getHabitat());
        holder.tvPeso.setText("Peso Promedio: "+animal.getPesoProm()+" Kg");
        holder.tvPrecio.setText("Precio: "+animal.getPrice()+" Bs");


        // Click listener para abrir detalles
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleAnimalesActivity.class);
            intent.putExtra("Animal", animal);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEsp, tvHabitat,tvPeso,tvPrecio;
        ImageView ivImg;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNomEsp);
            tvEsp = itemView.findViewById(R.id.tvNomCien);
            tvHabitat = itemView.findViewById(R.id.tvHabitat);
            tvPeso = itemView.findViewById(R.id.tvPeso);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            ivImg = itemView.findViewById(R.id.ivImg);
        }
    }
}