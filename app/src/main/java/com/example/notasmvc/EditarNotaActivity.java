package com.example.notasmvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notasmvc.controlador.NotaControlador;
import com.example.notasmvc.modelo.Nota;

public class EditarNotaActivity extends AppCompatActivity {

    NotaControlador notaControlador;
    EditText etTitulo;
    EditText etTexto;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);

        notaControlador = new NotaControlador(getApplicationContext());

        etTitulo = findViewById(R.id.etTitulo);
        etTexto = findViewById(R.id.etTexto);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id_nota");
        NotaControlador notaControlador = new NotaControlador(this);

        Nota nota = notaControlador.getNota(id);

        etTitulo.setText(nota.getTitulo());
        etTexto.setText(nota.getTexto());
    }

    public void salvarNota(View v){
        String titulo = etTitulo.getText().toString();
        String texto = etTexto.getText().toString();

        Nota nota = new Nota(id, titulo, texto);

        NotaControlador notaControlador = new NotaControlador(this);

        notaControlador.atualizarNota(nota);
    }
}
