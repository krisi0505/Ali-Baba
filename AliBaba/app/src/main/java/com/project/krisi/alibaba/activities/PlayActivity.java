package com.project.krisi.alibaba.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.krisi.alibaba.R;
import com.project.krisi.alibaba.views.ItemView;

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

            ItemView item = new ItemView(this);

            //create a linearlayout for each item
            final LinearLayout l = new LinearLayout(this);
            l.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            l.setGravity(17);//center
            l.setOrientation(LinearLayout.VERTICAL);
            l.addView(item);
            
            //add the item to the linearlayout
            jemContainer.addView(l);

            // save a reference to the textview for later
            prices[i-1] = item.mPrice;
            volumes[i-1] = item.mVolume;
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
                    final ItemView view = (ItemView) event.getLocalState();

                    final TextView tvPrice = (TextView) view.mTVPrice;
                    String price = tvPrice.getText().toString();
                    final TextView tvVolume = (TextView) view.mTVVolume;
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
