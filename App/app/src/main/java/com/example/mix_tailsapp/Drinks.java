package com.example.mix_tailsapp;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private static final Drinks drinksInstance = new Drinks();

    //Drinks with properties
    public static Drinks getInstance(){
        return drinksInstance;
    }
    DrinksData BlackVelvet = new DrinksData("Black Velvet", "Prosecco", "S", "Fresh", "Mild");
    DrinksData Bellini = new DrinksData("Bellini", "Prosecco", "L", "Fresh", "Soft");
    DrinksData AngelFace = new DrinksData("Angel Face", "Gin", "S", "Boozy", "Strong");
    DrinksData Godfather = new DrinksData("GodFather", "Whiskey", "S", "Sweet", "Strong");
    DrinksData Godmother = new DrinksData("GodMother", "Vodka", "S", "Sweet", "Strong");
    DrinksData Daiquiri = new DrinksData("Daiquiri", "Rum", "M", "Fresh", "Mild");
    DrinksData WhiskeySour = new DrinksData("Whiskey Sour", "Whiskey", "L", "Sour", "Soft");
    DrinksData Bacardi = new DrinksData("Bacardi", "Rum", "M", "Fresh", "Mild");
    DrinksData DryMartini = new DrinksData("Dry Martini", "Gin", "M", "Boozy", "Strong");

    private List<DrinksData> cocktail;

    //Adding Drinks to the List
    private Drinks(){
        cocktail = new ArrayList<>();
        cocktail.add(BlackVelvet);
        cocktail.add(Bellini);
        cocktail.add(AngelFace);
        cocktail.add(Godfather);
        cocktail.add(Godmother);
        cocktail.add(Daiquiri);
        cocktail.add(WhiskeySour);
        cocktail.add(Bacardi);
        cocktail.add(DryMartini);
    }

    //very first version of comparison algorithm (not tested yet)

    public DrinksData getDrinkData(int drinkIndex){
        return this.cocktail.get(drinkIndex);
    }

    public String compareDrinks(String inputSpirit, String inputSize, String inputTaste, String inputStrenght) {

        DrinksData comparison = new DrinksData("Comp", inputSpirit, inputSize, inputTaste, inputStrenght);
        String yourDrink = null;
        for (int i = 0; i < cocktail.size(); i++) {
            if (comparison.equals(cocktail.get(i))) {
                yourDrink = cocktail.get(i).getName();
            }

        }
        return yourDrink;
    }

   //A method for randomizing drinks for "Surprise me" button

   public String surprise(){
       int b = (int)(Math.random()*(cocktail.size()));

       return cocktail.get(b).getName();
   }

}
