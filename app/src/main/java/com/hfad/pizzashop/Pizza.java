package com.hfad.pizzashop;

public class Pizza
{
    private String name;
    private int ImageResourceID;

    public static final Pizza[] pizzas = {
      new Pizza("Kasuri Pizza",R.drawable.kasuri_pizza),
      new Pizza("Lahori Pizza",R.drawable.lahori_pizza)
    };


    public Pizza(String name, int ImageResourceId)
    {
        this.name = name;
        this.ImageResourceID = ImageResourceId;
    }

    public int getImageResourceID()
    {
        return ImageResourceID;
    }
    public String getName() { return name; }
}
