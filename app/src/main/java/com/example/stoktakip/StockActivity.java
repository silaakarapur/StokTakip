package com.example.stoktakip;


import static com.example.stoktakip.R.layout.activity_stock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import com.example.stoktakip.ui.Database.database;

import java.util.ArrayList;
import java.util.List;


public class StockActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    private EditText Urunadi, urunkategori, urunbarkod, urunstokkodu, urunmiktari, urunfiyat;
    private ListView listView;
    private Button button;
    private LinearLayout layout;

    database database = new database(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_stock);
        button = findViewById(R.id.liste);


    }

    public void kayitekle(View v) {
        database db = new database(getApplicationContext());
        Urunadi = findViewById(R.id.urunadi);
        urunkategori = findViewById(R.id.urunkategori);
        urunbarkod = findViewById(R.id.urunbarkod);
        urunstokkodu = findViewById(R.id.urunstokkodu);
        urunmiktari = findViewById(R.id.urunmiktar);
        urunfiyat = findViewById(R.id.urunfiyat);
        String adi = Urunadi.getText().toString();
        String kategori = urunkategori.getText().toString();
        String barkod = urunbarkod.getText().toString();
        String stokkodu = urunstokkodu.getText().toString();
        String miktari = urunmiktari.getText().toString();
        String fiyat = urunfiyat.getText().toString();
        db.kayitekle(adi, kategori, barkod, stokkodu, miktari, fiyat);
    }

    public void listele(View v) {

        Intent intent = new Intent(StockActivity.this,ListShowActivity.class);
        startActivity(intent);
        /*layout = findViewById(R.id.layout);
        //layout.setVisibility(View.INVISIBLE);
        list list = new list();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.stockactivity, list, "s");
        fragmentTransaction.commit();*/
    }


    public void Sil(View view) {

    }

    public void geri(View view) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment frg = fragmentManager.findFragmentById(R.id.list);
        assert frg != null;
        ft.remove(frg);
        ft.commit();


        //list list = new list();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //ft.remove(list);
        ///fragmentTransaction.commit();


    }

    /*public void verilistele(View view) {
        final ListView listView = findViewById(R.id.veriler);
        database database = new database(StockActivity.this);
        List<String> vVeriler = database.Verilistele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(StockActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, vVeriler);
        listView.setAdapter(adapter);
    }*/




}