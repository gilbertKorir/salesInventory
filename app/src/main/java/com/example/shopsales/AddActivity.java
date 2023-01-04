package com.example.shopsales;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText name_input, code_input, price_input;
    Button addButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.etName);
        code_input = findViewById(R.id.etCode);
        price_input = findViewById(R.id.etPrice);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDb = new MyDatabaseHelper(AddActivity.this);
                myDb.addProduct(name_input.getText().toString().trim(),
                                code_input.getText().toString().trim(),
                                Integer.valueOf(price_input.getText().toString().trim()));
            }
        });
    }
}