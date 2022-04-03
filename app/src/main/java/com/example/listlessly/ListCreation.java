package com.example.listlessly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_creation);
    }

    public void createToSettings(View view) {

    }

    public void createToHome(View view) {

    }

    public void createToEdit(View view) {

    }


    public void createClicked(View view) {
        //creating variables for all fields for list entry
        EditText listName = findViewById(R.id.title);
        EditText it1 = findViewById(R.id.item1);
        EditText it2 = findViewById(R.id.item2);
        EditText it3 = findViewById(R.id.item3);
        EditText it4 = findViewById(R.id.item4);
        EditText it5 = findViewById(R.id.item5);
        EditText it6 = findViewById(R.id.item6);
        EditText it7 = findViewById(R.id.item7);
        EditText it8 = findViewById(R.id.item8);
        EditText it9 = findViewById(R.id.item9);
        EditText it10 = findViewById(R.id.item10);
        EditText it11 = findViewById(R.id.item11);
        EditText it12 = findViewById(R.id.item12);
        EditText it13 = findViewById(R.id.item13);
        EditText it14 = findViewById(R.id.item14);
        EditText it15 = findViewById(R.id.item15);
        EditText it16 = findViewById(R.id.item16);
        EditText it17 = findViewById(R.id.item17);
        EditText it18 = findViewById(R.id.item18);
        EditText it19 = findViewById(R.id.item19);
        EditText it20 = findViewById(R.id.item20);
        EditText it21 = findViewById(R.id.item21);
        EditText it22 = findViewById(R.id.item22);
        EditText it23 = findViewById(R.id.item23);
        EditText it24 = findViewById(R.id.item24);
        EditText it25 = findViewById(R.id.item25);

        ArrayList<String> shoppingList = new ArrayList<String>();

        if (listName.getText().toString() != null) {
            String l = listName.getText().toString();
            shoppingList.add(l);

        }
        if (it1.getText().toString() != null) {
            String i1 = it1.getText().toString();
            shoppingList.add(i1);
            //saveToMemory("file.txt", i1);
        }
        if (it2.getText().toString() != null) {
            String i2 = it2.getText().toString();
            shoppingList.add(i2);
        }
        if (it3.getText().toString() != null) {
            String i3 = it3.getText().toString();
            shoppingList.add(i3);
        }
        if (it4.getText().toString() != null) {
            String i4 = it4.getText().toString();
            shoppingList.add(i4);
        }
        if (it5.getText().toString() != null) {
            String i5 = it5.getText().toString();
            shoppingList.add(i5);
        }
        if (it6.getText().toString() != null) {
            String i6 = it6.getText().toString();
            shoppingList.add(i6);
        }
        if (it7.getText().toString() != null) {
            String i7 = it7.getText().toString();
            shoppingList.add(i7);
        }
        if (it8.getText().toString() != null) {
            String i8 = it6.getText().toString();
            shoppingList.add(i8);
        }
        if (it9.getText().toString() != null) {
            String i9 = it9.getText().toString();
            shoppingList.add(i9);
        }
        if (it10.getText().toString() != null) {
            String i10 = it10.getText().toString();
            shoppingList.add(i10);
        }
        if (it11.getText().toString() != null) {
            String i11 = it11.getText().toString();
            shoppingList.add(i11);
        }
        if (it12.getText().toString() != null) {
            String i12 = it12.getText().toString();
            shoppingList.add(i12);
        }
        if (it13.getText().toString() != null) {
            String i13 = it13.getText().toString();
            shoppingList.add(i13);
        }
        if (it14.getText().toString() != null) {
            String i14 = it14.getText().toString();
            shoppingList.add(i14);
        }
        if (it15.getText().toString() != null) {
            String i15 = it15.getText().toString();
            shoppingList.add(i15);
        }


        String nam = listName.getText().toString();
        String n = saveListNameToMemory(nam);


        saveToMemory(n, shoppingList);

        Intent switchActivity = new Intent(this, MainActivity.class); //create intent for ListCreation
        startActivity(switchActivity);//switching to other activity
    }

    public String saveListNameToMemory(String name) {
        File path = getApplicationContext().getFilesDir();
        String entry = readFromFile("listName.txt");
        if (entry == null) {
            entry = "";
        }

        entry = entry.concat(name);
        entry = entry.concat("<>");
        List<String> names = Arrays.asList(entry.split("\\s*<>\\s*"));
        String fileName = "list" + ((names.size()-1) / 2) + ".txt";
        entry = entry.concat(fileName);
        entry = entry.concat("<>");
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, "listName.txt"));
            writer.write(entry.getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public void saveToMemory(String file, ArrayList<String> shoppingL) {
        File path = getApplicationContext().getFilesDir();
        String entry = "";

        for (String s : shoppingL) {
            entry = entry.concat(s);
            entry = entry.concat("<>");
        }
            try {
                FileOutputStream writer = new FileOutputStream(new File(path, file));
                writer.write(entry.getBytes());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
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