package com.example.mix_tailsapp;


/**
 * authors: Miguel, Vasily
 * This class is intended for the user to add favorite drink
 * in a new table of the app database(Drinks.db)
 */

public class FavoriteDrinks {
        private String drink_name;
        private int drink_image;

        public FavoriteDrinks () {

        }

    public FavoriteDrinks(String drink_name, int drink_image) {
        this.drink_name = drink_name;
        this.drink_image = drink_image;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public int getDrink_image() {
        return drink_image;
    }

    public void setDrink_image(int drink_image) {
        this.drink_image = drink_image;
    }
}
