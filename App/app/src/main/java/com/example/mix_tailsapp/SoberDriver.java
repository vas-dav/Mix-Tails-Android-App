package com.example.mix_tailsapp;


import java.util.concurrent.TimeUnit;

/**
 * author: Vasily
 * This algorithm is based on the Univeristy of Michigan
 * Research and data taken from: https://uhs.umich.edu/time-to-sober-up
 */
public class SoberDriver {
    private static double decrease = 1 - 0.015;

    public int alcoAmount(double amount) {
        int hours = 0;
        double p = amount;
        do{
            p *= decrease;
            hours++;
        }while(p > 0.005);

        return hours;
    }



}
