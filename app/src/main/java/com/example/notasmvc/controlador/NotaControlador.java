package com.example.notasmvc.controlador;

import android.content.Context;

import com.example.notasmvc.modelo.Nota;
import com.example.notasmvc.modelo.NotaDAO;

import java.util.ArrayList;

public class NotaControlador {

    Context context;
    NotaDAO notaDAO;

    public NotaControlador(Context c) {
        context = c;
        notaDAO = new NotaDAO(c);
    }

    public Nota cadastrarNovaNota(Nota nota){
        return notaDAO.inserirNota(nota);
    }

    public ArrayList<Nota> getListaNotas(){
        return notaDAO.getListaNotas();
    }

    public ArrayList<String> listaTitulosNotas(){
        ArrayList<String> resultado = new ArrayList<>();

        for (Nota nota: this.getListaNotas()) {
            resultado.add(nota.getTitulo());
        }

        return  resultado;
    }
}
