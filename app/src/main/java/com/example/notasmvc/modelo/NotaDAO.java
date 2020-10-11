package com.example.notasmvc.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {

    SQLiteDatabase database;

    public NotaDAO(Context c) {
        database = c.openOrCreateDatabase("bdNotas", c.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo VARCHAR," +
                "texto VARCHAR)");
    }

    public Nota inserirNota(Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("texto", nota.getTexto());

        int id = (int) database.insert("notas", null, contentValues);
        nota.setId(id);

        return nota;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        ArrayList<Nota> listaNotas = new ArrayList<>();

        while(!cursor.isAfterLast()){
            Nota nota = new Nota(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("titulo")),
                    cursor.getString(cursor.getColumnIndex("texto")));

            listaNotas.add(nota);

            cursor.moveToNext();
        }

        return listaNotas;
    }
}
