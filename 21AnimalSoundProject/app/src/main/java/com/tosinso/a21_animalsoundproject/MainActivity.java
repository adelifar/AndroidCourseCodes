package com.tosinso.a21_animalsoundproject;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton dogBtn;
    ImageButton catBtn;
    ImageButton cowBtn;
    ImageButton crowBtn;
    ImageButton monkeyBtn;
    ImageButton elephantBtn;
    Map<View, Integer> sounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setButtonsView();
        setClickListeners();
        setSounds();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setSounds() {
        sounds = new HashMap<>();
        sounds.put(dogBtn, R.raw.dog);
        sounds.put(catBtn, R.raw.cat);
        sounds.put(cowBtn, R.raw.cow);
        sounds.put(crowBtn, R.raw.crow);
        sounds.put(monkeyBtn, R.raw.monkey);
        sounds.put(elephantBtn, R.raw.elefant);
    }

    private void setClickListeners() {
        dogBtn.setOnClickListener(this);
        catBtn.setOnClickListener(this);
        cowBtn.setOnClickListener(this);
        crowBtn.setOnClickListener(this);
        monkeyBtn.setOnClickListener(this);
        elephantBtn.setOnClickListener(this);
    }

    private void setButtonsView() {
        dogBtn = findViewById(R.id.dogBtn);
        catBtn = findViewById(R.id.catBtn);
        cowBtn = findViewById(R.id.cowBtn);
        crowBtn = findViewById(R.id.crowBtn);
        monkeyBtn = findViewById(R.id.monkeyBtn);
        elephantBtn = findViewById(R.id.elephantBtn);

    }

    @Override
    public void onClick(View view) {
//        if (view==dogBtn){
//            //play dog sound
//        }else if(view==catBtn) {
//            //play cat sound
//        }
//        else if (view==cowBtn)

        play(sounds.get(view));
    }
    private void play(Integer sound){
        MediaPlayer player=MediaPlayer.create(getApplicationContext(),sound);
        player.start();
    }
}