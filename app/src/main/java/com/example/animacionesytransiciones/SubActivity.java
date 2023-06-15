package com.example.animacionesytransiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.example.animacionesytransiciones.databinding.ActivitySubBinding;
import com.example.animacionesytransiciones.databinding.ActivityTransitionBinding;

public class SubActivity extends AppCompatActivity {
    private ActivitySubBinding binding;
    private AnimationDrawable batteryAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Transicion 2");
        binding = ActivitySubBinding.inflate(getLayoutInflater());

        binding.battery.setBackgroundResource(R.drawable.animation);
        batteryAnimation = (AnimationDrawable) binding.battery.getBackground();
        batteryAnimation.start();

        binding.btnRegresar.setOnClickListener(v -> {
            startActivity(new Intent(this,TransitionActivity.class ));
            Intent intent = getIntent();
            if (intent != null) {
                String parametro1 = intent.getStringExtra("transicion");
                getTransicion(parametro1);
            }
        });
        setContentView(binding.getRoot());
    }
    public void getTransicion(String transicion){
        switch (transicion){
            case "fade":
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
            case "zoom":
                overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);
                break;
            case "leftIn":
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                break;
        }
    }

}