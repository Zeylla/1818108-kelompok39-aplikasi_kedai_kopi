package com.example.sqlite_kedai;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Kedai> ListKedai = new ArrayList<Kedai>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListKedai );
        mListView = (ListView) findViewById(R.id.list_kedai);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKedai.clear();
        List<Kedai> contacts = db.ReadKedai();
        for (Kedai cn : contacts) {
            Kedai judulModel = new Kedai();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_harga(cn.get_harga());
            ListKedai.add(judulModel);
            if ((ListKedai.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Kedai obj_itemDetails = (Kedai)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iharfa", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKedai.clear();
        mListView.setAdapter(adapter_off);
        List<Kedai> contacts = db.ReadKedai();
        for (Kedai cn : contacts) {
            Kedai judulModel = new Kedai();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_harga(cn.get_harga());
            ListKedai.add(judulModel);
            if ((ListKedai.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

