package com.example.mix_tailsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mix_tailsapp.UserActivity.SignupConfirmationScreen;

import static com.example.mix_tailsapp.R.color.red;

/**
 * author: Vasily, Annie, Miguel
 *
 * Lets the user sign up to the app with just a name, email
 * and password. Then prompt the users basic information.
 *
 * @version 1.1: added a Toast when one of the fields is empty (Annie)
 */
public class SignupActivity extends AppCompatActivity {
    //Declaring keys for sharedPreferences
    protected static final String EXTRA_NAME = "com.example.mix_tailsapp.EXTRA_NAME";
    protected static final String EXTRA_EMAIL = "com.example.mix_tailsapp.EXTRA_EMAIL";
    protected static final String EXTRA_PASS = "com.example.mix_tailsapp.EXTRA_PASS";
    protected static final String TEMP_STORAGE = "TEMPMEM";
    protected static final String PERM_STORAGE = "PERMMEM";
    protected static final String SIGNED = "NEISRHUIGBHJSjioHUIRBRBAENUFUIS";
    Hasher hashpass = new Hasher();

    //Declaring variables
    private EditText name, email, password, confirm_password;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Casting EditText variables to their id:s
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.comfirm_password);
        signUp = findViewById(R.id.maintext);
        Button confirm = findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() ||
                    password.getText().toString().isEmpty() || confirm.getText().toString().isEmpty())
            {
                Toast.makeText(SignupActivity.this, "Field cannot be empty",
                        Toast.LENGTH_SHORT).show();
            } else {
                formSubmitted();
            }
        });
    }

    /**
     * Create a method for form submitted confirmation and saving userData to sharedPreferences
     */

    @SuppressLint("ResourceAsColor")
    public void formSubmitted() {
        Intent conf = new Intent(SignupActivity.this, SignupConfirmationScreen.class);

        //[storagePut] is for storing signed boolean
        SharedPreferences storagePut = getSharedPreferences(TEMP_STORAGE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = storagePut.edit();
        prefEditor.putString(EXTRA_NAME, name.getText().toString());

        //[permStoragePut] is for storing name, password, email and  other values, like fuelTank, soberness for future login's
        SharedPreferences permStoragePut = getSharedPreferences(PERM_STORAGE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor permPrefEditor = permStoragePut.edit();
        permPrefEditor.putString(EXTRA_NAME, name.getText().toString());
        permPrefEditor.putString(EXTRA_EMAIL, email.getText().toString());

        //Checking if passwords match
        if (password.getText().toString().equals(confirm_password.getText().toString())) {
            permPrefEditor.putString(EXTRA_PASS, hashpass.CrToBiWL(hashpass.hLtoS(hashpass.hPSCD(password.getText().toString()))));
            prefEditor.putBoolean(SIGNED, true);
            if (prefEditor.commit() && permPrefEditor.commit()) {
                startActivity(conf);
            }
        }
        else {
            signUp.setText("Passwords doesn't match :(");
            signUp.setTextSize(25);
            confirm_password.setTextColor(red);
        }
    }
}