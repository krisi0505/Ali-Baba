package com.project.krisi.alibaba.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.project.krisi.alibaba.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playActivity = new Intent(HomeActivity.this, PlayActivity.class);

                Bundle myBundle = new Bundle();
                myBundle.putInt("score", 0);
                myBundle.putInt("N", 3);
                playActivity.putExtras(myBundle);

                startActivity(playActivity);
            }
        });

        Button btnInstructions = (Button) findViewById(R.id.btn_instructions);
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instructionsActivity = new Intent(HomeActivity.this, InstructionsActivity.class);
                startActivity(instructionsActivity);
            }
        });

        Button btnHighScores = (Button) findViewById(R.id.btn_scores);
        btnHighScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoresActivity = new Intent(HomeActivity.this, ScoresActivity.class);
                startActivity(scoresActivity);
            }
        });
    }
}
