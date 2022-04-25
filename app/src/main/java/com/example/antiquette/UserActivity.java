package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    GridView gridView;
    String[] MeublesNames = {"Téléphone vintage", "Machine à écrire vintage", "Buffet vintage", "Chaise vintage","Table de nuit","Armoire vintage","Coiffeuse antique","Argentiaire","Radio antique"};
    int[] MeublesImages = {R.drawable.tel, R.drawable.machine, R.drawable.meub, R.drawable.chaise, R.drawable.table, R.drawable.tab1, R.drawable.coiff, R.drawable.argentiaire, R.drawable.radio};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        gridView = findViewById(R.id.grid);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Toast.makeText(getApplicationContext(), MeublesNames[i], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                intent.putExtra("name", MeublesNames[i]);
                intent.putExtra("image", MeublesImages[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return MeublesImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1=getLayoutInflater().inflate(R.layout.row_data,null);
            TextView name = view1.findViewById(R.id.name_product);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(MeublesNames[i]);
            image.setImageResource(MeublesImages[i]);
            return view1;

        }
    }
}