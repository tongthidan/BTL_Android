package com.example.app_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GioiThieuActivity extends AppCompatActivity {
    Button btnDangKi, btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu);
        btnDangKi = findViewById(R.id.btnDangKi);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioiThieuActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioiThieuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}