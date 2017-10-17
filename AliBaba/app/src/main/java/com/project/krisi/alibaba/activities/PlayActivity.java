package com.project.krisi.alibaba.activities;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.project.krisi.alibaba.R;

import java.util.Random;

public class PlayActivity extends KnapsackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        LinearLayout jemContainer =(LinearLayout)findViewById(R.id.precious);

        final int score = 0;
        final int N = 3; // total number of textviews to add

        final int[] prices = new int[N]; // create an empty array;
        final int[] volumes = new int[N]; // create an empty array;

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

            Random randV = new Random();
            int  randomVolume = randV.nextInt(16) + 1;

            // create a new textview
            final TextView volume = new TextView(this);

            // set some properties of textview
            volume.setText(randomVolume + "L");
            volume.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
            volume.setTextSize(20);
            volume.setTextColor(Color.WHITE);
            volume.setGravity(17);//center

            //create a linearlayout for each item
            final LinearLayout item = new LinearLayout(this);
            item.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
            item.setGravity(17);//center
            item.setOrientation(LinearLayout.VERTICAL);
            item.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ClipData data = ClipData.newPlainText("","");
                    View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, myShadowBuilder, v,0);
                    } else {
                        v.startDrag(data, myShadowBuilder, v,0);
                    }
                    return true;
                }
            });

            // add the textview to the linearlayout
            item.addView(img);
            item.addView(price);
            item.addView(volume);

            //add the item to the linearlayout
            jemContainer.addView(item);

            // save a reference to the textview for later
            prices[i-1] = randomPrice;
            volumes[i-1] = randomVolume;
        }

        final TextView capacity = (TextView)findViewById(R.id.capacity_number);
        final TextView total = (TextView)findViewById(R.id.total_number);

        ImageView imgBag = (ImageView)findViewById(R.id.img_bag);
        imgBag.setOnDragListener(new View.OnDragListener() {
            public int capacityLeft = 20;
            public int money = 0;

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int dragEvent = event.getAction();

                if(dragEvent == DragEvent.ACTION_DROP) {
                    final ViewGroup view = (ViewGroup) event.getLocalState();

                    final TextView tvPrice = (TextView) view.getChildAt(1);
                    String price = tvPrice.getText().toString();
                    final TextView tvVolume = (TextView) view.getChildAt(2);
                    String volume = tvVolume.getText().toString();
                    int priceNumber = Integer.parseInt(price.substring(1));
                    int volumeNumber = Integer.parseInt(volume.substring(0, volume.length() - 1));
                    if (capacityLeft - volumeNumber >= 0) {
                        money += priceNumber;
                        capacityLeft -= volumeNumber;
                        total.setText("" + money);
                        capacity.setText("" + capacityLeft);
                        view.setVisibility(View.INVISIBLE);
                    }
                }

                return true;
            }
        });

        final Button btnGo = (Button) findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent savingActivity = new Intent(PlayActivity.this, SavingActivity.class);
                    Bundle myBundle = new Bundle();
                    final int maxScore = knapSack(prices, volumes, 20, N);

                    String strTotal = total.getText().toString();
                    final int playerScore = Integer.parseInt(strTotal);

                    int finalScore = playerScore*100/maxScore;
                    myBundle.putInt("score", finalScore + score);
                    savingActivity.putExtras(myBundle);
                    startActivity(savingActivity);
                    finish();
            }
        });
    }
}
