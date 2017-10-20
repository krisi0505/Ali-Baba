package com.project.krisi.alibaba.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.krisi.alibaba.R;
import com.project.krisi.alibaba.views.ItemView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BagFragment extends Fragment {


    public BagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bag, container, false);

        final TextView capacity = (TextView)getActivity().findViewById(R.id.capacity_number);
        final TextView total = (TextView)getActivity().findViewById(R.id.total_number);

        ImageView imgBag = (ImageView)root.findViewById(R.id.img_bag);
        imgBag.setOnDragListener(new View.OnDragListener() {
            private int capacityLeft = 20;
            private int money = 0;

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int dragEvent = event.getAction();

                if(dragEvent == DragEvent.ACTION_DROP) {
                    final ItemView view = (ItemView) event.getLocalState();

                    String price = view.mTVPrice.getText().toString();
                    int priceNumber = Integer.parseInt(price);

                    final TextView tvVolume = (TextView) view.mTVVolume;
                    String volume = tvVolume.getText().toString();
                    int volumeNumber = Integer.parseInt(volume);

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

        // Inflate the layout for this fragment
        return root;
    }

}
