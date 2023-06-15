package com.example.animacionesytransiciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;

import com.example.animacionesytransiciones.databinding.ActivityMainBinding;
import com.example.animacionesytransiciones.databinding.ActivityTransitionBinding;

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Transicion 1");
        binding = ActivityTransitionBinding.inflate(getLayoutInflater());

        binding.btnIrAtras.setOnClickListener(v -> {
            startActivity(new Intent(this,MainActivity.class ));
        });

        binding.btnFade.setOnClickListener(v -> {
            Intent intent = new Intent(this,SubActivity.class );
            intent.putExtra("transicion", "fade");
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });
        binding.btnZoom.setOnClickListener(v -> {
            Intent intent = new Intent(this,SubActivity.class );
            intent.putExtra("transicion", "zoom");
            startActivity(intent);
            overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);
        });
        binding.btnLeftIn.setOnClickListener(v -> {
            Intent intent = new Intent(this,SubActivity.class );
            intent.putExtra("transicion", "leftIn");
            startActivity(intent);
            overridePendingTransition(R.anim.left_in,R.anim.left_out);
        });

        binding.btnCompartir.setOnClickListener(v ->{
            Intent intent = new Intent(this,SubActivity.class );
            intent.putExtra("transicion", "fade");
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,binding.img, ViewCompat.getTransitionName(binding.img));
            startActivity(intent,optionsCompat.toBundle());
        });
        setContentView(binding.getRoot());
    }
}