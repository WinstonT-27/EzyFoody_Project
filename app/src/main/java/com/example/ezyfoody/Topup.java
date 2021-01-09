package com.example.ezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Topup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        final Intent intent = getIntent();

        TextView moneynow = findViewById(R.id.textViewMoneyNow);
        moneynow.setText("Current Funds: Rp. "+ Runner.money);

        Button button = findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = findViewById(R.id.editTextTopUp);
                int value = Integer.parseInt(String.valueOf(et.getText()));
                if(et.getText().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Input amount", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(value >= 2000000){
                    Toast toast = Toast.makeText(getApplicationContext(), "Maximum top Rp. 2000000", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Runner.money = Runner.money + value;
                    Toast toast = Toast.makeText(getApplicationContext(), "Top up success", Toast.LENGTH_SHORT);
                    toast.show();
                }

                et.setText("");
            }
        });

        Button back = findViewById(R.id.buttonGoBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Topup.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}