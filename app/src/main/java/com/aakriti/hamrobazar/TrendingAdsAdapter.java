package com.aakriti.hamrobazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aakriti.hamrobazar.model.ListedAds;
import com.aakriti.hamrobazar.model.TrendingAds;
import com.aakriti.hamrobazar.url.URL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrendingAdsAdapter extends RecyclerView.Adapter<TrendingAdsAdapter.TrendingAdsViewHolder> {

    ImageView image;
    Context mContext;
    List<TrendingAds> trendingAdsList;

    public TrendingAdsAdapter(Context mContext, List<TrendingAds> trendingAdsList) {
        this.mContext = mContext;
        this.trendingAdsList = trendingAdsList;
    }

    @NonNull
    @Override
    public TrendingAdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending_ads_adapter,parent,false);
        return new TrendingAdsAdapter.TrendingAdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdsViewHolder holder, int position) {

        TrendingAds trendingAds=trendingAdsList.get(position);
        holder.tvtype.setText(trendingAds.getType());
        holder.tvname.setText(trendingAds.getName());
        holder.tvprice.setText(trendingAds.getPrice());


        String image=trendingAds.getImaget();
        String imgPath = URL.imagePath + image;
        Picasso.get().load(imgPath).into(holder.image);
    }

    @Override
    public int getItemCount() {
       return trendingAdsList.size();
    }

    public class TrendingAdsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tvname,tvprice,tvtype;
        public TrendingAdsViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.images);
            tvname=itemView.findViewById(R.id.tvname);
            tvprice=itemView.findViewById(R.id.tvprice);
            tvtype=itemView.findViewById(R.id.tvtype);
        }
    }
}