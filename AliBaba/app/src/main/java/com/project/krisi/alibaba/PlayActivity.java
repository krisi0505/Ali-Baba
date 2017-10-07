package com.project.krisi.alibaba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        LinearLayout ll=(LinearLayout)findViewById(R.id.precious);

        final int N = 5; // total number of textviews to add

        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 1; i <= N; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            rowTextView.setText(""+i);
            rowTextView.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
            rowTextView.setTextSize(28);
            rowTextView.setGravity(17);//center

            // add the textview to the linearlayout
            ll.addView(rowTextView);

            // save a reference to the textview for later
            myTextViews[i-1] = rowTextView;
        }
    }
}
