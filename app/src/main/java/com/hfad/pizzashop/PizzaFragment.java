package com.hfad.pizzashop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PizzaFragment extends Fragment
{
    public int position=1;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Pasta_RecyclerView_Data adapter;

    public PizzaFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza,container,false);

        /*String[] pizzaNames = new String[Pizza.pizzas.length];
        for(int i=0;i<pizzaNames.length;i++)
        {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaPrice = new int[Pizza.pizzas.length];
        for(int i=0;i<pizzaPrice.length;i++)
        {
            pizzaPrice[i] = Pizza.pizzas[i].getPrice();
        }

        int[] pizzasImages = new int[Pizza.pizzas.length];
        for(int i=0;i<pizzasImages.length;i++)
        {
            pizzasImages[i] = Pizza.pizzas[i].getImageResourceID();
        }

        CaptionedImagesAdapter imagesAdapter = new CaptionedImagesAdapter(getActivity(),pizzaNames,pizzasImages,pizzaPrice);
        pizzaRecycler.setAdapter(imagesAdapter);*/

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(layoutManager);

        Pasta_RecyclerView_Data.pizza_List.clear();
        //Pasta_RecyclerView_Data.product_List.clear();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Food_App_Pizza");

        FirebaseRecyclerOptions<Data_Model> options =
                new FirebaseRecyclerOptions.Builder<Data_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Food_App_Pizza"), Data_Model.class)
                        .build();
        adapter = new Pasta_RecyclerView_Data(options,getActivity(),"Food_App_Pizza");
        pizzaRecycler.setAdapter(adapter);

        return pizzaRecycler;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        adapter.stopListening();
    }
}
