package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.mix_tailsapp.EXTRA_NAME";
    public static final String EXTRA_EMAIL = "com.example.mix_tailsapp.EXTRA_EMAIL";
    public static final String EXTRA_PASS = "com.example.mix_tailsapp.EXTRA_PASS";
    public static final String EXTRA_CONFIRMPASSWORD = "com.example.mix_tailsapp.EXTRA_CONFIRMPASSWORD";

    private EditText name, email, password, confirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //casting the edit text variables to their ids
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.comfirm_password);


        Button confirm = findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(v -> formSubmitted());
    }
    //create a method for form submitted confirmation
    public void formSubmitted() {
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String confirmPassword = confirm_password.getText().toString();

        Intent intent = new Intent(this, Signup_ConfirmationScreen.class);
        intent.putExtra(EXTRA_NAME, userName);
        intent.putExtra(EXTRA_EMAIL, userEmail);
        intent.putExtra(EXTRA_PASS, userPassword);
        intent.putExtra(EXTRA_CONFIRMPASSWORD, confirmPassword);

        startActivity(intent);
    }

}