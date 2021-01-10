package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodMenu extends AppCompatActivity {

    public static final String MENU= "Menu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        Intent intent = getIntent();

        Button b1 = findViewById(R.id.buttonNasiPutih);
        Button b2 = findViewById(R.id.buttonNasiKuning);
        Button b3 = findViewById(R.id.buttonBurger);
        Button b4 = findViewById(R.id.buttonHotDog);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Nasi Putih");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Nasi Kuning");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Burger");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Hot Dog");
            }
        });

        Button myOrder = findViewById(R.id.buttonMyOrder2);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMyOrder(v);
            }
        });

        Button back = findViewById(R.id.buttonBackToMain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void viewMyOrder(View view) {
        Intent intent = new Intent(FoodMenu.this, MyOrder.class);
        startActivity(intent);
    }

    public void sendMessage(View view, String x){
        String order = x;
        Intent intent = new Intent(FoodMenu.this, Quantity.class);
        intent.putExtra(MENU, order);
        startActivity(intent);
    }
}