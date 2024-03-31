package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText search;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        search = findViewById(R.id.search);
        addbtn = findViewById(R.id.addbtn);

        // Initialize list before checking for new items
        List<Item> items = new ArrayList<Item>();

        // Receive new item data from Register activity
        if (getIntent().hasExtra("newItem")) {
            Item newItem = (Item) getIntent().getSerializableExtra("newItem");
            if (newItem != null) {
                // Add the new item to the existing list
                items.add(newItem);
            }
        }

        // Add existing items
        items.add(new Item("Restaurant1", "Lahore", "123", "Excellent", "5"));
        items.add(new Item("Restaurant2", "Islamabad", "456", "Good", "4"));
        items.add(new Item("Restaurant3", "Karachi", "789", "Good", "3"));
        items.add(new Item("Restaurant4", "Multan", "234", "normal", "4"));
        items.add(new Item("Restaurant5", "Sailkot", "567", "normal", "4"));
        items.add(new Item("Restaurant6", "Kashmir", "891", "Good", "5"));
        items.add(new Item("Restaurant7", "Hyderabad", "234", "Good", "4"));

        // Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);

        // Add a TextChangedListener to the search EditText
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = s.toString();
                if (!searchText.isEmpty()) {
                    int rating = Integer.parseInt(searchText);
                    List<Item> filteredItems = filterItemsByRating(items, rating);
                    adapter.setItems(filteredItems);
                } else {
                    adapter.setItems(items);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private List<Item> filterItemsByRating(List<Item> items, int rating) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items) {
            if (Integer.parseInt(item.getRating()) == rating) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

}