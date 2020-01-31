package com.hfad.pizzashop;

public class Stores
{
    private String name;
    private int ImageResourceID;

    public static final Stores[] storess = {
            new Stores("Kasur Pizza shop",R.drawable.branch_kasur),
            new Stores("Lahore Pizza shop",R.drawable.branch_lahore),
            new Stores("Karachi Pizza shop",R.drawable.branch_karachi),

    };


    public Stores(String name, int ImageResourceId)
    {
        this.name = name;
        this.ImageResourceID = ImageResourceId;
    }

    public int getImageResourceID()
    {
        return ImageResourceID;
    }
    public String getName()
    {
        return name;
    }
}
