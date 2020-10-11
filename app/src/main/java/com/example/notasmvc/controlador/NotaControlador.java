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

    public Nota getNota(int id) {
        return notaDAO.getNota(id);
    }

    public void atualizarNota(Nota nota){
        notaDAO.updateNota(nota);
    }

    public void excluirNota(Nota nota) {
        notaDAO.deleteNota(nota);
    }
}
