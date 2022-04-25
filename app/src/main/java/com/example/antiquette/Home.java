package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView store ,vente;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        store=(TextView) findViewById(R.id.b);
        vente=(TextView) findViewById(R.id.b1);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tv.setText(bundle.getString("user"));}

        vente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this, UserActivity.class);
                //intent.putExtras(mBundle);
                startActivity(intent);
                Toast.makeText(Home.this, "Bienvenue " , Toast.LENGTH_SHORT).show();
            }
        });

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,StoreMap.class);
                //intent.putExtras(mBundle);
                startActivity(intent);
                Toast.makeText(Home.this, "Bienvenue " , Toast.LENGTH_SHORT).show();
            }
        });

    }
}