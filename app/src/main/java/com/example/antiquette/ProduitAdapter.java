package com.example.antiquette;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ProductViewHolder> {

    Context context;
    public List<Produit> listProduct;
    public  List<Produit> listAllProduct;

    public ProduitAdapter(Context context, List<Produit> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
        listAllProduct=new ArrayList<>(listProduct);
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data,parent,false);
        ProductViewHolder productViewHolder= new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {
        final Produit product =listProduct.get(position);
        holder.idProduct.setText(String.valueOf(product.getId()));
        holder.nameProduct.setText(product.getNom());
        holder.priceProduct.setText(product.getPrix());
        //   holder.descriptionProduct.setText(product.getDescriptionProduct());
        Picasso.get().load(listProduct.get(position).getImage()).into(holder.imageProduct);
        holder.imageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, DetailsActivity.class);
                int idProduct=product.getId();
                String id=String.valueOf(idProduct);

                String nameProduct=product.getNom();
                String priceProduct=product.getPrix();
                String imageProduct=product.getImage();
                //String descriptionProduct=product.getDescription();
                intent.putExtra("idProduct",id);
                intent.putExtra("nameProduct",nameProduct);
                intent.putExtra("priceProduct",priceProduct);
                intent.putExtra("imageProduct",imageProduct);
                //intent.putExtra("descriptionProduct",descriptionProduct);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });



    }



    @Override
    public int getItemCount() {
        return listProduct.size();

    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageProduct;
        TextView idProduct, nameProduct,priceProduct,descriptionProduct;
        private int i=0;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            //idProduct=itemView.findViewById(R.id.idProduct);
            imageProduct = itemView.findViewById(R.id.images);
            nameProduct = itemView.findViewById(R.id.name_product);
            priceProduct = itemView.findViewById(R.id.prix_product);
            //descriptionProduct=itemView.findViewById(R.id.descriptionProduct);


        }
    }
}
