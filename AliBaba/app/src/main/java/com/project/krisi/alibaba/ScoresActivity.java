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

        //List<HighScores> scores = HighScores.listAll(HighScores.class);

        List<HighScores> scores = Select.from(HighScores.class)
                .orderBy("score desc").limit("1")
                .list();

        TableLayout table = (TableLayout)findViewById(R.id.table_layout);

        for(HighScores result:scores){
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            row.setGravity(16);//center_horizontal

            String name = result.getName();
            final TextView tvName = new TextView(this);
            tvName.setText(name);
            tvName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tvName.setTextSize(18);
            tvName.setGravity(17);//center

            int points = result.getScore();
            final TextView tvPoints = new TextView(this);
            tvPoints.setText("" + points);
            tvPoints.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tvPoints.setTextSize(18);
            tvPoints.setGravity(17);//center

            TableRow.LayoutParams params = new TableRow.LayoutParams();
            params.span = 6;
            row.addView(tvName, params);
            row.addView(tvPoints, params);
            table.addView(row);
        }
    }
}
