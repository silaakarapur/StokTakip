package com.example.stoktakip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    ImageButton imagebutton;
    private Context getContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }




    public void git(View view) {
        Intent git = new Intent(MenuActivity.this,StockActivity.class);
        startActivity(git);
    }
}