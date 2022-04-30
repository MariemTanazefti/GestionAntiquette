package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class GridItemActivity extends AppCompatActivity {
    TextView gridName,gridDescription,gridPrice,btnCart;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
        btnCart=findViewById(R.id.ADDdetail);
        gridName = findViewById(R.id.grid_name);
        imageView = findViewById(R.id.imageView);
        //gridDescription=findViewById(R.id.grid_description);
        gridPrice=findViewById(R.id.grid_price);
        btnCart=findViewById(R.id.ADDdetail);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String image =getIntent().getStringExtra("imageProduct");
                String price =getIntent().getStringExtra("priceProduct");
                String name=getIntent().getStringExtra("nameProduct");
                ApiHandler apiHandler= ApiClient.getApiClient().create(ApiHandler.class);
                Call<Produit> insertProduct=apiHandler.insertProduct(name,price,image);
                insertProduct.enqueue(new Callback<Produit>() {
                    @Override
                    public void onResponse(Response<Produit> response, Retrofit retrofit) {
                        Toast.makeText(getApplicationContext(),"product added",Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();


                    }
                });



            }
        });
        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image", 0);
        //String receivedDescription = intent.getStringExtra("description");
        String receivedPrice = intent.getStringExtra("price");

        gridName.setText(receivedName);
        imageView.setImageResource(receivedImage);
        //gridDescription.setText(receivedDescription);
        gridPrice.setText(receivedPrice);
        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}