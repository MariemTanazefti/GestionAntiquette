package com.example.antiquette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.botton_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(naviglistener);
    }


    public BottomNavigationView.OnNavigationItemSelectedListener naviglistener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment unFrgment=null;
            switch (item.getItemId()){
                case R.id.item_store:
                    unFrgment=new StoreFragment();
                    break;
                case R.id.item_camera:
                    unFrgment=new CameraFragment();
                    break;
                case R.id.item_location:
                    unFrgment=new LocationFragment();


            }
            String URL="http://192.168.8.103:80/";
            Bundle bundle=new Bundle();
            bundle.putString("url",URL);
            unFrgment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,unFrgment).commit();
            return true;


        }
    };
}