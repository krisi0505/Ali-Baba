package com.project.krisi.alibaba;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        LinearLayout jemContainer =(LinearLayout)findViewById(R.id.precious);

        final int N = 5; // total number of textviews to add

        final TextView[] prices = new TextView[N]; // create an empty array;
        final LinearLayout[] items = new LinearLayout[N];

        for (int i = 1; i <= N; i++) {
            //create a random price
            Random rand = new Random();
            int  randomPrice = rand.nextInt(500) + 1;

            //create an imageview
            final ImageView img = new ImageView(this);
            img.setLayoutParams(new LayoutParams(64, 64));
            if(randomPrice<100){
                img.setImageResource(R.drawable.coins);
            }
            else if(randomPrice<200){
                img.setImageResource(R.drawable.emerald);
            }
            else if(randomPrice<300){
                img.setImageResource(R.drawable.ruby);
            }
            else if(randomPrice<400){
                img.setImageResource(R.drawable.ring);
            }
            else{
                img.setImageResource(R.drawable.diamond);
            }

            // create a new textview
            final TextView price = new TextView(this);

            // set some properties of textview
            price.setText("$" + randomPrice);
            price.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
            price.setTextSize(20);
            price.setTextColor(Color.WHITE);
            price.setGravity(17);//center

            //create a linearlayout for each item
            final LinearLayout item = new LinearLayout(this);
            item.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
            item.setGravity(17);//center
            item.setOrientation(LinearLayout.VERTICAL);

            // add the textview to the linearlayout
            item.addView(img);
            item.addView(price);

            //add the item to the linearlayout
            jemContainer.addView(item);

            // save a reference to the textview for later
            prices[i-1] = price;
        }

        Button btnGo = (Button) findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent savingActivity = new Intent(PlayActivity.this, SavingActivity.class);
                startActivity(savingActivity);
            }
        });
    }
}
