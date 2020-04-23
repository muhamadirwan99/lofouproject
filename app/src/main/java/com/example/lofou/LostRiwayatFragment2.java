package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LostRiwayatFragment2 extends Fragment {

    public LostRiwayatFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.lost_riwayat_fragment_2, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), ImageRiwayatRewardFragment.class);
                in.putExtra("Some","Some data");
                startActivity(in);
            }
        });

        ImageView imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), ImageRiwayatFragment.class);
                in.putExtra("Some","Some date");
                startActivity(in);
            }
        });

        return view;
    }
}
