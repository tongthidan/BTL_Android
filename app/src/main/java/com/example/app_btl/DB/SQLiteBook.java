package com.example.app_btl.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.app_btl.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class SQLiteBook  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "KHOSACH.db";
    private static final int DATABASE_VERSION = 1;
    public SQLiteBook(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE book (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "imgBook INTEGER,"+
                "nameBook TEXT," +
                "loaiBook TEXT," +
                "moTa TEXT," +
                "gia REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long addBook(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgBook", book.getAnhSach());
        contentValues.put("nameBook", book.getTenSach());
        contentValues.put("loaiBook", book.getLoaiSach());
        contentValues.put("moTa", book.getMota());
        contentValues.put("gia", book.getGiaSach());


        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("book", null, contentValues);
    }
    public int updateBook(Book book) {
        String whereClause = "id = ?";
        String[] whereArgs = {Integer.toString(book.getId())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("imgBook", book.getAnhSach());
        contentValues.put("nameBook", book.getTenSach());
        contentValues.put("loaiBook", book.getLoaiSach());
        contentValues.put("moTa", book.getMota());
        contentValues.put("gia", book.getGiaSach());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.update("book", contentValues, whereClause, whereArgs);
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("book", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            int idAnh = cursor.getInt(1);
            String nameBook = cursor.getString(2);
            String loaiBook = cursor.getString(3);
            String moTa = cursor.getString(4);
            Double gia = cursor.getDouble(5);
            list.add(new Book(id,idAnh,nameBook,loaiBook,moTa,gia));
        }
        return list;
    }

//    public QuyenGop getFundByID(int id) {
//        String whereClause = "id = ?";
//        String[] whereArgs = {Integer.toString(id)};
//        QuyenGop fund = null;
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.query("quyengop", null, whereClause, whereArgs, null, null, null);
//        if (cursor != null && cursor.moveToNext()) {
//            String name = cursor.getString(1);
//            String city = cursor.getString(2);
//            String day = cursor.getString(3);
//            double money = cursor.getDouble(4);
//            fund = new QuyenGop(id, name, city, day, money);
//        }
//        return fund;
//    }
//
//    public int deleteFund(int id) {
//        String whereClause = "id = ?";
//        String[] whereArgs = {Integer.toString(id)};
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        return sqLiteDatabase.delete("quyengop", whereClause, whereArgs);
//    }
//


    public List<Book> searchByName(String key) {
        List<Book> list = new ArrayList<>();
        String whereClause = "nameBook like ?";
        String[] whereArgs = {"%" + key + "%"};
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("book", null, whereClause, whereArgs, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            int idAnh = cursor.getInt(1);
            String nameBook = cursor.getString(2);
            String loaiBook = cursor.getString(3);
            String moTa = cursor.getString(4);
            Double gia = cursor.getDouble(5);
            list.add(new Book(id,idAnh,nameBook,loaiBook,moTa,gia));
        }
        return list;
    }
}
