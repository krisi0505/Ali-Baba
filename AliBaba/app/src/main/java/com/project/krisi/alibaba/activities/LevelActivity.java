package com.project.krisi.alibaba.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.project.krisi.alibaba.R;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        ImageView spaceshipImage = (ImageView) findViewById(R.id.chest);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.level);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
    }
}
