package com.hfad.pizzashop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends Fragment
{

    public int position=1;

    RecyclerView pastaRecycler;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Pasta_RecyclerView_Data adapter;
    public PastaFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta,container,false);

       /* String[] pastaNames = new String[Pasta.pasta.length];
        for(int i=0;i<pastaNames.length;i++)
        {
            pastaNames[i] = Pasta.pasta[i].getName();
        }
        int[] pastaImages = new int[Pasta.pasta.length];
        for(int i=0;i<pastaImages.length;i++)
        {
            pastaImages[i] = Pasta.pasta[i].getImageResourceID();
        }

        int[] pastaPrice = new int[Pasta.pasta.length];
        for(int i=0;i<pastaPrice.length;i++)
        {
            pastaPrice[i] = Pasta.pasta[i].getPrice();
        }*

        CaptionedImagesAdapter imagesAdapter = new CaptionedImagesAdapter(getActivity(),pastaNames,pastaImages,pastaPrice);
        pastaRecycler.setAdapter(imagesAdapter);*/

       Pasta_RecyclerView_Data.pasta_List.clear();
       //Pasta_RecyclerView_Data.product_List.clear();

       firebaseDatabase = FirebaseDatabase.getInstance();
       databaseReference = firebaseDatabase.getReference("Food_App");

        FirebaseRecyclerOptions<Data_Model> options =
                new FirebaseRecyclerOptions.Builder<Data_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Food_App"), Data_Model.class)
                        .build();

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        pastaRecycler.setLayoutManager(layoutManager);

        adapter = new Pasta_RecyclerView_Data(options,getActivity(),"Food_App");
        pastaRecycler.setAdapter(adapter);

        return pastaRecycler;
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
