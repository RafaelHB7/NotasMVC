package com.example.notasmvc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.notasmvc.modelo.Nota;

import java.util.ArrayList;

public class NotaAdapter extends ArrayAdapter<Nota> {
    Context mContext;
    int mResource;

    public NotaAdapter(Context context, int resource, ArrayList<Nota> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView texto = convertView.findViewById(R.id.textView);

        Nota nota = getItem(position);

        texto.setText(nota.getTitulo());

        return convertView;
    }
}
