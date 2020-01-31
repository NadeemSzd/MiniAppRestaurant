package com.hfad.pizzashop;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class branches_recyclerView extends RecyclerView.Adapter<branches_recyclerView.ViewHolder>
{

    private String[] captions;
    private int[] imageIds;

    branches_recyclerView(String[] captions,int[] imageIds)
    {
        this.captions = captions;
        this.imageIds = imageIds;
    }


    @NonNull
    @Override
    public branches_recyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image,parent,false);
        return new branches_recyclerView.ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull branches_recyclerView.ViewHolder holder, int position)
    {
        CardView cardView = holder.cardView;

        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        TextView name_text = cardView.findViewById(R.id.info_text);
        name_text.setText(captions[position]);

    }

    @Override
    public int getItemCount()
    {
        return captions.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        public ViewHolder(@NonNull CardView cardView)
        {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
