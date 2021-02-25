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
    DrinksData WhiskeySour = new DrinksData("Whiskey Sour", "Whiskey", "L", "Sour", "Mild");
    DrinksData Bacardi = new DrinksData("Bacardi", "Rum", "M", "Fresh", "Mild");
    DrinksData DryMartini = new DrinksData("Dry Martini", "Gin", "M", "Boozy", "Strong");
    DrinksData Negroni = new DrinksData("Negroni","Gin", "M", "Bitter Sweet", "Mild");
    DrinksData Boulevardier = new DrinksData("Boulevardier", "Whiskey", "S", "Bitter sweet", "Strong");
    DrinksData OldFashioned = new DrinksData("Old Fashioned", "Whiskey", "M", "Boozy", "Strong");
    DrinksData BloodAndSand = new DrinksData("Blood and Sand", "Whiskey", "M", "Sweet", "Mild");
    DrinksData CynarTown = new DrinksData("CynarTown", "Gin", "L", "Bitter sweet", "Strong");
    DrinksData French75 = new DrinksData("French 75", "Gin", "M", "Fresh", "Soft");
    DrinksData WhiteLady = new DrinksData("White lady", "Gin", "M", "Fresh", "Soft");
    DrinksData Cosmopolitan = new DrinksData("Cosmopolitan", "Vodka", "S", "Fresh", "Mild");
    DrinksData ScrewDriver = new DrinksData("Screwdriver", "Vodka", "L", "Fresh", "Soft");
    DrinksData SideCar = new DrinksData("Sidecar", "Cognac", "M", "Fresh", "Soft");
    DrinksData GinFizz = new DrinksData("Gin Fizz", "Gin", "L", "Fresh", "Soft");
    DrinksData JohnCollins = new DrinksData("John Collins", "Gin", "L", "Fresh", "Soft");
    DrinksData TomCollins = new DrinksData("Tom Collins", "Gin", "L", "Fersh", "Soft");
    DrinksData RustyNail = new DrinksData("Rusty nail", "Whiskey", "S", "Boozy", "Strong");
    DrinksData HarveyWallbanger = new DrinksData("Harvey Wallbanger", "Vodka", "L", "Fresh", "Mild");
    DrinksData Gimlet = new DrinksData("Gimlet", "Gin", "S", "Sour", "Mild");
    DrinksData TwentiethCentury = new DrinksData("Twentieth Century", "Gin", "M", "Fresh", "Soft");
    DrinksData IrishCoffee = new DrinksData("Irish coffee", "Whiskey", "L", "Boozy", "Strong");
    DrinksData Margarita = new DrinksData("Margarita", "Tequila", "L", "Fresh", "Mild");


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
        cocktail.add(Negroni);
        cocktail.add(Boulevardier);
        cocktail.add(OldFashioned);
        cocktail.add(BloodAndSand);
        cocktail.add(CynarTown);
        cocktail.add(French75);
        cocktail.add(WhiteLady);
        cocktail.add(Cosmopolitan);
        cocktail.add(ScrewDriver);
        cocktail.add(SideCar);
        cocktail.add(GinFizz);
        cocktail.add(JohnCollins);
        cocktail.add(TomCollins);
        cocktail.add(RustyNail);
        cocktail.add(HarveyWallbanger);
        cocktail.add(Gimlet);
        cocktail.add(TwentiethCentury);
        cocktail.add(IrishCoffee);
        cocktail.add(Margarita);
    }

    //very first version of comparison algorithm (not tested yet)

    public DrinksData getDrinkData(int drinkIndex){
        return this.cocktail.get(drinkIndex);
    }


    public String compareDrinks(String inputSpirit, String inputSize, String inputTaste, String inputStrenght) {

        DrinksData comparison = new DrinksData("Comp", inputSpirit, inputSize, inputTaste, inputStrenght);
        String yourDrink = null;
        for (int i = 0; i < cocktail.size(); i++) {
            if (cocktail.get(i).getSpirit() == comparison.getSpirit()
                    && cocktail.get(i).getSize() == comparison.getSize()
                    && cocktail.get(i).getTaste() == comparison.getTaste()
                    && cocktail.get(i).getStrength() == comparison.getStrength() )
                yourDrink = cocktail.get(i).getName();

        }
        return yourDrink;
    }

   //A method for randomizing drinks for "Surprise me" button

   public String surprise(){
       int b = (int)(Math.random()*(cocktail.size()));

       return cocktail.get(b).getName();
   }

}
