package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Quantity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        Intent intent = getIntent();
        final String order = intent.getStringExtra("Menu");
        final int price = Integer.parseInt(Runner.getPrice(order));

        final TextView tv = findViewById(R.id.textViewMenuQuantity);
        tv.setText(order + " Rp. "+ price);

        Button button = findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = findViewById(R.id.editTextQunatity);
                String quantity = et.getText().toString();
                int x = Integer.parseInt(quantity);
                Runner.addOrder(order, price, x);
                Toast toast = Toast.makeText(getApplicationContext(), "Order success", Toast.LENGTH_SHORT);
                toast.show();

                et.setText("");

            }
        });

        Button back = findViewById(R.id.buttonOrderMore);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quantity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}