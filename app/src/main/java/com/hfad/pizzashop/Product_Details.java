package com.hfad.pizzashop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Product_Details extends AppCompatActivity
{
    int category=0;
    Data_Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        category = intent.getIntExtra("Category",0);

        ImageView imageView = findViewById(R.id.imageViewForDetails);
        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);

        if(category==1)
        {
            model = Pasta_RecyclerView_Data.pizza_List.get(position);
            productName.setText(model.getPasta_name());
            productPrice.setText("Rs "+model.getPasta_price());
            Picasso.get().load(model.getImage()).into(imageView);
        }
        else if(category==2)
        {
            model = Pasta_RecyclerView_Data.pasta_List.get(position);
            productName.setText(model.getPasta_name());
            productPrice.setText("Rs "+model.getPasta_price());
            Picasso.get().load(model.getImage()).into(imageView);
        }
        else if(category==3)
        {
            model = Pasta_RecyclerView_Data.branch_List.get(position);
            productName.setText(model.getPasta_name());
           // productPrice.setText("Rs "+model.getPasta_price());
            Picasso.get().load(model.getImage()).into(imageView);
        }

        /*System.out.println("*****************************************************************");
        System.out.println("******************* CATEGORY : "+category+" *************************");
        System.out.println("*****************************************************************");

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),imageIds);
        imageView.setImageDrawable(drawable);

        Data_Model model = Pasta_RecyclerView_Data.data_modelList.get(position);

        productName.setText(model.getPasta_name());
        String price = String.valueOf(model.getPasta_price());
        productPrice.setText("Rs : "+price);*/
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent()
    {
        final Intent intent = new Intent(this,MainActivity.class);
        if(category==1)
        {
            intent.putExtra("TabNumber", 1);
        }
        else if(category==2)
        {
            intent.putExtra("TabNumber", 2);
        }
        else if(category==3)
        {
            intent.putExtra("TabNumber", 3);
        }
        return intent;

        // running perfectly
        /*final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("TabNumber",1);

        return intent;*/
    }

    public void goToOrderActivity(View view)
    {
       // Intent intent = new Intent(this,OrderActivity.class);
       // startActivity(intent);
    }

}
