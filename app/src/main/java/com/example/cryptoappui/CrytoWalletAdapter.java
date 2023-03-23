package com.example.cryptoappui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.majorik.sparklinelibrary.SparkLineLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CrytoWalletAdapter extends RecyclerView.Adapter<CrytoWalletAdapter.ViewHolder> {
    ArrayList<CryptoWallet> cryptoWallets;

    public CrytoWalletAdapter(ArrayList<CryptoWallet> cryptoWallets) {
        this.cryptoWallets = cryptoWallets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_wallet,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCryptoName.setText(cryptoWallets.get(position).getCryptoName());
        holder.txtCryptoPrice.setText("$" + cryptoWallets.get(position).getCryptoPrice());
        holder.txtPropertySize.setText(cryptoWallets.get(position).getPropertySize() + "" );
        holder.txtPropertyAmount.setText("$" + cryptoWallets.get(position).getPropertyAmount());
        holder.txtChangePercent.setText( cryptoWallets.get(position).getCryptoPercent() + "%");
        holder.txtCryptoSymbol.setText(cryptoWallets.get(position).getCryptoSymbol());
        if (cryptoWallets.get(position).getCryptoPercent() > 0) {
            holder.txtChangePercent.setTextColor(Color.parseColor("#12c737"));
            holder.sparkLineLayout.setSparkLineColor(Color.parseColor("#12c737"));
        } else if (cryptoWallets.get(position).getCryptoPercent() < 0) {
            holder.txtChangePercent.setTextColor(Color.parseColor("#fc0000"));
            holder.sparkLineLayout.setSparkLineColor(Color.parseColor("#fc0000"));
        } else {
            holder.txtChangePercent.setTextColor(Color.parseColor("#ffffff"));
            holder.sparkLineLayout.setSparkLineColor(Color.parseColor("#ffffff"));
        }

        holder.sparkLineLayout.setData(cryptoWallets.get(position).getLineData());
        int url= holder.itemView.getContext().getResources()
                .getIdentifier(cryptoWallets.get(position).getCryptoName(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.imgLogo.getContext()).load(url).into(holder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return cryptoWallets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCryptoName,txtCryptoPrice,txtChangePercent,txtPropertySize,txtPropertyAmount,txtCryptoSymbol;
        ImageView imgLogo;
        SparkLineLayout sparkLineLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCryptoName = itemView.findViewById(R.id.txtCryptoName);
            txtChangePercent = itemView.findViewById(R.id.txtChangePercent);
            txtPropertyAmount = itemView.findViewById(R.id.txtPropertyAmount);
            txtCryptoPrice = itemView.findViewById(R.id.txtCryptonPrice);
            txtPropertySize = itemView.findViewById(R.id.txtPropertySize);
            txtCryptoSymbol = itemView.findViewById(R.id.txtCryptoSymbol);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            sparkLineLayout = itemView.findViewById(R.id.sparkLineLayout);

        }
    }
}
