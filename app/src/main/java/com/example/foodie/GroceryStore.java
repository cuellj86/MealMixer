package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GroceryStore extends AppCompatActivity {
    public static String finalMeat;
    public static String finalDescription;
    static ArrayList<String> meats = new ArrayList<String>();
    static ArrayList<String> meatDescription = new ArrayList<String>();
    static Random rand = new Random();
    String[] beef = {"Sirloin", "Burger", "Filet Mingon", "Ribeye", "Flank Steak" };
    String[] chicken = {"Chicken Breast", "Chicken Wings", "Chicken Thighs"};
    String[] fish = {"Cod", "Salmon", "Mahi Mahi", "Tuna", "Perch", "Walleye"};
    String[] pork = {"Pork Chop", "Pork Loin", "Pork Belly"};
    String[] beefDesc = {"Seared", "Oven Baked", "Grilled"};
    String[] chickenDesc = {"Fried", "Broasted", "Barbecued", "Oven Baked", "Grilled"};
    String[] fishDesc = {"Fried", "Seared", "Oven Baked", "Grilled"};
    String[] porkDesc = {"Fried", "Seared", "Barbecued", "Oven Baked", "Grilled"};

    public static String finalVeggie;
    public static String finalVegDescription;
    static ArrayList<String> veggie = new ArrayList<String>();
    static ArrayList<String> vegDescription = new ArrayList<String>();
    String[] roots = {"Potatoes", "Yams", "Rutabegas", "Carrots"};
    String[] vine = {"Corn", "Green Beans", "Squash"};
    String[] rootsDesc = {"Mashed", "Grilled", "Roasted", "Oven Baked"};
    String[] vineDesc = {"Grilled", "Sauteed", "Pureed"};

    public static String finalStarch;
    public static String finalStarchDescription;
    static ArrayList<String> starches = new ArrayList<String>();
    static ArrayList<String> starchDescription = new ArrayList<String>();
    String[] pasta = {"Linguini", "Macaroni", "Spaghetti", "Angel Hair"};
    String[] bread = {"Garlic Bread", "Italian Bread", "Croissants", "Biscuits"};
    String[] pastaDesc = {"Cheesy", "Red Sauce", "White Sauce"};
    String[] breadDesc = {"Cheesy", "Warm", "Buttery"};

    public void beefGenerator(Boolean bool){
        if (bool == true) {
            for (int i = 0; i < beef.length; i++) {
                meats.add(beef[i]);
            }
        } else {
            for (int i = 0; i < beef.length; i++) {
                meats.remove(beef[i]);
            }
        }
    }

    public void chickenGenerator(Boolean bool){
        if (bool == true) {
            for (int i = 0; i < chicken.length; i++) {
                meats.add(chicken[i]);
            }
        } else {
            for (int i = 0; i < chicken.length; i++) {
                meats.remove(chicken[i]);
            }
        }
    }

    public void fishGenerator(Boolean bool){
        if (bool == true) {
            for (int i = 0; i < fish.length; i++) {
                meats.add(fish[i]);
            }
        } else {
            for (int i = 0; i < fish.length; i++) {
                meats.remove(fish[i]);
            }
        }
    }

    public void porkGenerator(Boolean bool){
        if (bool == true) {
            for (int i = 0; i < pork.length; i++) {
                meats.add(pork[i]);
            }
        } else {
            for (int i = 0; i < pork.length; i++) {
                meats.remove(pork[i]);
            }
        }
    }

    public void vineGenerator(Boolean bool){
        if (bool == true) {
            for(int i = 0; i < vine.length; i++){
                veggie.add(vine[i]);
            }
        } else {
            for(int i = 0; i < vine.length; i++){
                veggie.remove(vine[i]);
            }
        }
    }

    public void rootGenerator(Boolean bool){
        if (bool == true) {
            for (int i = 0; i < roots.length; i++)
                veggie.add(roots[i]);
        } else {
            for(int i = 0; i < roots.length; i++){
                veggie.remove(roots[i]);
            }
        }
    }

    public void pastaGenerator(Boolean bool){
        if (bool == true){
            for(int i = 0; i < pasta.length; i++){
                starches.add(pasta[i]);
            }
        }
        else{
            for(int i = 0; i < pasta.length; i++){
                starches.remove(pasta[i]);
            }
        }
    }

    public void breadGenerator(Boolean bool){
        if (bool == true){
            for(int i = 0; i < bread.length; i++){
                starches.add(bread[i]);
            }
        }
        else{
            for(int i = 0; i < bread.length; i++){
                starches.remove(bread[i]);
            }
        }
    }

    public void meatSetting(){
        //Last changes to descriptions of meat
        returnMeat();
        if (useList(beef, finalMeat)) {
            for (int i = 0; i < beefDesc.length; i++) {
                meatDescription.add(beefDesc[i]);
            }
        } else if (useList(chicken, finalMeat)) {
            for (int i = 0; i < chickenDesc.length; i++) {
                meatDescription.add(chickenDesc[i]);
            }
        } else if (useList(fish, finalMeat)) {
            for (int i = 0; i < fishDesc.length; i++) {
                meatDescription.add(fishDesc[i]);
            }
        } else {
            for (int i = 0; i < porkDesc.length; i++) {
                meatDescription.add(porkDesc[i]);
            }
        }
        switch (finalMeat) {
            case "Cod":
                meatDescription.add("Broasted");
                break;
            case "Salmon":
            case "Mahi Mahi":
            case "Tuna":
            case "Pork Loin":
                meatDescription.remove("Fried");
                break;
            case "Walleye":
                meatDescription.remove("Seared");
                break;
            case "Pork Belly":
                meatDescription.remove("Barbecued");
                break;
        }
        returnDescription();
    }

    public void vegSetting(){
        returnVeggie();
        if (useList(roots, finalVeggie)){
            for(int i = 0; i < rootsDesc.length; i++){
                vegDescription.add(rootsDesc[i]);
            }
        }
        else {
            for(int i = 0; i < vineDesc.length; i++){
                vegDescription.add(vineDesc[i]);
            }
        }
        returnVegDescription();
    }

    public void starchSetting(){
        returnStarch();
        // I have no clue why the description array retains the same values, or why it is only for pasta
        if(starchDescription.size() > 0){
            starchDescription.clear();
        }
        if (useList(pasta, finalStarch)){
            for(int i = 0; i < pastaDesc.length; i++){
                starchDescription.add(pastaDesc[i]);
            }
        }
        else {
            for(int i = 0; i < breadDesc.length; i++){
                starchDescription.add(breadDesc[i]);
            }
        }
        returnStarchDescription();
    }


    public static boolean useList(String[] arr, String targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }

    public static String returnMeat(){
        return finalMeat = meats.get(rand.nextInt(meats.size()));
    }

    public static String returnDescription(){
        return finalDescription = meatDescription.get(rand.nextInt(meatDescription.size()));
    }

    public static String returnVeggie(){
        return finalVeggie = veggie.get(rand.nextInt(veggie.size()));
    }

    public static String returnVegDescription(){
        return finalVegDescription = vegDescription.get(rand.nextInt(vegDescription.size()));
    }

    public static String returnStarch(){
        return finalStarch = starches.get(rand.nextInt(starches.size()));
    }

    public static String returnStarchDescription(){
        return finalStarchDescription = starchDescription.get(rand.nextInt(starchDescription.size()));
    }
}
