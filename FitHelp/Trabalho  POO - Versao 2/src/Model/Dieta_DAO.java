/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Model.Dieta;

/**
 *
 * @author tiago
 */
public class Dieta_DAO {

    private Dieta[] dietas;

    public Dieta_DAO() {
        this.dietas = null;
    }

    public Dieta adicionarDieta(Dieta dieta) {

        if (dietas == null) {
            dietas = new Dieta[1];
            dietas[0] = dieta;
            return dieta;
        }
        int novoTamanho = dietas.length + 1;
        Dieta[] novoArray = new Dieta[novoTamanho];
        for (int i = 0; i < dietas.length; i++) {
            novoArray[i] = dietas[i];

        }
        dietas = novoArray;
        dietas[dietas.length - 1] = dieta;
        return dieta;
    }

    public Dieta lerDieta(int id) {
        for (Dieta dieta : dietas) {
            if (dieta.getId() == id) {
                return dieta;
            }
        }
        return null;
    }

    public void atualizarDieta(Dieta dietaAtualizada) {
        for (int i = 0; i < dietas.length; i++) {
            Dieta dieta = dietas[i];
            if (dieta.getId() == dietaAtualizada.getId()) {
                dietas[i] = dietaAtualizada;
                return; // Sai do loop após encontrar a dieta
            }
        }
    }

    public Dieta listarDietaPorId(int id) {
        Dieta[] dietas = listarDietas();
       for (Dieta dieta : dietas) {
            if (dieta.getId() == id) {
                return dieta;
            }
        }
        return null;
    }

    public boolean excluirDieta(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < dietas.length; i++) {

            Dieta dieta = dietas[i];
            if (dieta.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && dietas.length == 1) {
            dietas = null;
            return true;
        }
        dietas[indexDeletar] = null;

        Dieta[] arrayParte1 = new Dieta[indexDeletar];
        Dieta[] arrayParte2 = new Dieta[dietas.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = dietas[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < dietas.length; i++) {
            arrayParte2[j] = dietas[i];
            j++;
        }
        Dieta[] novaDieta = new Dieta[dietas.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novaDieta[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novaDieta[i + arrayParte1.length] = arrayParte2[i];
        }

        dietas = novaDieta;

        return true;
    }

    public Dieta[] listarDietas() {
        return dietas;
    }
}
