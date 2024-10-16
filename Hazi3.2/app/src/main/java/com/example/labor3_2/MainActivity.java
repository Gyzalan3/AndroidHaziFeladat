package com.example.labor3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText productCode = findViewById(R.id.edtTextCode);
        EditText productName = findViewById(R.id.edtTextName);
        EditText productPrice = findViewById(R.id.edtTextPrice);
        Button addProduct = findViewById(R.id.btnAddProduct);
        Button cancel = findViewById(R.id.btnCancel);
        Button showProducts = findViewById(R.id.btnShowProduct);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = productCode.getText().toString();
                String name = productName.getText().toString();
                String price = productPrice.getText().toString();

                Product product = new Product(code,name,price);

                products.add(product);

                Toast.makeText(MainActivity.this, "Succesfully added new product!", Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productCode.setText("");
                productName.setText("");
                productPrice.setText("");
            }
        });

        showProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("products", products);
                startActivity(intent);
            }
        });

    }
}