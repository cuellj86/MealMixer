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

public class Starch extends AppCompatActivity {

    ArrayList<String> starches = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    Random rand = new Random();
    String[] pasta = {"Linguini", "Macaroni", "Spaghetti", "Angel Hair"};
    String[] bread = {"Garlic Bread", "Italian Bread", "Croissant", "Biscuit"};
    String[] pastaDesc = {"Cheesy", "Tomato Sauce", "Parmesean"};
    String[] breadDesc = {"Toasted"};

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starch);
    }

    public void onCheckboxClicked (View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.checkBox7:
                if(checked){
                    for(int i = 0; i < pasta.length; i++){
                        starches.add(pasta[i]);
                    }
                }
                else{
                    for(int i = 0; i < pasta.length; i++){
                        starches.remove(pasta[i]);
                    }
                }
                break;

            case R.id.checkBox8:
                if(checked){
                    for(int i = 0; i < bread.length; i++){
                        starches.add(bread[i]);
                    }
                }
                else{
                    for(int i = 0; i < bread.length; i++){
                        starches.remove(bread[i]);
                    }
                }
                break;
        }
    }

    public void sendBack(View view){
        if (starches.size() == 0){
            Toast.makeText(getApplicationContext(), "No selection has been made", Toast.LENGTH_SHORT).show();
        }
        else {
            String finalVeg = starches.get(rand.nextInt(starches.size()));
            if (useList(pasta, finalVeg)){
                for(int i = 0; i < pastaDesc.length; i++){
                    description.add(pastaDesc[i]);
                }
            }
            else {
                for(int i = 0; i < breadDesc.length; i++){
                    description.add(breadDesc[i]);
                }
            }

            String finalDesc = description.get(rand.nextInt(description.size()));

            //Create and save shared preferences
            SharedPreferences sharedPref = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            SharedPreferences descPref = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor descEditor = descPref.edit();
            editor.putString(getResources().getString(R.string.Starch_ID), finalVeg);
            descEditor.putString(getResources().getString(R.string.StarchDesc_ID), finalDesc);
            editor.commit();
            descEditor.commit();
            Intent intent = new Intent(this, DisplayMessageActivity.class);

            //Send and toast confirmation
            startActivity(intent);
            String Tester = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Starch_ID), finalVeg);
            String descTester = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.StarchDesc_ID), finalDesc);
            if ((Tester.equals(finalVeg)) && (descTester.equals(finalDesc))) {
                Toast.makeText(getApplicationContext(), "Starch Saved!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static boolean useList(String[] arr, String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }
}
