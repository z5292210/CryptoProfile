package au.edu.unsw.infs3634.cryptoprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView rvCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCoin = findViewById(R.id.rvCoin);
        CoinAdapter coinAdapter = new CoinAdapter();
        rvCoin.setAdapter(coinAdapter);
    }



}