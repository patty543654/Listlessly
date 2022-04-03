package com.example.listlessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView l1 = findViewById(R.id.listSelection1);
        TextView l2 = findViewById(R.id.listSelection2);
        TextView l3 = findViewById(R.id.listSelection3);
        TextView l4 = findViewById(R.id.listSelection4);
        TextView l5 = findViewById(R.id.listSelection5);
        String content = readFromFile("listName.txt");
        if (content != null) {
            List<String> items = Arrays.asList(content.split("\\s*<>\\s*"));
            l1.setText(items.get(0));
            if (items.size() > 2) {
                l2.setText(items.get(2));
            }
            if (items.size() > 4) {
                l3.setText(items.get(4));
            }

        }



        //l2.setText(items.get(1));
    }

    public void homeToAdd(View view) {
        Intent switchActivity = new Intent(this, ListCreation.class); //create intent for ListCreation
        startActivity(switchActivity);//switching to other activity
    }

    public void homeToSettings(View view) {
        String content = readFromFile("listNames.txt");
        List<String> items = Arrays.asList(content.split("\\s*<>\\s*"));

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

    public void homeToEdit(View view) {

        String content = readFromFile("file.txt");
        List<String> items = Arrays.asList(content.split("\\s*<>\\s*"));
        TextView t = findViewById(R.id.listCreateTitle);
        t.setText(items.get(0));
    }

    public void listItem1Clicked(View view) {
        String content = readFromFile("listName.txt");
        List<String> items = Arrays.asList(content.split("\\s*<>\\s*"));
        Intent switchActivity = new Intent(this, ListInUse.class); //create intent for tictactoe
        switchActivity.putExtra("key", items.get(1));//placing the userID in the new intent
        startActivity(switchActivity);//switching to other activity
    }

    public void listItem2Clicked(View view) {

        String content = readFromFile("listName.txt");
        List<String> items = Arrays.asList(content.split("\\s*<>\\s*"));

        Intent switchActivity = new Intent(this, ListInUse.class); //create intent for tictactoe
        switchActivity.putExtra("key",items.get(3));//placing the userID in the new intent
        startActivity(switchActivity);//switching to other activity
    }
}