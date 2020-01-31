package com.hfad.pizzashop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Scanner;

public class OrderActivity extends AppCompatActivity
{
    EditText username,product;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username = findViewById(R.id.username);
        product = findViewById(R.id.product);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void SaveOrder(View view)
    {

        String user = username.getText().toString();
        String products = product.getText().toString();



        if(!(user.isEmpty() && products.isEmpty()))
        {
            String msg = "Your Order has been sent";
            int duration = Snackbar.LENGTH_LONG;

            Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator),msg,duration);
            snackbar.setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OrderActivity.this,"Undo Successfully",Toast.LENGTH_LONG).show();
                }
            });

            snackbar.show();
        }
        else
        {
            Toast.makeText(this,"Please Enter Username and Product!",Toast.LENGTH_LONG).show();
        }
    }
}
