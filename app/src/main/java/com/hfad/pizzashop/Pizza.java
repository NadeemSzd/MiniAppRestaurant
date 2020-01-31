package com.hfad.pizzashop;

public class Pizza
{
    private String name;
    private int ImageResourceID;
    private int price;

    public static final Pizza[] pizzas = {
            new Pizza("Kasuri Pizza",R.drawable.kasuri_pizza,300),
            new Pizza("Lahori Pizza",R.drawable.lahori_pizza,350),
            new Pizza("Karachi Pizza",R.drawable.quetta_pizza,220),
            new Pizza("Multani Pizza",R.drawable.peshawari_pizza,300),
            new Pizza("Legend Pizza",R.drawable.legend_pizza,550),
            new Pizza("King Pizza",R.drawable.quetta,600),
            new Pizza("Queen Pizza",R.drawable.faisalabad,500),
            new Pizza("FiveStar Pizza",R.drawable.irani,550),
    };


    public Pizza(String name, int ImageResourceId,int price)
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
    }

}
