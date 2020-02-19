package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView trythis;
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String meat = getResources().getString(R.string.Meat_ID);*/
        /*String meaty = getSharedPreferences("Meat_ID",Context.MODE_PRIVATE).getString(getResources().getString(R.string.Meat_ID), null);
        String meatDesc = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Desc_ID), null);
        String veggie = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Veg_ID), null);
        String vegDesc = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.VegDesc_ID), null);
        String starchy = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Starch_ID), null);
        String starchDesc = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.StarchDesc_ID), null);
        trythis = findViewById(R.id.textView3);
        if(meaty != null){
            trythis.setText("Last Meal Mixed: "+meatDesc+" "+meaty+" with "+vegDesc+" "+veggie+" and "+starchDesc+" "+starchy);
        }*/
    }

    /** Called when the user taps the Send button */
    public void sendMessage (View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
}


