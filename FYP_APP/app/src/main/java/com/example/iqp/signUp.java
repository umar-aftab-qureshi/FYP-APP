package com.example.iqp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class signUp extends AppCompatActivity {
    TextInputEditText username;
    TextInputEditText email;
    TextInputEditText password;
    TextInputEditText confirm_password;

    Users user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        //userData = new String [3];

    }

    public void signUp(View view) {
        user = new Users(username.getText().toString(),email.getText().toString(),password.getText().toString());
        Boolean c = formValidation();
        Boolean d= passMatch();


        if (c && d)
        {
            DataBaseHandler db = new DataBaseHandler(this);
            try
                {
                   Boolean ch  = db.addInformation(user);
                   if ( ch == true)
                   {
                       Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                       username.setText("");
                       password.setText("");
                       email.setText("");
                       confirm_password.setText("");
                   }
                   else
                   {
                       username.requestFocus();
                       username.setError("Already Exits");
                       Toast.makeText(getApplicationContext(),"User already exits",Toast.LENGTH_SHORT).show();
                   }
                }
            catch(SQLiteConstraintException e)
            {
                Log.d("TAG","Working");
            } }
 }

    private Boolean formValidation() {
        Boolean ch=true;


        Boolean mailCheck=!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches();
        if (user.getUsername().trim().length() <= 0 ) {
            username.requestFocus();
            username.setError("Username is empty!");
            ch = false;
        }
        else if (user.getUsername().contains(" "))
        {
            username.requestFocus();
            username.setError("Space not Allowd!!");
            ch = false;
        }

            else if (user.getEmail().trim().length() <= 0 || mailCheck )
        {
                email.requestFocus();
                email.setError("Email is not valid!");
                ch = false;
            }

        else if ( user.getPassword().trim().length() <= 0)
        {
            password.requestFocus();
            password.setError("Password is empty!");
            ch = false;
        }
        else if (confirm_password.getText().toString().trim().length() <= 0)
        {
            confirm_password.requestFocus();
            confirm_password.setError("Password is empty!");
            ch = false;
        }
        return ch;
    }
    private Boolean passMatch()
    {
        Boolean ch = true;
        if (!(password.getText().toString().equals(confirm_password.getText().toString())))
        {
            confirm_password.setError("Password mismatched");

            ch = false;
        }
        return  ch;
    }


    public void login(View view) {
        Intent intent = new Intent (this, loginActivity.class);
        startActivity(intent);
    }
}