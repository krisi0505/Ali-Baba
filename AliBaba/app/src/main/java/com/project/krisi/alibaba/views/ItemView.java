package com.project.krisi.alibaba.views;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.krisi.alibaba.R;

import java.util.Random;

/**
 * Created by Krisi on 17.10.2017 г..
 */

public class ItemView extends LinearLayout {
    private ImageView mImg;
    public TextView mTVPrice;
    public TextView mTVVolume;
    public int mPrice;
    public int mVolume;

    public ItemView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_view, this);
        this.onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        final int maxPrice = 500;
        final int maxVolume = 16;
        final int maxCoinCost = 100;
        final int maxRubyCost = 200;
        final int maxEmeraldCost = 300;
        final int maxRingCost = 400;

        Random randP = new Random();
        int randomPrice = randP.nextInt(maxPrice) + 1;

        mImg = (ImageView)this.findViewById(R.id.gem);

        if(randomPrice < maxCoinCost){
            mImg.setImageResource(R.drawable.coins);
        }
        else if(randomPrice < maxRubyCost){
            mImg.setImageResource(R.drawable.ruby);
        }
        else if(randomPrice < maxEmeraldCost){
            mImg.setImageResource(R.drawable.emerald);
        }
        else if(randomPrice < maxRingCost){
            mImg.setImageResource(R.drawable.ring);
        }
        else{
            mImg.setImageResource(R.drawable.diamond);
        }

        mTVPrice = (TextView)this.findViewById(R.id.price);
        mTVPrice.setText("" + randomPrice);

        Random randV = new Random();
        int  randomVolume = randV.nextInt(maxVolume) + 1;

        mTVVolume = (TextView)this.findViewById(R.id.volume);
        mTVVolume.setText(randomVolume + "");

        this.setOnTouchListener(new View.OnTouchListener() {
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

        mPrice = randomPrice;
        mVolume = randomVolume;
    }
}
