package com.example.foodie;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Meat extends AppCompatActivity{
    ArrayList<String> meats = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    Random rand = new Random();
    String[] beef = {"Sirloin", "Burger", "Filet Mingon", "Ribeye", "Flank Steak" };
    String[] chicken = {"Chicken Breast", "Chicken Wings", "Chicken Thighs"};
    String[] fish = {"Cod", "Salmon", "Mahi Mahi", "Tuna", "Perch", "Walleye"};
    String[] pork = {"Pork Chop", "Pork Loin", "Pork Belly"};
    String[] beefDesc = {"Seared", "Oven Baked", "Grilled"};
    String[] chickenDesc = {"Fried", "Broasted", "Barbecued", "Oven Baked", "Grilled"};
    String[] fishDesc = {"Fried", "Seared", "Oven Baked", "Grilled"};
    String[] porkDesc = {"Fried", "Seared", "Barbecued", "Oven Baked", "Grilled"};

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);
        CheckBox beefCheck = findViewById(R.id.checkBox);
        CheckBox chickenCheck = findViewById(R.id.checkBox2);
        CheckBox fishCheck = findViewById(R.id.checkBox3);
        CheckBox porkCheck = findViewById(R.id.checkBox4);
        boolean beef = getSharedPreferences("check_beef",Context.MODE_PRIVATE).getBoolean("check_beef", false);
        boolean chicken = getSharedPreferences("check_chicken", Context.MODE_PRIVATE).getBoolean("check_chicken", false);
        boolean fish = getSharedPreferences("check_fish",Context.MODE_PRIVATE).getBoolean("check_fish", false);
        boolean pork = getSharedPreferences("check_pork", Context.MODE_PRIVATE).getBoolean("check_pork", false);
        if (beef == true){
            beefCheck.setChecked(true);
            onCheckboxClicked(beefCheck);
        }
        else
        {
            beefCheck.setChecked(false);
        }
        if(chicken == true){
            chickenCheck.setChecked(true);
            onCheckboxClicked(chickenCheck);
        }
        else
        {
            chickenCheck.setChecked(false);
        }
        if (fish == true){
            fishCheck.setChecked(true);
            onCheckboxClicked(fishCheck);
        }
        else
        {
            fishCheck.setChecked(false);
        }
        if(pork == true){
            porkCheck.setChecked(true);
            onCheckboxClicked(porkCheck);
        }
        else
        {
            porkCheck.setChecked(false);
        }
    }

    public void onCheckboxClicked(View view){
        SharedPreferences checker = getSharedPreferences("check_beef", MODE_PRIVATE);
        SharedPreferences.Editor cEditor = checker.edit();
        SharedPreferences checker2 = getSharedPreferences("check_chicken", MODE_PRIVATE);
        SharedPreferences.Editor c2Editor = checker2.edit();
        SharedPreferences checker3 = getSharedPreferences("check_fish", MODE_PRIVATE);
        SharedPreferences.Editor c3Editor = checker3.edit();
        SharedPreferences checker4 = getSharedPreferences("check_pork", MODE_PRIVATE);
        SharedPreferences.Editor c4Editor = checker4.edit();

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.checkBox:
                if (checked){
                    cEditor.putBoolean("check_beef", true);
                    for(int i = 0; i < beef.length; i++ ){
                        meats.add(beef[i]);
                    }
                    /*for(int i = 0; i < beefDesc.length; i++ ){
                        description.add(beefDesc[i]);
                    }*/
                }
                else {
                    cEditor.putBoolean("check_beef", false);
                    for (int i = 0; i < beef.length; i++) {
                        meats.remove(beef[i]);
                    }
                    /*for (int i = 0; i < beefDesc.length; i++) {
                        description.remove(beefDesc[i]);
                    }*/
                }
                cEditor.commit();
                break;

            case R.id.checkBox2:
                if (checked) {
                    c2Editor.putBoolean("check_chicken", true);
                    for (int i = 0; i < chicken.length; i++) {
                        meats.add(chicken[i]);
                    }
                    /*for (int i = 0; i < chickenDesc.length; i++) {
                        description.add(chickenDesc[i]);
                    }*/
                }
                else {
                    c2Editor.putBoolean("check_chicken", false);
                    for (int i = 0; i < chicken.length; i++) {
                        meats.remove(chicken[i]);
                    }
                    /*for(int i = 0; i< chickenDesc.length; i++){
                        description.remove(chickenDesc[i]);
                    }*/
                }
                c2Editor.commit();
                break;

            case R.id.checkBox3:
                if (checked) {
                    c3Editor.putBoolean("check_fish", true);
                    for (int i = 0; i < fish.length; i++) {
                        meats.add(fish[i]);
                    }
                    /*for(int i = 0; i < fishDesc.length; i++ ){
                        description.add(fishDesc[i]);
                    }*/
                }
                else {
                    c3Editor.putBoolean("check_fish", false);
                    for (int i = 0; i < fish.length; i++) {
                        meats.remove(fish[i]);
                    }
                    /*for(int i = 0; i< fishDesc.length; i++){
                        description.remove(fishDesc[i]);
                    }*/
                }
                c3Editor.commit();
                break;

            case R.id.checkBox4:
                if (checked) {
                    c4Editor.putBoolean("check_pork", true);
                    for (int i = 0; i < pork.length; i++) {
                        meats.add(pork[i]);
                    }
                    /*for(int i = 0; i < porkDesc.length; i++ ){
                        description.add(porkDesc[i]);
                    }*/
                }
                else {
                    c4Editor.putBoolean("check_fish", false);
                    for (int i = 0; i < pork.length; i++) {
                        meats.remove(pork[i]);
                    }
                    /*for(int i = 0; i< porkDesc.length; i++){
                        description.remove(porkDesc[i]);
                    }*/
                }
                c4Editor.commit();
                break;
        }

    }

    public void sendBack(View view) {
        if (meats.size() == 0) {
            Toast.makeText(getApplicationContext(), "No selection has been made", Toast.LENGTH_SHORT).show();
        } else {
            String finalMeat = meats.get(rand.nextInt(meats.size()));
            if (useList(beef, finalMeat)) {
                for (int i = 0; i < beefDesc.length; i++) {
                    description.add(beefDesc[i]);
                }
            } else if (useList(chicken, finalMeat)) {
                for (int i = 0; i < chickenDesc.length; i++) {
                    description.add(chickenDesc[i]);
                }
            } else if (useList(fish, finalMeat)) {
                for (int i = 0; i < fishDesc.length; i++) {
                    description.add(fishDesc[i]);
                }
            } else {
                for (int i = 0; i < porkDesc.length; i++) {
                    description.add(porkDesc[i]);
                }
            }

            //Last changes to descriptions of meat
            switch (finalMeat) {
                case "Cod":
                    description.add("Broasted");
                    break;
                case "Salmon":
                case "Mahi Mahi":
                case "Tuna":
                case "Pork Loin":
                    description.remove("Fried");
                    break;
                case "Walleye":
                    description.remove("Seared");
                    break;
                case "Pork Belly":
                    description.remove("Barbecued");
                    break;
            }

            String finalDesc = description.get(rand.nextInt(description.size()));

            //Create and save shared preferences
            SharedPreferences sharedPref = getSharedPreferences("Meat_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            SharedPreferences descPref = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE);
            SharedPreferences.Editor descEditor = descPref.edit();
            editor.putString(getResources().getString(R.string.Meat_ID), finalMeat);
            descEditor.putString(getResources().getString(R.string.Desc_ID), finalDesc);
            editor.commit();
            descEditor.commit();
            Intent intent = new Intent(this, DisplayMessageActivity.class);

            //Send and toast confirmation
            startActivity(intent);
            String Tester = getSharedPreferences("Meat_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Meat_ID), finalMeat);
            String descTester = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Desc_ID), finalDesc);
            if ((Tester.equals(finalMeat)) && (descTester.equals(finalDesc))) {
                Toast.makeText(getApplicationContext(), "Meat Saved!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public static boolean useList(String[] arr, String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }
}

