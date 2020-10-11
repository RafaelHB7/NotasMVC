package com.example.notasmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notasmvc.controlador.NotaControlador;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editarNota(view);
            }
        });
    }

    public void novaNota(View v){
        Intent intent = new Intent(this, SalvarNotaActivity.class);
        startActivity(intent);
    }

    public void excluirNota(View v){

    }

    public void editarNota(View v){
        Intent intent = new Intent(this, EditarNotaActivity.class);
        intent.putExtra("id_nota", 0);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaControlador notaControlador = new NotaControlador(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notaControlador.listaTitulosNotas()
                );

        listView.setAdapter(adapter);
    }
}