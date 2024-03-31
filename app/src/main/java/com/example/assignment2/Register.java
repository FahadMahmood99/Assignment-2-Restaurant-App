package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    ImageView backbtn;
    TextView textView;
    EditText name,location,rating,description,phone;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backbtn=findViewById(R.id.backbtn);

        textView=findViewById(R.id.textView);
        name=findViewById(R.id.name);
        location=findViewById(R.id.location);
        rating=findViewById(R.id.rating);
        phone=findViewById(R.id.phone);
        description=findViewById(R.id.description);

        register=findViewById(R.id.register);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve entered data
                String itemName = name.getText().toString();
                String itemLocation = location.getText().toString();
                String itemRating = rating.getText().toString();
                String itemDescription = description.getText().toString();
                String itemPhone = phone.getText().toString();

                // Create a new Item object with the entered data
                Item newItem = new Item(itemName, itemLocation, itemPhone, itemDescription, itemRating);

                // Pass the new item back to MainActivity
                Intent intent = new Intent(Register.this, MainActivity.class);
                intent.putExtra("newItem", newItem);
                startActivity(intent);
            }
        });


    }
}