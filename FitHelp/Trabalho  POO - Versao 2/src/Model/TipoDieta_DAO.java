/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class TipoDieta_DAO {

    private TipoDieta[] tiposDieta;

    public TipoDieta_DAO() {
       this.tiposDieta = null;

    }

    public TipoDieta adicionarTipoDieta(TipoDieta tipoDieta) {

       if (tiposDieta == null) {
            tiposDieta = new TipoDieta[1];
            tiposDieta[0] = tipoDieta;
            return tipoDieta;
        }
        int novoTamanho = tiposDieta.length + 1;
       TipoDieta[] novoArray = new TipoDieta[novoTamanho];
        for (int i = 0; i < tiposDieta.length; i++) {
            novoArray[i] = tiposDieta[i];

        }
        tiposDieta = novoArray;
        tiposDieta[tiposDieta.length - 1] =tipoDieta;
        return tipoDieta;
    }

    public TipoDieta atualizarTipoAlimento(TipoDieta tipoDietaAtualizado) {
        for (int i = 0; i < tiposDieta.length; i++) {
            TipoDieta tipoDieta = tiposDieta[i];
            if (tipoDieta.getId() == tipoDietaAtualizado.getId()) {
                tiposDieta[i] = tipoDietaAtualizado;
                return tipoDietaAtualizado;
            }
        }
        return null;
    }

    public TipoDieta lerTipoDieta(int id) {
        for (TipoDieta tipoDieta : tiposDieta) {
            if (tipoDieta.getId() == id) {
                return tipoDieta;
            }
        }
        return null;
    }

    public void atualizarTipoDieta(TipoDieta tipoDietaAtualizado) {
        for (int i = 0; i < tiposDieta.length; i++) {
            TipoDieta tipoDieta = tiposDieta[i];
            if (tipoDieta.getId() == tipoDietaAtualizado.getId()) {
                tiposDieta[i] = tipoDietaAtualizado;
                return;
            }
        }
    }

    public boolean deletarTipoDieta(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < tiposDieta.length; i++) {

            TipoDieta tiposDietas = tiposDieta[i];
            if (tiposDietas.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if(indexDeletar != -1 && tiposDieta.length == 1) {
            tiposDieta = null;
            return true;
        }
        tiposDieta[indexDeletar] = null;

       TipoDieta[] arrayParte1 = new TipoDieta[indexDeletar];
       TipoDieta[] arrayParte2 = new TipoDieta[tiposDieta.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = tiposDieta[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < tiposDieta.length; i++) {
            arrayParte2[j] = tiposDieta[i];
            j++;
        }
        TipoDieta[] novaDieta = new TipoDieta[tiposDieta.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novaDieta[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novaDieta[i + arrayParte1.length] = arrayParte2[i];
        }

        tiposDieta = novaDieta;

        return true;
    }

    public TipoDieta[] listarTiposDieta() {
        return tiposDieta;
    }
}
