package com.aakriti.hamrobazar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aakriti.hamrobazar.api.UsersAPI;
import com.aakriti.hamrobazar.model.ListedAds;
import com.aakriti.hamrobazar.model.TrendingAds;
import com.aakriti.hamrobazar.model.Users;
import com.aakriti.hamrobazar.url.URL;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "";
    private AppBarConfiguration mAppBarConfiguration;
    //ImageView img;
    SliderView sliderView;
    // Dialog myDialog;
    // Button signup;
    ImageView miProfile;
    ImageView imgProgileImg;
   // private RecyclerView recyclerView, recyclerViews;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //forpopup login
        // myDialog = new Dialog(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //////
        miProfile = findViewById(R.id.miProfile);
        imgProgileImg = findViewById(R.id.imgProgileImg);

        loadCurrentUser();

     /*   recyclerView=findViewById(R.id.recyclerView);


        //instance for interface
        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<List<ListedAds>> listCall=usersAPI.getListedAds();



        //asynchronous
        listCall.enqueue(new Callback<List<ListedAds>>() {
            @Override
            public void onResponse(Call<List<ListedAds>> call, Response<List<ListedAds>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Error code"+response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("msg","onFailure"+ response.code());

                    return;
                }

                List<ListedAds> listedAdsList = response.body();

                ListedAdsAdapter listedAdsAdapter = new ListedAdsAdapter(MainActivity.this,listedAdsList);
                recyclerView.setAdapter(listedAdsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));



            }


            @Override
            public void onFailure(Call<List<ListedAds>> call, Throwable t) {
                Log.d("msg","onFailure"+t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });*/


       /* recyclerViews=findViewById(R.id.recyclerViews);
        Call<List<TrendingAds>> listCall1=usersAPI.getTrentedAds();

        listCall1.enqueue(new Callback<List<TrendingAds>>() {
         @Override
           public void onResponse(Call<List<TrendingAds>> call, Response<List<TrendingAds>> response) {
             if (!response.isSuccessful()) {
              Toast.makeText(MainActivity.this, "Error code" + response.code(), Toast.LENGTH_SHORT).show();
                Log.d("msg", "onFailure" + response.code());

                   return;
                   }

               List<TrendingAds> trendingAdsList = response.body();

                 TrendingAdsAdapter trendingAdsAdapter = new TrendingAdsAdapter(MainActivity.this, trendingAdsList);
                 recyclerViews.setAdapter(trendingAdsAdapter);
                 recyclerViews.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));


                   }
                   @Override
                   public void onFailure(Call<List<TrendingAds>> call, Throwable t) {

                     }
        });*/


        miProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });



        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_orders,
                R.id.nav_cat, R.id.nav_rate, R.id.miProfile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       NavigationUI.setupWithNavController(navigationView, navController);

        sliderView = findViewById(R.id.imageSlider);

        final SliderAdapter adapter = new SliderAdapter(this);
        adapter.setCount(5);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.COLOR); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);

    }


    private void openDialog() {
        LoginDialogActivity loginDialogActivity = new LoginDialogActivity();
        loginDialogActivity.show(getSupportFragmentManager(), "login dialog");
    }

   /* public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_login);
           *//* txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
            txtclose.setText("M");
            btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
            txtclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });*//*
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }




    private void loadCurrentUser() {

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<Users> userCall = usersAPI.getUserDetails(URL.token);

        userCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String imgPath = URL.imagePath + response.body().getImage();

                Picasso.get().load(imgPath).into(imgProgileImg);


//                StrictModeClass.StrictMode();
//                try {
//                    URL url = new URL(imgPath);
//                    imgProgileImg.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

