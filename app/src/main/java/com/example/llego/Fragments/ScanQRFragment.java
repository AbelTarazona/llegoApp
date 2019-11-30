package com.example.llego.Fragments;


import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.llego.R;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanQRFragment extends Fragment{


    public ScanQRFragment() {
        // Required empty public constructor
    }

    ZXingScannerView scannerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scan_qr, container, false);

        scannerView = v.findViewById(R.id.zscan);

        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        //scannerView.setResultHandler();
                        scannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                            @Override
                            public void handleResult(Result rawResult) {
                                Toast.makeText(getContext(),rawResult.getText(),Toast.LENGTH_SHORT).show();
                            }
                        });
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .check();

        return v;
    }

    @Override
    public void onStop() {
        scannerView.stopCamera();
        super.onStop();
    }

/*    @Override
    public void handleResult(Result rawResult) {
        Log.d("TAG",rawResult.getText());
        Toast.makeText(getContext(),rawResult.getText(),Toast.LENGTH_SHORT).show();

    }*/
}
