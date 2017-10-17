package com.project.krisi.alibaba.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.krisi.alibaba.R;

public abstract class KnapsackActivity extends AppCompatActivity {

    public int knapSack(int[] prices, int[] volumes, int capacity, int n){
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (volumes[n-1] > capacity) {
            return knapSack(prices, volumes, capacity, n - 1);
        }
        else {
            return Math.max( prices[n-1] + knapSack(prices, volumes, capacity-volumes[n-1], n-1),
                    knapSack(prices, volumes, capacity, n-1));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knapsack);
    }
}
