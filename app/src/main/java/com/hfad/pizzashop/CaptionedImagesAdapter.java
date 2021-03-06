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

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>
{

    private String[] captions;
    private int[] imageIds;
    private int[] prices;
    static Context parentContext;

    CaptionedImagesAdapter(Context context,String[] captions, int[] imageIds, int[] Prices)
    {
        this.parentContext = context;
        this.captions = captions;
        this.imageIds = imageIds;
        this.prices = Prices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        CardView cardView = holder.cardView;
        holder.setListeners();
        holder.position = position;

        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        TextView name_text = cardView.findViewById(R.id.info_text);
        name_text.setText(captions[position]);

        TextView price_text = cardView.findViewById(R.id.price_info_text);
        String price = String.valueOf(prices[position]);
        price_text.setText("Rs "+price);
    }

    @Override
    public int getItemCount()
    {
        return captions.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private CardView cardView;
        public int position;
        public ViewHolder(@NonNull CardView cardView)
        {
            super(cardView);
            this.cardView = cardView;
        }

        public void setListeners()
        {
            this.cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(parentContext,Product_Details.class);
            intent.putExtra("Position",position);
            intent.putExtra("Category",MainActivity.pager.getCurrentItem());
            cardView.getContext().startActivity(intent);
        }

    }

}
