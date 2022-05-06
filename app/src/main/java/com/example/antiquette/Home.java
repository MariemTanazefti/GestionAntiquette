package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView btnStore ,btnVente,btnCamera,btnDeconnexion;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnStore=(TextView) findViewById(R.id.btn_store);
        btnVente=(TextView) findViewById(R.id.btn_article);
        btnCamera=(TextView)findViewById(R.id.btn_camera);
        btnDeconnexion=(TextView)findViewById(R.id.btn_deconnexion);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tv.setText(bundle.getString("user"));}

        btnVente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this, UserActivity.class);
                //intent.putExtras(mBundle);
                startActivity(intent);
                Toast.makeText(Home.this, "Bienvenue " , Toast.LENGTH_SHORT).show();
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,StoreMap.class);
                //intent.putExtras(mBundle);
                startActivity(intent);
                Toast.makeText(Home.this, "Bienvenue " , Toast.LENGTH_SHORT).show();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Login.class);
                startActivity(intent);
            }
        });

    }
}