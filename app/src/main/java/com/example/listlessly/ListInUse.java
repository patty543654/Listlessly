package com.example.listlessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ListInUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_in_use);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("key");//getting the listName from current intent
        String list = readFromFile(fileName);
        List<String> items = Arrays.asList(list.split("\\s*<>\\s*"));

        TextView title = findViewById(R.id.listUseTitle);
        title.setText(items.get(0));

        int i = 1;
        if (i < items.size()) {
            TextView t1 = findViewById(R.id.item1);
            t1.setText(items.get(i));
            i++;
        }
        if (i < items.size()) {
            TextView t2 = findViewById(R.id.item2);
            t2.setText(items.get(i));
            i++;
        }
        if (i < items.size()) {
            TextView t3 = findViewById(R.id.item3);
            t3.setText(items.get(i));
            i++;
        }
        if (i < items.size()) {
            TextView t4 = findViewById(R.id.item4);
            t4.setText(items.get(i));
            i++;
        }
        if (i < items.size()) {
            TextView t5 = findViewById(R.id.item5);
            t5.setText(items.get(i));
            i++;
        }
        if (i < items.size()) {
            TextView t6 = findViewById(R.id.item6);
            t6.setText(items.get(i));
            i++;
        }



    }

    public String readFromFile(String name) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, name);
        byte[] entry = new byte[(int) readFrom.length()];
        try {
            FileInputStream str = new FileInputStream(readFrom);
            str.read(entry);
            return new String(entry);
        } catch (IOException e) {
            e.printStackTrace();
            e.toString();
        }
        return null;
    }
}