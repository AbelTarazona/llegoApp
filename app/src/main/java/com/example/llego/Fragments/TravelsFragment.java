package com.example.llego.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.llego.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelsFragment extends Fragment {


    public TravelsFragment() {
        // Required empty public constructor
    }

    FloatingActionButton fbAdd;
    LinearLayout lyPopupViajes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_travels, container, false);
        fbAdd = v.findViewById(R.id.fbAddViaje);
        lyPopupViajes = v.findViewById(R.id.viajesPopup);

        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScreen(new ScanQRFragment());
            }
        });

        return v;
    }

    public void changeScreen(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment);
        fragmentTransaction.commit();
    }


}
