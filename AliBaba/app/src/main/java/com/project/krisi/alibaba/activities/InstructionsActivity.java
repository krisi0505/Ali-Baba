package com.project.krisi.alibaba.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.project.krisi.alibaba.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        ImageView imgMap = (ImageView)findViewById(R.id.map);

        PhotoViewAttacher attacher = new PhotoViewAttacher(imgMap);
    }
}
