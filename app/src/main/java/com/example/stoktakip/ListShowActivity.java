package com.example.stoktakip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.stoktakip.ui.Database.database;

import java.util.ArrayList;

public class ListShowActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    listAdapter listadapter;
    ArrayList<String> ürünid, ürünadi, ürünkodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_show);
        recyclerView = findViewById(R.id.recyclerView);


        database db = new database(ListShowActivity.this);
        ürünid = new ArrayList<>();
        ürünadi = new ArrayList<>();
        ürünkodi = new ArrayList<>();
        storeDataInArrays();
        listadapter = new listAdapter(ListShowActivity.this, ürünid, ürünadi, ürünkodi);
        recyclerView.setAdapter(listadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListShowActivity.this));
    }

    void storeDataInArrays() {
        database db = new database(ListShowActivity.this);
        Cursor cursor = (Cursor) db.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data ", Toast.LENGTH_LONG).show();

        } else {
            while ((cursor.moveToNext())) {
                ürünid.add(cursor.getString(0));
                ürünadi.add(cursor.getString(1));
                ürünkodi.add(cursor.getString(2));
            }
        }

    }
}