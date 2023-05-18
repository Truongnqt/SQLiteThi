package com.example.sqlitethi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteTaxi extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Taxi.db";
    private static final String TABLE_NAME = "Taxi";
    private static final String COLUMN_ID = "SoHD";
    private static final String COLUMN_SO_XE = "Soxe";
    private static final String COLUMN_QUANG_DUONG = "QuangDuong";
    private static final String COLUMN_DON_GIA = "Dongia";
    private static final String COLUMN_KHUYEN_MAI = "Khuyenmai";

    public SQLiteTaxi(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTaxi = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_SO_XE + " TEXT, " +
                COLUMN_QUANG_DUONG + " FLOAT, " +
                COLUMN_DON_GIA + " FLOAT, " +
                COLUMN_KHUYEN_MAI + " FLOAT)";
        db.execSQL(createTableTaxi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableTaxi = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableTaxi);
        onCreate(db);
    }

    public List<ModelTaxi> getAllTaxi() {
        List<ModelTaxi> listTaxi = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String soXe = cursor.getString(cursor.getColumnIndex(COLUMN_SO_XE));
                float quangDuong = cursor.getFloat(cursor.getColumnIndex(COLUMN_QUANG_DUONG));
                float donGia = cursor.getFloat(cursor.getColumnIndex(COLUMN_DON_GIA));
                float khuyenMai = cursor.getFloat(cursor.getColumnIndex(COLUMN_KHUYEN_MAI));

                ModelTaxi taxi = new ModelTaxi(id, soXe, quangDuong, donGia, khuyenMai);
                listTaxi.add(taxi);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listTaxi;
    }

    public void addTaxi(ModelTaxi taxi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, taxi.getId());
        values.put(COLUMN_SO_XE, taxi.getSoxe());
        values.put(COLUMN_QUANG_DUONG, taxi.getQuangduong());
        values.put(COLUMN_DON_GIA, taxi.getGia());
        values.put(COLUMN_KHUYEN_MAI, taxi.getKhuyenmai());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}