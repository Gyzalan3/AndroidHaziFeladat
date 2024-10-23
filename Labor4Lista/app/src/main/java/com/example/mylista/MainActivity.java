package com.example.mylista;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] penznemList = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};
    String[] vasarlasList = {"4.4100", "3.9750", "6.1250", "2.9600", "3.0950", "4.2300", "0.5850", "0.0136"};
    String[] eladasList = {"4.5500", "4.1450", "6.3550", "3.0600", "3.2650", "4.3300", "0.6150", "0.0146"};
    int[] zaszlokList = {R.drawable.eur, R.drawable.usd, R.drawable.gbp,
            R.drawable.aud, R.drawable.cad, R.drawable.chf, R.drawable.dkk, R.drawable.huf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(this, zaszlokList, eladasList, vasarlasList, penznemList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String message = penznemList[position] + ": Cumpara " + vasarlasList[position] + " RON";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
