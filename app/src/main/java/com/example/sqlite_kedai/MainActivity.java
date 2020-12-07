package com.example.sqlite_kedai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void btn_masuk(View view) {
            Intent a = new Intent(MainActivity.this, home.class);
            startActivity(a);

    }
}
