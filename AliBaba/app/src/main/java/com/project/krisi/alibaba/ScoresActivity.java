package com.project.krisi.alibaba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        List<HighScores> scores = HighScores.listAll(HighScores.class);

        
    }
}
