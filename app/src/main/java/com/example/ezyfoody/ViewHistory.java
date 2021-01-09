package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        Intent intent = getIntent();

        TableLayout table = new TableLayout(this);

        Button back = findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewHistory.this, MainActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0; i<Runner.historylist.size(); i++){
            final int x = i;
            TableRow tr = new TableRow(ViewHistory.this);
            tr.setPadding(20, 10, 50, 10);
            TextView menuItem = new TextView(ViewHistory.this);
            menuItem.setText(Runner.historylist.get(x).getFoodName());
            tr.addView(menuItem);
            tr.setGravity(Gravity.CENTER);
            TextView itemQuantity = new TextView(ViewHistory.this);
            itemQuantity.setText("  Quantity "+String.valueOf(Runner.historylist.get(x).getQuantity()));
            tr.addView(itemQuantity);
            TextView itemPrice = new TextView(ViewHistory.this);
            itemPrice.setText(" x Rp. "+String.valueOf(Runner.historylist.get(x).getPrice()));
            tr.addView(itemPrice);

            table.addView(tr);
        }
    }
}