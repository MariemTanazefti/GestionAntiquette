package com.example.antiquette;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoreFragment extends Fragment {
    GridView gridView;
    String[] MeublesNames = {"Téléphone vintage", "Machine à écrire vintage", "Buffet vintage", "Chaise vintage","Table de nuit","Armoire vintage","Coiffeuse antique","Argentiaire","Radio antique"};
    int[] MeublesImages = {R.drawable.tel, R.drawable.machine, R.drawable.meub, R.drawable.chaise, R.drawable.table, R.drawable.tab1, R.drawable.coiff, R.drawable.argentiaire, R.drawable.radio};
    //String[] MeublesPrices = {"388","250","600","900","550","1250","938","222","2000"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_store, container, false);
        gridView = v.findViewById(R.id.grid);

      CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                //Toast.makeText(getApplicationContext(), MeublesNames[i], Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(),MeublesNames[i],Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("name", MeublesNames[i]);
                intent.putExtra("image", MeublesImages[i]);
                //intent.putExtra("price",MeublesPrices[i]);
                startActivity(intent);

            }
        });
        return v;


    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return MeublesImages.length;
        }

        @Override
        public Object getItem(int position) {
            // return MeublesPrices.length;
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView name = view1.findViewById(R.id.name_product);
            ImageView image = view1.findViewById(R.id.images);

            //TextView price = view1.findViewById(R.id.prix_product);

            name.setText(MeublesNames[i]);
            image.setImageResource(MeublesImages[i]);
            //price.setText(MeublesPrices[i]);
            //price.setText(MeublesPrices[i]);


            return view1;
        }}


    }
