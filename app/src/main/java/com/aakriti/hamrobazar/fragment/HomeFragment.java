package com.aakriti.hamrobazar.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.aakriti.hamrobazar.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText etradius;
    private Button btncalculate;
    private TextView tvresult;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

      /*  etradius=root.findViewById(R.id.etradius);
        btncalculate=root.findViewById(R.id.btnarea);
        tvresult=root.findViewById(R.id.tvresult);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //  etradius.setText(s);



                btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float r;
                        r=Float.parseFloat(etradius.getText().toString());
                        float area=(22/7)*r*r;
                        tvresult.setText("Area of circle is:"+area);

                    }
                });


            }
        });*/
        return root;




    }

    }


