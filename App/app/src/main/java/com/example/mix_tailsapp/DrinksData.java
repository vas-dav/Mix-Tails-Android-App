package com.example.mix_tailsapp;

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
    
    public String getName(){
        return this.name;
    }
}

