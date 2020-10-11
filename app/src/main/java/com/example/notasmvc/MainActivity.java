package com.example.notasmvc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notasmvc.controlador.NotaControlador;
import com.example.notasmvc.modelo.Nota;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int notaId;
    Nota notaExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nota dados = (Nota) parent.getItemAtPosition(position);
                notaId = dados.getId();
                editarNota(view);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Nota dados = (Nota) parent.getItemAtPosition(position);
                notaExcluir = dados;
                excluirNota(view);
                return true;
            }
        });
    }

    public void novaNota(View v){
        Intent intent = new Intent(this, SalvarNotaActivity.class);
        startActivity(intent);
    }

    public void excluirNota(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Excluir?");
        alertDialog.setMessage("Você tem certeza que deseja excluir?");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        NotaControlador notaControlador = new NotaControlador(getBaseContext());

                        notaControlador.excluirNota(notaExcluir);

                        mostrarNotas();
                    }
                });
        alertDialog.show();
    }

    public void editarNota(View v){
        Intent intent = new Intent(this, EditarNotaActivity.class);
        intent.putExtra("id_nota", notaId);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mostrarNotas();
    }

    public void mostrarNotas(){
        NotaControlador notaControlador = new NotaControlador(this);

        NotaAdapter notaAdapter = new NotaAdapter(
                getApplicationContext(),
                R.layout.nota,
                notaControlador.getListaNotas()
        );

        listView.setAdapter(notaAdapter);
    }
}