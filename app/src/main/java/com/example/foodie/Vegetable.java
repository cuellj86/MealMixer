package com.example.foodie;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vegetable extends AppCompatActivity {

    ArrayList<String> veggie = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    Random rand = new Random();
    String[] roots = {"Potatoes", "Yams", "Rutabegas", "Carrots"};
    String[] vine = {"Corn", "Green Beans", "Squash"};
    String[] rootsDesc = {"Mashed", "Grilled", "Roasted", "Oven Baked"};
    String[] vineDesc = {"Grilled", "Sauteed", "Pureed"};


    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
    }

    public void onCheckboxClicked (View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.checkBox5:
                if(checked){
                    for(int i = 0; i < roots.length; i++){
                        veggie.add(roots[i]);
                    }
                }
                else{
                    for(int i = 0; i < roots.length; i++){
                        veggie.remove(roots[i]);
                    }
                }
                break;

            case R.id.checkBox6:
                if(checked){
                    for(int i = 0; i < vine.length; i++){
                        veggie.add(vine[i]);
                    }
                }
                else{
                    for(int i = 0; i < vine.length; i++){
                        veggie.remove(vine[i]);
                    }
                }
                break;
        }
    }

    public void sendBack(View view){
        if (veggie.size() == 0){
            Toast.makeText(getApplicationContext(), "No selection has been made", Toast.LENGTH_SHORT).show();
        }
        else {
            String finalVeg = veggie.get(rand.nextInt(veggie.size()));
            if (useList(roots, finalVeg)){
                for(int i = 0; i < rootsDesc.length; i++){
                    description.add(rootsDesc[i]);
                }
            }
            else {
                for(int i = 0; i < vineDesc.length; i++){
                    description.add(vineDesc[i]);
                }
            }

            String finalDesc = description.get(rand.nextInt(description.size()));

            //Create and save shared preferences
            SharedPreferences sharedPref = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            SharedPreferences descPref = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor descEditor = descPref.edit();
            editor.putString(getResources().getString(R.string.Veg_ID), finalVeg);
            descEditor.putString(getResources().getString(R.string.VegDesc_ID), finalDesc);
            editor.commit();
            descEditor.commit();
            Intent intent = new Intent(this, DisplayMessageActivity.class);

            //Send and toast confirmation
            startActivity(intent);
            String Tester = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Veg_ID), finalVeg);
            String descTester = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.VegDesc_ID), finalDesc);
            if ((Tester.equals(finalVeg)) && (descTester.equals(finalDesc))) {
                Toast.makeText(getApplicationContext(), "Veg Saved!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean useList(String[] arr, String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }

}
