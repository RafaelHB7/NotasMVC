package com.example.notasmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notasmvc.controlador.NotaControlador;
import com.example.notasmvc.modelo.Nota;

public class SalvarNotaActivity extends AppCompatActivity {

    NotaControlador notaControlador;
    EditText etTitulo;
    EditText etTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);

        notaControlador = new NotaControlador(getApplicationContext());

        etTitulo = findViewById(R.id.etTitulo);
        etTexto = findViewById(R.id.etTexto);
    }

    public void salvarNota(View v){
        String titulo = etTitulo.getText().toString();
        String texto = etTexto.getText().toString();
        Nota nota = notaControlador.cadastrarNovaNota(new Nota(titulo, texto));

        etTitulo.setText("");
        etTexto.setText("");
    }
}