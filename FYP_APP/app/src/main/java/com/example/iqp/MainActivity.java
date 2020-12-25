package com.example.iqp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}

    public void SignUp(View view) {
        Intent intent = new Intent (this, signUp.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent (this, loginActivity.class);
        startActivity(intent);
    }
}