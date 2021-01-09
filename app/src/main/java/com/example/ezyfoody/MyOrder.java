package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Vector;

public class MyOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        Intent intent = getIntent();

        TextView totalprice = findViewById(R.id.textViewTotalPrice);
        totalprice.setText("Total Price: Rp. "+Runner.totalPrice());

        TextView moneynow = findViewById(R.id.textViewMoneyNow);
        moneynow.setText("Current Funds: Rp. "+ Runner.money);

        int length = Runner.orderlist.size();

        TableLayout table = new TableLayout(this);

        for(int i=0; i<length; i++){
            final int x = i;
            TableRow tr = new TableRow(MyOrder.this);
            tr.setPadding(20, 10, 50, 10);
            TextView menuItem = new TextView(MyOrder.this);
            menuItem.setText(Runner.orderlist.get(i).getFoodName());
            tr.addView(menuItem);
            tr.setGravity(Gravity.CENTER);
            TextView itemQuantity = new TextView(MyOrder.this);
            itemQuantity.setText("  Quantity "+String.valueOf(Runner.orderlist.get(i).getQuantity()));
            tr.addView(itemQuantity);
            TextView itemPrice = new TextView(MyOrder.this);
            itemPrice.setText(" x Rp. "+String.valueOf(Runner.orderlist.get(i).getPrice()));
            tr.addView(itemPrice);
            Button buttonDelete = new Button(MyOrder.this);
            buttonDelete.setText("Hapus");
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteOrder(x);
                }
            });
            tr.addView(buttonDelete);


            table.addView(tr);
        }


        LinearLayout ll = findViewById(R.id.tableMyOrder);
        ll.addView(table);

        Button pay = findViewById(R.id.buttonPay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });
    }

    protected void deleteOrder(int i)
    {
        Runner.orderlist.remove(i);
        Toast toast = Toast.makeText(getApplicationContext(), "Menu item removed", Toast.LENGTH_SHORT);
        Intent intent = getIntent();
        startActivity(intent);
    }

    protected void pay()
    {
        if(Runner.totalPrice() > Runner.money){
            Toast toast = Toast.makeText(getApplicationContext(), "Not enough money to complete payment", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Runner.money = Runner.money - Runner.totalPrice();
            Runner.transfer();
            Runner.orderlist.clear();
            Intent intent = new Intent(MyOrder.this, Maps.class);
            startActivity(intent);
        }
    }
}