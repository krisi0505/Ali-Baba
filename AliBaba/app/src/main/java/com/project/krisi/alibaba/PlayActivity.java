package com.project.krisi.alibaba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        int[] numbers={1,2,3,4};

        LinearLayout layout = (LinearLayout)this.findViewById(R.id.precious);

        TextView coin = (TextView)this.findViewById(R.id.precious_item);
        coin.setText("hallo hallo");

        
    }
}
