package com.project.krisi.alibaba.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.krisi.alibaba.R;
import com.project.krisi.alibaba.models.HighScores;

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
        final int score = bundle.getInt("score");

        showScore(score);

        Button btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.edit_text);
                String name = et.getText().toString();

                //Check if name is too long or too short
                final int minLength = 2;
                final int maxLength = 15;
                if(name.length() < minLength){
                    Context context = getApplicationContext();
                    CharSequence text = "Your name has to be longer";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                if(maxLength < name.length()){
                    Context context = getApplicationContext();
                    CharSequence text = "Your name has to be shorter";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }

                //Check if name contains only letters and numbers
                if(!name.matches("[a-zA-Z0-9]+")){
                    return;
                }

                HighScores player = new HighScores(name, score);
                player.save();

                Intent homeActivityIntent = new Intent(SavingActivity.this, HomeActivity.class);
                startActivity(homeActivityIntent);
                finish();
            }
        });



    }
}
