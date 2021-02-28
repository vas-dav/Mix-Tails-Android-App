package com.example.mix_tailsapp;

// This class is for Drinks to have keywords(properties), for the algorithm to recognise the Drink
public class DrinksData {
    private String spirit;
    private String size;
    private String taste;
    private String strength;
    private String name;


    public DrinksData(String name, String spirit, String size, String taste, String strenght) {
        this.name = name;
        this.spirit = spirit;
        this.size = size;
        this.taste = taste;
        this.strength = strenght;

    }

    public String getName() {
        return name;
    }

    public String getSpirit() {
        return spirit;
    }

    public String getSize() {
        return size;
    }

    public String getTaste() {
        return taste;
    }

    public String getStrength() {
        return strength;
    }

    public String toString() { return name; }
}




