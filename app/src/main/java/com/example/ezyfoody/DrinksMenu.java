package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrinksMenu extends AppCompatActivity {

    public static final String MENU= "Menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);
        Intent intent = getIntent();

        Button b1 = findViewById(R.id.buttonAir);
        Button b2 = findViewById(R.id.buttonApel);
        Button b3 = findViewById(R.id.buttonMangga);
        Button b4 = findViewById(R.id.buttonAlpukat);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Air Mineral");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Jus Apel");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Jus Mangga");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Jus Alpukat");
            }
        });

        Button myOrder = findViewById(R.id.buttonMyOrder2);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMyOrder(v);
            }
        });
    }

    public void viewMyOrder(View view) {
        Intent intent = new Intent(DrinksMenu.this, MyOrder.class);
        startActivity(intent);
    }

    public void sendMessage(View view, String x){
        String order = x;
        Intent intent = new Intent(DrinksMenu.this, Quantity.class);
        intent.putExtra(MENU, order);
        startActivity(intent);
    }

//    public void chooseAir(View view)
//    {
//        sendMessage("Air Mineral");
//    }
//
//    public void chooseApel()
//    {
//        sendMessage("Jus Apel");
//    }
//
//    public void chooseMangga()
//    {
//        sendMessage("Jus Mangga");
//    }
//
//    public void chooseAlpukat()
//    {
//        sendMessage("Jus Alpukat");
//    }
}