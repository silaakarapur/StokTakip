package com.example.stoktakip;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.example.stoktakip.ui.Database.database;
import com.example.stoktakip.ui.listfragment;

import java.util.ArrayList;
import java.util.List;


public class StockActivity extends AppCompatActivity {

    private EditText Urunadi, urunkategori, urunbarkod, urunstokkodu, urunmiktari, urunfiyat;

    private ListView listView;

    private Button button;
    private LinearLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        button = findViewById(R.id.liste);
        button.setOnClickListener(this::listele);

    }

    public void kayitekle(View v) {
        database db = new database(getApplicationContext());
        Urunadi = findViewById(R.id.urunadi);
        urunkategori = (EditText) findViewById(R.id.urunkategori);
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
int sayac=1;
       /* layout = findViewById(R.id.layout);
     getSupportFragmentManager().beginTransaction().add(R.id.layout, new listfragment()).commit();
        layout.setVisibility(View.GONE);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database db = new database(getApplicationContext());
                ListView listView;
                List<String> verilistele = db.Verilistele();
                listView = findViewById(R.id.listView);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(StockActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, verilistele);
                listView.setAdapter(adapter);
            }
        });


    }

    public void Sil(View view) {
      
    }
}