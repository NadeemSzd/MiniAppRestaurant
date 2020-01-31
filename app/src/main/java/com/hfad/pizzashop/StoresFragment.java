package com.hfad.pizzashop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
public class StoresFragment extends Fragment
{

    public int position=1;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Pasta_RecyclerView_Data adapter;

    public StoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView branchRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta,container,false);

        /*String[] branchNames = new String[Stores.storess.length];
        for(int i=0;i<branchNames.length;i++)
        {
            branchNames[i] = Stores.storess[i].getName();
        }
        int[] branchImages = new int[Stores.storess.length];
        for(int i=0;i<branchImages.length;i++)
        {
            branchImages[i] = Stores.storess[i].getImageResourceID();
        }
        branches_recyclerView imagesAdapter = new branches_recyclerView(branchNames,branchImages);
        branchRecycler.setAdapter(imagesAdapter);*/

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        branchRecycler.setLayoutManager(layoutManager);

        Pasta_RecyclerView_Data.branch_List.clear();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Food_App_Branches");

        FirebaseRecyclerOptions<Data_Model> options =
                new FirebaseRecyclerOptions.Builder<Data_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Food_App_Branches"), Data_Model.class)
                        .build();
        adapter = new Pasta_RecyclerView_Data(options,getActivity(),"Food_App_Branches");
        branchRecycler.setAdapter(adapter);


        return branchRecycler;
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
