package com.aakriti.hamrobazar.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.aakriti.hamrobazar.ListedAdsAdapter;
import com.aakriti.hamrobazar.MainActivity;
import com.aakriti.hamrobazar.R;
import com.aakriti.hamrobazar.TrendingAdsAdapter;
import com.aakriti.hamrobazar.api.UsersAPI;
import com.aakriti.hamrobazar.model.ListedAds;
import com.aakriti.hamrobazar.model.TrendingAds;
import com.aakriti.hamrobazar.url.URL;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView, recyclerViews;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView= root.findViewById(R.id.recyclerView);
        //instance for interface
        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<List<ListedAds>> listCall=usersAPI.getListedAds();

        //asynchronous
        listCall.enqueue(new Callback<List<ListedAds>>() {
            @Override
            public void onResponse(Call<List<ListedAds>> call, Response<List<ListedAds>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Error code"+response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("msg","onFailure"+ response.code());

                    return;
                }

                List<ListedAds> listedAdsList = response.body();

                ListedAdsAdapter listedAdsAdapter = new ListedAdsAdapter(getContext(),listedAdsList);
                recyclerView.setAdapter(listedAdsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));



            }


            @Override
            public void onFailure(Call<List<ListedAds>> call, Throwable t) {
                Log.d("msg","onFailure"+t.getLocalizedMessage());
                Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });

        recyclerViews=root.findViewById(R.id.recyclerViews);
        Call<List<TrendingAds>> listCall1=usersAPI.getTrentedAds();

        listCall1.enqueue(new Callback<List<TrendingAds>>() {
            @Override
            public void onResponse(Call<List<TrendingAds>> call, Response<List<TrendingAds>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Error code" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("msg", "onFailure" + response.code());

                    return;
                }

                List<TrendingAds> trendingAdsList = response.body();

                TrendingAdsAdapter trendingAdsAdapter = new TrendingAdsAdapter(getContext(), trendingAdsList);
                recyclerViews.setAdapter(trendingAdsAdapter);
                recyclerViews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


            }
            @Override
            public void onFailure(Call<List<TrendingAds>> call, Throwable t) {
                Log.d("msg","onFailure"+t.getLocalizedMessage());
                Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return root;
    }

    }


