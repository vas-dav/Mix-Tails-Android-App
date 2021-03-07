package com.example.mix_tailsapp.Database;

/**
 * Created by Annie on 06/03/2021
 * author: Annie
 * An Object Favorites in the Database package that contains constructor and method for setting
 * and getting id, name, spirit, taste, size, strength, ingredients, favorite status
 * of cocktails respectively
 * @version constructor creation
 */
public class Favorites {

    private String name, image;

    public Favorites() {
    }

    public Favorites(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
