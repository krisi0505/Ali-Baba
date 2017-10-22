package com.project.krisi.alibaba.activities;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.krisi.alibaba.R;
import com.project.krisi.alibaba.fragments.BagFragment;
import com.project.krisi.alibaba.views.ItemView;

public class PlayActivity extends KnapsackActivity implements SensorEventListener {
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    final int N = 3; // total number of items to add

    public int getN(){
        return N;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);

        BagFragment bagFragment = new BagFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_bag, bagFragment);
        transaction.commit();

        LinearLayout gemContainer = (LinearLayout)findViewById(R.id.gem_container);

        final int score = 0;


        final int[] prices = new int[N]; // create an empty array;
        final int[] volumes = new int[N]; // create an empty array;

        //create items
        for (int i = 1; i <= N; i++) {

            ItemView item = new ItemView(this);

            //create a LinearLayout for each item
            final LinearLayout ll = new LinearLayout(this);

            //set layout width = 0, height = wrap_content and weight = 1
            ll.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            ll.setGravity(17);//center
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.addView(item);

            //add the item to the gemContainer
            gemContainer.addView(ll);

            // save a reference to the prices and volumes for later
            prices[i-1] = item.mPrice;
            volumes[i-1] = item.mVolume;
        }

        final TextView capacity = (TextView)findViewById(R.id.capacity_number);
        final TextView total = (TextView)findViewById(R.id.total_number);

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

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
