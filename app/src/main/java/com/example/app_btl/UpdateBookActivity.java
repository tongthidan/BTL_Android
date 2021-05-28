package com.example.app_btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.app_btl.DB.SQLiteBook;
import com.example.app_btl.Model.Book;

public class UpdateBookActivity extends AppCompatActivity {
    EditText editTextName, editTextMota, editTextTien, editID;
    AutoCompleteTextView loaiSach;
    Spinner spinnerAnh;
    ImageView anhSach;
    Button btnUpdateBook, btnDeleteBook;
    int idAnhSach;
    SQLiteBook sqLiteBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);
        editTextName = findViewById(R.id.addBook_name);
        editTextMota = findViewById(R.id.addBook_des);
        editTextTien = findViewById(R.id.addBook_price);
        editID = findViewById(R.id.book_Id);
        loaiSach = findViewById(R.id.addBook_type);
        spinnerAnh = findViewById(R.id.spinnerAnh);
        anhSach = findViewById(R.id.addBook_img);
        btnUpdateBook = findViewById(R.id.btnUpdateBook);
        btnDeleteBook = findViewById(R.id.btnDeleteBook);
        sqLiteBook = new SQLiteBook(this);

        Intent intent = getIntent();
        if (intent != null){
            Book book = (Book) intent.getSerializableExtra("book");
            Integer id = book.getId();

            editID.setText(id +"");
            editTextName.setText(book.getTenSach().toString());
            loaiSach.setText(book.getLoaiSach().toString());
            editTextMota.setText(book.getMota().toString());
            editTextTien.setText(book.getGiaSach() +"");
        }
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
        btnUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(editID.getText().toString());
                String name = editTextName.getText().toString();
                String loaisach = loaiSach.getText().toString();
                String mota = editTextMota.getText().toString();
                Double gia = Double.parseDouble(editTextTien.getText()+"");
                Book b = new Book(id,idAnhSach,name,loaisach,mota,gia);
                sqLiteBook.updateBook(b);
                System.out.println(b.getTenSach());
                finish();

            }
        });
        btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editID.getText().toString());

            }
        });
    }

}