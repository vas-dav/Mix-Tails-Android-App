package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * created 06/03/2021
 * authors: Vasily, An, Miguel
 *
 * One of our fun features is the fuel bar, here you can
 * set the amount of drinks to plant to drink when you are out
 * with friends, when the user reaches the set limit a message
 * will be show in apps screen.
 *
 */

public class FuelBarSet extends AppCompatActivity {

    //Declaring variables
    SeekBar drinkAmount;
    ProgressBar connection;
    TextView nums, emo;
    Button send;
    protected static final String LIMIT_AMOUNT = "WE_ARE_DRINKING_ONLY_WHEN_IT_IS_TIME_FOR_THAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_bar_set);

        //Assigning variables
        drinkAmount = findViewById(R.id.amountOfDrinks);
        connection =  findViewById(R.id.DrinksNum);
        nums = findViewById(R.id.drinksInsideaCircle);
        emo = findViewById(R.id.emotion);
        send = findViewById(R.id.buttonSetLimit);

        //FuelBar is set to 3 automatically
        drinkAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int drinkNum = 3;
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drinkNum = progress;
                connection.setProgress(drinkNum*10, true);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            // Changing quotes depending on the drink amount
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                nums.setText(Integer.toString(drinkNum));

                if(drinkNum == 25){
                    emo.setText(R.string.fuel_text_1);
                } else if(drinkNum < 25 && drinkNum >=20){
                    emo.setText(R.string.fuel_text_2);
                } else if(drinkNum < 20 && drinkNum >= 15){
                    emo.setText(R.string.fuel_text3);
                } else if(drinkNum < 15 && drinkNum >= 7){
                    emo.setText(R.string.fuel_text4);
                } else if(drinkNum < 7 && drinkNum >= 3){
                    emo.setText(R.string.fuel_text5);
                } else if(drinkNum < 3 && drinkNum >= 1){
                    emo.setText(R.string.fuel_text6);
                } else if(drinkNum == 0){
                    emo.setText(R.string.fuel_text7);
                }
                //Saving the data by the press of the button
                send.setOnClickListener(v ->  {
                    SharedPreferences drinkLimit = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
                    Intent sender = new Intent(FuelBarSet.this, HomePage.class);
                    Toast.makeText(FuelBarSet.this, "Your limit is " + drinkNum + " drinks", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor amountEditor = drinkLimit.edit();
                    amountEditor.putInt(LIMIT_AMOUNT, drinkNum);
                    if(amountEditor.commit()){
                        startActivity(sender);
                        Log.d("FuelBar", Integer.toString(drinkNum));
                    }
                });
            }
        });
    }
}