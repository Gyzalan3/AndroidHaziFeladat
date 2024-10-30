package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private ArrayList<Integer> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();
        colorList = new ArrayList<>();

        itemList.add("Piros");
        itemList.add("Zöld");
        itemList.add("Sárga");

        for (int i = 0; i < itemList.size(); i++) {
            colorList.add(Color.BLACK);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(colorList.get(position));
                return textView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showColorSelectionMenu(view, position);
            }
        });
    }

    private void showColorSelectionMenu(View view, int position) {
        final String[] colors = {"Piros", "Zöld", "Sárga"};
        new AlertDialog.Builder(this)
                .setTitle("Válassz színt")
                .setItems(colors, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            colorList.set(position, Color.RED);
                            break;
                        case 1:
                            colorList.set(position, Color.GREEN);
                            break;
                        case 2:
                            colorList.set(position, Color.YELLOW);
                            break;
                    }
                    adapter.notifyDataSetChanged();
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolSort:
                Collections.sort(itemList);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.toolDelete:
                itemList.clear();
                colorList.clear();
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}