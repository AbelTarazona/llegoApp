package com.example.llego.Fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.llego.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelDetailFragment extends Fragment {


    public TravelDetailFragment() {
        // Required empty public constructor
    }

    public static TravelDetailFragment newInstance(){return new TravelDetailFragment();}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.d("ACA","error");
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("ACA","error2");
        return inflater.inflate(R.layout.fragment_travel_detail, container, false);
    }

}
