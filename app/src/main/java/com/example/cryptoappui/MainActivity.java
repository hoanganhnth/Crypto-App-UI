package com.example.cryptoappui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewWallet();
    }

    private void recyclerViewWallet() {
        LinearLayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView = findViewById(R.id.rvCrypto);

        ArrayList<CryptoWallet> cryptoWallets = new ArrayList<>();
        ArrayList<Integer> lineData = new ArrayList<>();
        lineData.add(1000);
        lineData.add(1100);
        lineData.add(1200);
        lineData.add(1300);
        ArrayList<Integer> lineData1 = new ArrayList<>();
        lineData1.add(2100);
        lineData1.add(2000);
        lineData1.add(1900);
        lineData1.add(2000);
        ArrayList<Integer> lineData2 = new ArrayList<>();
        lineData2.add(900);
        lineData2.add(1000);
        lineData2.add(1200);
        lineData2.add(1000);

        cryptoWallets.add(new CryptoWallet("bitcoin","BTX",1234.12,2.13,lineData,1234.12,0.12343));
        cryptoWallets.add(new CryptoWallet("ethereum","ETH",2134.21,-1.13,lineData1,6545.65,0.01245));

        cryptoWallets.add(new CryptoWallet("trox","ROX",6543.21,0.73,lineData2,3123.4,0.23143));
        recyclerView.setLayoutManager(layout);
        adapter = new CrytoWalletAdapter(cryptoWallets);
        recyclerView.setAdapter(adapter);
    }
}