package com.example.app_btl;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_btl.DB.SQLiteBook;
import com.example.app_btl.Model.Book;

public class AddBookActivity extends AppCompatActivity {
    EditText editTextName, editTextMota, editTextTien;
    AutoCompleteTextView loaiSach;
    Spinner spinnerAnh;
    ImageView anhSach;
    Button btnaddBook, btnBack;
    int idAnhSach;
    SQLiteBook sqLiteBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        editTextName = findViewById(R.id.addBook_name);
        editTextMota = findViewById(R.id.addBook_des);
        editTextTien = findViewById(R.id.addBook_price);
        loaiSach = findViewById(R.id.addBook_type);
        spinnerAnh = findViewById(R.id.spinnerAnh);
        anhSach = findViewById(R.id.addBook_img);
        btnaddBook = findViewById(R.id.btnAddBook);
        btnBack = findViewById(R.id.btnBack);
        sqLiteBook = new SQLiteBook(this);
        String[] st = getResources().getStringArray(R.array.type_book);
        loaiSach.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, st));
        spinnerAnh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        idAnhSach = R.drawable.matbiec;
                        anhSach.setImageResource(R.drawable.matbiec);
                        break;
                    case 1:
                        idAnhSach = R.drawable.neunhuyeu;
                        anhSach.setImageResource(R.drawable.neunhuyeu);
                        break;
                    case 2:
                        idAnhSach = R.drawable.lichsuvietnam;
                        anhSach.setImageResource(R.drawable.lichsuvietnam);
                        break;
                    case 3:
                        idAnhSach = R.drawable.nhagiakim;
                        anhSach.setImageResource( R.drawable.nhagiakim);
                        break;
                    default:
                        idAnhSach = R.drawable.motduatrechaytron;
                        anhSach.setImageResource(R.drawable.motduatrechaytron);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnaddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int idAnh = spinnerAnh.getId();
                String name = editTextName.getText().toString();
                String loaisach = loaiSach.getText().toString();
                String mota = editTextMota.getText().toString();
                long gia = Long.parseLong(editTextTien.getText().toString());
                Book b = new Book(idAnhSach,name,loaisach,mota,gia);
                //
                sqLiteBook.addBook(b);
                System.out.println(b.getTenSach());
                finish();


            }
        });



    }
}