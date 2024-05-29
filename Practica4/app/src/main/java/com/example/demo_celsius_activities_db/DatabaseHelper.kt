package com.example.demo_celsius_activities_db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONVERSION_TABLE = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_CONVERSION TEXT," +
                "$COLUMN_RESULT REAL)")
        db.execSQL(CREATE_CONVERSION_TABLE)
    }



    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //Insertar datos en la db
    fun addConversionResult(result: Double, conversion: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_RESULT, result)
        values.put(COLUMN_CONVERSION, conversion)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }


    @SuppressLint("Range")

    fun getAllResults(): List<Triple<String, Int, Double>> {
        val resultList = mutableListOf<Triple<String, Int, Double>>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT $COLUMN_CONVERSION, $COLUMN_ID, $COLUMN_RESULT FROM $TABLE_NAME ORDER BY $COLUMN_ID", null)
        cursor.use {
            while (cursor.moveToNext()) {
                val conversion = cursor.getString(cursor.getColumnIndex(COLUMN_CONVERSION))
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val result = cursor.getDouble(cursor.getColumnIndex(COLUMN_RESULT))
                resultList.add(Triple(conversion, id, result))
            }
        }
        cursor.close()
        return resultList
    }


    companion object {
        private const val DATABASE_VERSION = 3
        private const val DATABASE_NAME = "conversiones.db"
        private const val TABLE_NAME = "conversion_temperatura"
        private const val COLUMN_ID = "id"
        private const val COLUMN_RESULT = "resultado"
        private const val COLUMN_CONVERSION = "conversion"
    }
}
