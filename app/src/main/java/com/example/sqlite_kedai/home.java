package com.example.sqlite_kedai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void btn_create(View view){
        Intent a = new Intent(home.this, MainCreate.class);
        startActivity(a);
    }
    public void btn_read(View view) {
        Intent b = new Intent(home.this, MainRead.class);
        startActivity(b);
    }
}
