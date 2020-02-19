package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }

    public void sendMeat (View view){
        Intent intent = new Intent( this, Meat.class );
        startActivity(intent);
    }

    public void sendVegetable (View view){
        Intent intent = new Intent( this, Vegetable.class );
        startActivity(intent);
    }

    public void sendStarch (View view){
        Intent intent = new Intent( this, Starch.class );
        startActivity(intent);
    }

    public  void mixMeal (View view){
        /*String meaty = getSharedPreferences("Meat_ID",Context.MODE_PRIVATE).getString(getResources().getString(R.string.Meat_ID), null);
        String meatDesc = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Desc_ID), null);*/

        //NOT WHERE IT SHOULD BE SENDING
        Intent intent = new Intent(this, Endscreen.class);
        startActivity(intent);
        //STILL NEED TO CREATE NEW ACTIVITY!!
    }
}
