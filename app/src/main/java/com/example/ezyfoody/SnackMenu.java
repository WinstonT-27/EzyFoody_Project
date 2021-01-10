package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SnackMenu extends AppCompatActivity {
    public static final String MENU= "Menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_menu);

        Intent intent = getIntent();

        Button b1 = findViewById(R.id.buttonRisoles);
        Button b2 = findViewById(R.id.buttonPukis);
        Button b3 = findViewById(R.id.buttonBolu);
        Button b4 = findViewById(R.id.buttonMartabak);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Risoles");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Pukis");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Bolu");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, "Martabak");
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
        Intent intent = new Intent(SnackMenu.this, MyOrder.class);
        startActivity(intent);
    }

    public void sendMessage(View view, String x){
        String order = x;
        Intent intent = new Intent(SnackMenu.this, Quantity.class);
        intent.putExtra(MENU, order);
        startActivity(intent);
    }
}