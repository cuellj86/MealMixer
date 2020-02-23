package com.example.foodie;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Endscreen extends AppCompatActivity {
    TextView trythis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endscreen);

        /*String meat = getResources().getString(R.string.Meat_ID);*/
        String meaty = getSharedPreferences("Meat_ID",Context.MODE_PRIVATE).getString(getResources().getString(R.string.Meat_ID), null);
        String meatDesc = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Desc_ID), null);
        String veggie = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Veg_ID), null);
        String vegDesc = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.VegDesc_ID), null);
        String starchy = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Starch_ID), null);
        String starchDesc = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.StarchDesc_ID), null);
        trythis = findViewById(R.id.textView8);
        if(meaty != null){
            trythis.setText(meatDesc+" "+meaty+" with "+vegDesc+" "+veggie+" and "+starchDesc+" "+starchy);
        }
    }

    public void newRecipe(View view){

        GroceryStore fixer = new GroceryStore();

        boolean beef = getSharedPreferences("check_beef",Context.MODE_PRIVATE).getBoolean("check_beef", false);
        boolean chicken = getSharedPreferences("check_chicken", Context.MODE_PRIVATE).getBoolean("check_chicken", false);
        boolean fish = getSharedPreferences("check_fish",Context.MODE_PRIVATE).getBoolean("check_fish", false);
        boolean pork = getSharedPreferences("check_pork", Context.MODE_PRIVATE).getBoolean("check_pork", false);
        boolean vine = getSharedPreferences("check_vine",Context.MODE_PRIVATE).getBoolean("check_vine", false);
        boolean root = getSharedPreferences("check_root", Context.MODE_PRIVATE).getBoolean("check_root", false);
        boolean pasta = getSharedPreferences("check_pasta",Context.MODE_PRIVATE).getBoolean("check_pasta", false);
        boolean bread = getSharedPreferences("check_bread", Context.MODE_PRIVATE).getBoolean("check_bread", false);

        fixer.beefGenerator(beef);
        fixer.chickenGenerator(chicken);
        fixer.fishGenerator(fish);
        fixer.porkGenerator(pork);
        fixer.meatSetting();

        fixer.vineGenerator(vine);
        fixer.rootGenerator(root);
        fixer.vegSetting();

        fixer.pastaGenerator(pasta);
        fixer.breadGenerator(bread);
        fixer.starchSetting();

        SharedPreferences sharedPref = getSharedPreferences("Meat_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        SharedPreferences descPref = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor descEditor = descPref.edit();
        editor.putString(getResources().getString(R.string.Meat_ID), fixer.finalMeat);
        descEditor.putString(getResources().getString(R.string.Desc_ID), fixer.finalDescription);
        editor.commit();
        descEditor.commit();

        SharedPreferences vegSharedPref = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor vegEditor = vegSharedPref.edit();
        SharedPreferences vegDescPref = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor vegDescEditor = vegDescPref.edit();
        vegEditor.putString(getResources().getString(R.string.Veg_ID), fixer.finalVeggie);
        vegDescEditor.putString(getResources().getString(R.string.VegDesc_ID), fixer.finalVegDescription);
        vegEditor.commit();
        vegDescEditor.commit();

        SharedPreferences starchSharedPref = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor starchEditor = starchSharedPref.edit();
        SharedPreferences starchDescPref = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE);
        SharedPreferences.Editor starchDescEditor = starchDescPref.edit();
        starchEditor.putString(getResources().getString(R.string.Starch_ID), fixer.finalStarch);
        starchDescEditor.putString(getResources().getString(R.string.StarchDesc_ID), fixer.finalStarchDescription);
        starchEditor.commit();
        starchDescEditor.commit();

        String meaty = getSharedPreferences("Meat_ID",Context.MODE_PRIVATE).getString(getResources().getString(R.string.Meat_ID), null);
        String meatDesc = getSharedPreferences("Desc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Desc_ID), null);
        String veggie = getSharedPreferences("Veg_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Veg_ID), null);
        String vegDesc = getSharedPreferences("VegDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.VegDesc_ID), null);
        String starchy = getSharedPreferences("Starch_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.Starch_ID), null);
        String starchDesc = getSharedPreferences("StarchDesc_ID", Context.MODE_PRIVATE).getString(getResources().getString(R.string.StarchDesc_ID), null);
        trythis = findViewById(R.id.textView8);
        if(meaty != null){
            trythis.setText(meatDesc+" "+meaty+" with "+vegDesc+" "+veggie+" and "+starchDesc+" "+starchy);
        }

    }
}
