package com.hfad.pizzashop;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Pasta_RecyclerView_Data extends FirebaseRecyclerAdapter<Data_Model,Pasta_RecyclerView_Data.ViewHolder>
{
    static List<Data_Model> pizza_List = new ArrayList<>();
    static List<Data_Model> pasta_List = new ArrayList<>();
    static List<Data_Model> branch_List = new ArrayList<>();

    List<Data_Model> product_List = new ArrayList<>();

    Context parent_context ;

    String sourceName;

    public Pasta_RecyclerView_Data(@NonNull FirebaseRecyclerOptions<Data_Model> options, Context context,String source_Name)
    {
        super(options);
        parent_context = context;
        sourceName = source_Name;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Data_Model model)
    {

        if(sourceName.equals("Food_App"))
        {
            pasta_List.add(model);
            product_List = pasta_List;
        }
        else if(sourceName.equals("Food_App_Pizza"))
        {
            pizza_List.add(model);
            product_List = pizza_List;
        }
        else if(sourceName.equals("Food_App_Branches"))
        {
            branch_List.add(model);
            product_List = branch_List;
        }

        holder.setListeners();
        holder.Position = position;
        holder.product_Name.setText(model.getPasta_name());
        holder.product_Price.setText("Rs "+model.getPasta_price());
        Picasso.get().load(model.getImage()).into(holder.product_ImageView);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        CardView view = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image,parent,false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        CardView cardView;
        ImageView product_ImageView;
        TextView product_Name,product_Price;
        int Position;

        public ViewHolder(@NonNull CardView cardView)
        {
            super(cardView);
            this.cardView = cardView;
            product_ImageView = cardView.findViewById(R.id.info_image);
            product_Name = cardView.findViewById(R.id.info_text);
            product_Price = cardView.findViewById(R.id.price_info_text);
        }

        public void setListeners()
        {
            this.cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
           /* Data_Model model = product_List.get(Position);
            System.out.println("********************************************************************");
            System.out.println("********************************************************************");
            System.out.println("Product Name : "+model.getPasta_name());
            System.out.println("Product Price : "+model.getPasta_price());
            System.out.println("Size of Pizza List : "+pizza_List.size());
            System.out.println("********************************************************************");
            System.out.println("********************************************************************");*/

            Intent intent = new Intent(parent_context,Product_Details.class);
            intent.putExtra("Position",Position);
            intent.putExtra("Category",MainActivity.pager.getCurrentItem());
            cardView.getContext().startActivity(intent);
        }
    }
}
