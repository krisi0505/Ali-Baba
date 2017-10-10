package com.project.krisi.alibaba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SavingActivity extends AppCompatActivity {

    public void showScore(int score){
        TextView tv = (TextView)findViewById(R.id.score);
        tv.setText("Your score is " + score);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int score = bundle.getInt("score");

        showScore(score);
    }
}
