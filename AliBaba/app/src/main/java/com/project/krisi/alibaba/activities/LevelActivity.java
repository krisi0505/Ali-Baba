package com.project.krisi.alibaba.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.project.krisi.alibaba.R;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        LinearLayout level = (LinearLayout)findViewById(R.id.level_layout);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        level.startAnimation(rotateAnimation);

        ImageView chest = (ImageView) findViewById(R.id.chest);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.level);
        chest.startAnimation(animation);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
            /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(LevelActivity.this,PlayActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);
    }
}
