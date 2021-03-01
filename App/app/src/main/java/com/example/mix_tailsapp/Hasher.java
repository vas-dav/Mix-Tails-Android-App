package com.example.mix_tailsapp;

public class Hasher {

    private int a = (int) Math.pow(5 * 34, 45);

    public Hasher() {};


    public String hPSCD (String passCode){
    int intPSCD = 0;
    for(int l = 0; l < passCode.length(); l++){
        char symb = passCode.charAt(l);
        int charNum = (int) symb;
        intPSCD += Math.pow(charNum * a, charNum * a);
    }
        int[] binary = new int[35];
        int id = 0;


        while (intPSCD > 0) {
            binary[id++] = intPSCD % 2;
            intPSCD = intPSCD / 2;
        }

        return binary.toString();
    }
}

