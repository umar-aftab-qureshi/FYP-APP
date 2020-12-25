package com.example.iqp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class loginActivity extends AppCompatActivity {
    TextInputEditText username;
    TextInputEditText password;
    DataBaseHandler dataBaseHandler;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (TextInputEditText) findViewById(R.id.username1);
        password = (TextInputEditText) findViewById(R.id.password1);
        dataBaseHandler = new DataBaseHandler(this);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }

    public void login(View view) {
        Boolean s = false;
        if (isValid()) {

            s = dataBaseHandler.isLogged(username.getText().toString(), password.getText().toString());
            if (s) {
                Toast.makeText(this, "Logging Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Prediction.class));

            }
            if (!s) {
                password.setText("");
                password.setError("Wrong password");
                password.requestFocus();
            }
        }

    }


//        if (dataBaseHandler.isLogged(username.getText().toString(),password.getText().toString())){
//            Toast.makeText(this,"Logged ",Toast.LENGTH_LONG).show();
//
//        }
//        else
//        {
//            password.setText("");
//            password.setError("Wrong password");
//            password.requestFocus();
//        }


    private Boolean isValid() {
        Boolean ch = true;
        if (username.getText().toString().trim().length() <= 0) {
            username.requestFocus();
            username.setError("Field is empty");
            ch = false;
        } else if (password.getText().toString().trim().length() <= 0) {
            password.requestFocus();
            password.setError("Field is empty");
            ch = false;
        } else {
            ch = true;
        }
        return ch;
    }
}
