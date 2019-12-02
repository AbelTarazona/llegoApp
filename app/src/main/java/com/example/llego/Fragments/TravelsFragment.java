package com.example.llego.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.llego.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelsFragment extends Fragment {


    public TravelsFragment() {
        // Required empty public constructor
    }

    public static TravelsFragment newInstance() {
        return new TravelsFragment();
    }

    FloatingActionButton fbAdd;
    Bundle bundle;
    ProgressBar pbLoader;
    CardView cvIquitos;
    Boolean isTravelLoaded = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_travels, container, false);
        fbAdd = v.findViewById(R.id.fbAddViaje);
        pbLoader = v.findViewById(R.id.pbLoader);

        bundle = this.getArguments();



        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTravelLoaded = false;
                changeScreen(new ScanQRFragment());
            }
        });



        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cvIquitos = view.findViewById(R.id.cvIquitos);
        cvIquitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),view,"imageShare");

                TravelDetailFragment travelDetailFragment = TravelDetailFragment.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(cvIquitos, ViewCompat.getTransitionName(cvIquitos))
                        .addToBackStack(TravelsFragment.class.getSimpleName())
                        .replace(R.id.fl_main, travelDetailFragment)
                        .commit();


            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (bundle != null) {

            if (isTravelLoaded) {
                pbLoader.setVisibility(View.GONE);
                cvIquitos.setVisibility(View.VISIBLE);
                return;
            }

            pbLoader.setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    //startActivity(i);
                    pbLoader.setVisibility(View.GONE);
                    cvIquitos.setVisibility(View.VISIBLE);
                }
            }, 2000);
            isTravelLoaded = true;
        }
    }

    public void changeScreen(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment);
        fragmentTransaction.commit();
    }


}
