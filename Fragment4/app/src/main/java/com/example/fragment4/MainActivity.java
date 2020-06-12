package com.example.fragment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Rfg_rfg_management rfg_rfg_management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rfg_rfg_management = new Rfg_rfg_management();
    }

    public void onRfgFragmentChanged(){
        FragmentTransaction RfgTransaction = getSupportFragmentManager().beginTransaction();
        RfgTransaction.replace(R.id.Main, rfg_rfg_management);
        RfgTransaction.addToBackStack(null);
        RfgTransaction.commit();
    }

}
