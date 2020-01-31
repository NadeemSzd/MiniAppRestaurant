package com.hfad.pizzashop;

public class Pasta
{
    // Old Implementation
    /*private String name;
    private int ImageResourceID;
    private int price;

    public static final Pasta[] pasta = {
            new Pasta("Kasuri Pasta",R.drawable.pasta_kasuri,350),
            new Pasta("Lahori Pasta",R.drawable.pasta_lahori,250),
            new Pasta("Karachi Pasta",R.drawable.pasta_karachi,400),
            new Pasta("King Pasta",R.drawable.pasta_king,220),
            new Pasta("Legend Pasta",R.drawable.pasta_legend,250),
    };


    public Pasta(String name, int ImageResourceId,int price)
    {
        this.name = name;
        this.ImageResourceID = ImageResourceId;
        this.price = price;
    }

    public int getImageResourceID()
    {
        return ImageResourceID;
    }
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }*/


    // New Implementation

    String image,pasta_name,pasta_price;

    public String getImage()
    {
        return image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getPasta_name()
    {
        return pasta_name;
    }

    public void setPasta_name(String pasta_name)
    {
        this.pasta_name = pasta_name;
    }

    public String getPasta_price()
    {
        return pasta_price;
    }

    public void setPasta_price(String pasta_price)
    {
        this.pasta_price = pasta_price;
    }
}
