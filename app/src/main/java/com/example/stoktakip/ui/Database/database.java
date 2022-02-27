package com.example.stoktakip.ui.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sqllite_database";
    private static final String TABLE_NAME = "Stoklar";
    private static String ÜRÜN_ID = "İD";
    private static String ÜRÜN_ADİ = "ad";
    private static String ÜRÜN_KATEGORİ = "kategori";
    private static String ÜRÜN_BARKOD = "barkod";
    private static String ÜRÜN_STOKKODU = "stokkodu";
    private static String ÜRÜN_MİKTAR = "miktar";
    private static String ÜRÜN_FİYAT = "fiyat";

    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + ÜRÜN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ÜRÜN_ADİ + " TEXT,"
                + ÜRÜN_KATEGORİ + " TEXT,"
                + ÜRÜN_BARKOD + " TEXT,"
                + ÜRÜN_STOKKODU + " TEXT,"
                + ÜRÜN_MİKTAR + " TEXT,"
                + ÜRÜN_FİYAT + " TEXT"+ ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void kayitekle(String ürünadi ,String ürünkategori,String ürünbarkod,String ürünstokkodu,String ürünmiktar,String ürünfiyat){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
cv.put(ÜRÜN_ADİ,ürünadi);
        cv.put(ÜRÜN_KATEGORİ,ürünkategori);
        cv.put(ÜRÜN_BARKOD,ürünbarkod);
        cv.put(ÜRÜN_STOKKODU,ürünstokkodu);
        cv.put(ÜRÜN_MİKTAR,ürünmiktar);
        cv.put(ÜRÜN_FİYAT,ürünfiyat);
        db.insert(TABLE_NAME,null,cv);
        db.close();

    }
   public List<String> Verilistele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sütunlar = {ÜRÜN_ID,ÜRÜN_ADİ,ÜRÜN_KATEGORİ,ÜRÜN_BARKOD,ÜRÜN_STOKKODU,ÜRÜN_MİKTAR,ÜRÜN_FİYAT};
        Cursor cursor = db.query(TABLE_NAME,sütunlar,null,null,null,null,null);
        while (cursor.moveToNext()){
veriler.add(cursor.getInt(0)+"-"+cursor.getString(1)+ "-"+cursor.getString(2)+"-"+(cursor.getInt(3)+ "-"+cursor.getString(4))+"-"+cursor.getDouble(5)+"-"+cursor.getDouble(6));
        }
        return veriler;
   }
   public void verisil(String veri){
       SQLiteDatabase db = getWritableDatabase();
       db.delete(ÜRÜN_ID, TABLE_NAME, null);
   }
}
