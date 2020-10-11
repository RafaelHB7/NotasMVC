package com.example.notasmvc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notasmvc.controlador.NotaControlador;

public class EditarNotaActivity extends AppCompatActivity {

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

    @Override
    protected void onStart() {
        super.onStart();
        etTitulo.setText("Rafael");
    }

    public void salvarNota(View v){

    }
}
