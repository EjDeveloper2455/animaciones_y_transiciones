package com.example.animacionesytransiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.animacionesytransiciones.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ObjectAnimator animacionEjeX;
    private ObjectAnimator animacionEjeY;
    private ObjectAnimator animacionAlpha;
    private ObjectAnimator animacionRotar;
    private AnimatorSet animatorSet;
    private long animationDuracion = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.btnEjeX.setOnClickListener(v -> {
            animacion("ejeX");
        });
        binding.btnEjeY.setOnClickListener(v -> {
            animacion("ejeY");
        });
        binding.btnAlpha.setOnClickListener(v -> {
            animacion("alpha");
        });
        binding.btnRotar.setOnClickListener(v -> {
            animacion("rotar");
        });
        binding.btnTodo.setOnClickListener(v -> {
            animacion("todo");
        });
        binding.btnBucle.setOnClickListener(v -> {
            animacion("blucle");
        });
        binding.btnScale.setOnClickListener(v -> {
            animacion("scale");
        });

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        binding.btnIr.setOnClickListener(v ->{
            startActivity(new Intent(this,TransitionActivity.class));
        });
        setContentView(binding.getRoot());
    }
    public void animacion(String animacion){
        switch(animacion){
            case "ejeX":
                animacionEjeX = ObjectAnimator.ofFloat(binding.img1,"x",300f);
                animacionEjeX.setDuration(animationDuracion);
                AnimatorSet animatorSetX = new AnimatorSet();
                animatorSetX.play(animacionEjeX);
                animatorSetX.start();
                break;
            case "ejeY":
                animacionEjeY = ObjectAnimator.ofFloat(binding.img2,"y",300f);
                animacionEjeY.setDuration(animationDuracion);
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.play(animacionEjeY);
                animatorSetY.start();
                break;
            case "alpha":
                animacionAlpha = ObjectAnimator.ofFloat(binding.img3, View.ALPHA,1.0f,0.0f);
                animacionAlpha.setDuration(animationDuracion);
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                animatorSetAlpha.play(animacionAlpha);
                animatorSetAlpha.start();
                break;
            case "rotar":
                animacionRotar = ObjectAnimator.ofFloat(binding.img4, "rotation",0f,360f);
                animacionRotar.setDuration(animationDuracion);
                AnimatorSet animatorSetRotar = new AnimatorSet();
                animatorSetRotar.play(animacionRotar);
                animatorSetRotar.start();
                break;
            case "todo":
                animacionAlpha = ObjectAnimator.ofFloat(binding.img5, View.ALPHA,1.0f,0.0f);
                animacionAlpha.setDuration(animationDuracion);
                animacionEjeX = ObjectAnimator.ofFloat(binding.img5,"x",300f);
                animacionEjeX.setDuration(animationDuracion);
                animacionRotar = ObjectAnimator.ofFloat(binding.img5, "rotation",0f,360f);
                animacionRotar.setDuration(animationDuracion);

                AnimatorSet animatorSetTodo = new AnimatorSet();
                animatorSetTodo.playTogether(animacionAlpha,animacionEjeX,animacionRotar);
                animatorSetTodo.start();
                break;
            case "blucle":

                animacionEjeX = ObjectAnimator.ofFloat(binding.img6,"x",300f);
                animacionEjeX.setDuration(animationDuracion);

                AnimatorSet animatorSetBlucle = new AnimatorSet();
                animatorSetBlucle.play(animacionEjeX);
                animatorSetBlucle.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animation.start();
                    }
                });
                animatorSetBlucle.start();
                break;
            case "scale":
                Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
                binding.img7.startAnimation(animationScale);

                break;
        }
    }
}