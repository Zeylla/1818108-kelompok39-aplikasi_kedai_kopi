package com.example.sqlite_kedai;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_sastro";
    private static final String tb_kedai = "tb_kedai";
    private static final String tb_kdi_id = "id";
    private static final String tb_kdi_nama = "nama";
    private static final String tb_kdi_harga = "harga";
    private static final String CREATE_TABLE_KEDAI = "CREATE TABLE " +
            tb_kedai + "("
            + tb_kdi_id + " INTEGER PRIMARY KEY ,"
            + tb_kdi_nama + " TEXT,"
            + tb_kdi_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KEDAI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateMahasiswa (Kedai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kdi_id, mdNotif.get_id());
        values.put(tb_kdi_nama, mdNotif.get_nama());
        values.put(tb_kdi_harga, mdNotif.get_harga());
        db.insert(tb_kedai, null, values);
        db.close();
    }

    public List<Kedai> ReadKedai() {
        List<Kedai> judulModelList = new ArrayList<Kedai>();
        String selectQuery = "SELECT * FROM " + tb_kedai;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kedai mdKontak = new Kedai();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_harga(cursor.getString(2));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateKedai (Kedai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kdi_nama, mdNotif.get_nama());
        values.put(tb_kdi_harga, mdNotif.get_harga());
        return db.update(tb_kedai, values, tb_kdi_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteKedai (Kedai mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kedai, tb_kdi_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

