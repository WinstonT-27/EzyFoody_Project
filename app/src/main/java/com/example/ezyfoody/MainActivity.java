package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Button button = findViewById(R.id.buttonDrinks);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        Button buttonMyOrder = findViewById(R.id.buttonMyOrder);
        buttonMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyOrder.class);
                startActivity(intent);
            }
        });

        Button topup = findViewById(R.id.buttonTopUp);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Topup.class);
                startActivity(i);
            }
        });
    }

    public void sendMessage(View v)
    {
        Intent intent = new Intent(MainActivity.this, DrinksMenu.class);
        startActivity(intent);
    }
}