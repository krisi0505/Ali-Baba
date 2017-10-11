package com.project.krisi.alibaba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.orm.query.Select;

import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        List<HighScores> scores = Select.from(HighScores.class)
                .orderBy("score desc")
                .limit("10")
                .list();

        TableLayout table = (TableLayout)findViewById(R.id.table_layout);

        for(HighScores result:scores){
            //create text view for the name
            String name = result.getName();
            final TextView tvName = new TextView(this);
            tvName.setText(name);
            tvName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            tvName.setTextSize(18);
            tvName.setGravity(17);//center

            //create text view for the points/score
            int points = result.getScore();
            final TextView tvPoints = new TextView(this);
            tvPoints.setText("" + points);
            tvPoints.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            tvPoints.setTextSize(18);
            tvPoints.setGravity(17);//center

            //create a table row
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            row.setGravity(16);//center_horizontal

            TableRow.LayoutParams params = new TableRow.LayoutParams();
            params.span = 6;

            //add the views to the row
            row.addView(tvName, params);
            row.addView(tvPoints, params);

            //add the row to the table
            table.addView(row);
        }
    }
}
