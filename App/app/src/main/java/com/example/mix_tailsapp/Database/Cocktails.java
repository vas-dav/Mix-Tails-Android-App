package com.example.mix_tailsapp.Database;

/**
 * Created by Annie on 05/03/2021
 * author: Annie
 * An Object Cocktails in the Database package that contains constructor and method for setting
 * and getting id, name, spirit, taste, size, strength, ingredients of cocktails respectively
 * @version constructor creation
 */
public class Cocktails {
    public int id;
    public String name, spirit, taste, size, strength, ingredients;

    /**
     * Creating Cocktails constructor that contains if, name, spirit, taste, sie, strength, ingredients
     * @param id int type, id of cocktail
     * @param name String type, name of cocktail
     * @param spirit String type, spirit
     * @param taste String type, taste of drink
     * @param size String type, drink size
     * @param strength String type, strength of drink based on alcohol percentage
     * @param ingredients String type, what contained in the drink
     */
    public Cocktails(int id, String name, String spirit, String taste, String size, String strength, String ingredients) {
        this.id = id;
        this.name = name;
        this.spirit = spirit;
        this.taste = taste;
        this.size = size;
        this.strength = strength;
        this.ingredients = ingredients;
    }

    public Cocktails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpirit() {
        return spirit;
    }

    public void setSpirit(String spirit) {
        this.spirit = spirit;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
