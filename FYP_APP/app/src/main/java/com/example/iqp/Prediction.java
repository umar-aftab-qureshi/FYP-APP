package com.example.iqp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Prediction extends AppCompatActivity {
    Spinner category;
    Spinner days;
    ArrayAdapter<CharSequence> Category;
    ArrayAdapter<CharSequence> Days;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predication);
        category=(Spinner)findViewById(R.id.categoryspinner);
        days=(Spinner)findViewById(R.id.DaysId);
        Category = ArrayAdapter.createFromResource(this,R.array.Category,android.R.layout.select_dialog_item);
        Days = ArrayAdapter.createFromResource(this,R.array.days, android.R.layout.select_dialog_item);
        category.setAdapter(Category);

        days.setAdapter(Days);
        submit=(Button)findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),graphDisplay.class));
            }
        });
 }
}