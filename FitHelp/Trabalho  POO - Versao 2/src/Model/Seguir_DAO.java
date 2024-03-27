/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class Seguir_DAO {

    private Seguir[] seguir;

    public Seguir_DAO() {
        this.seguir = null;
    }

    public Seguir AdicionarPessoaParaSeguir(Seguir seguirP) {

        if (seguir == null) {
            seguir = new Seguir[1];
            seguir[0] = seguirP;
            return seguirP;
        }
        int novoTamanho = seguir.length + 1;
        Seguir[] novoArray = new Seguir[novoTamanho];
        for (int i = 0; i < seguir.length; i++) {
            novoArray[i] = seguir[i];

        }
        seguir = novoArray;
        seguir[seguir.length - 1] = seguirP;
        return seguirP;
    }

    public Seguir[] listarSeguidores() {

        return seguir;
    }

    public boolean deixarSeguir(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < seguir.length; i++) {

            Seguir seguidor = seguir[i];
            if (seguidor.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && seguir.length == 1) {
            seguir = null;
            return true;
        }
        seguir[indexDeletar] = null;

        Seguir[] arrayParte1 = new Seguir[indexDeletar];
        Seguir[] arrayParte2 = new Seguir[seguir.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = seguir[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < seguir.length; i++) {
            arrayParte2[j] = seguir[i];
            j++;
        }
        Seguir[] novoSeguidor = new Seguir[seguir.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novoSeguidor[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novoSeguidor[i + arrayParte1.length] = arrayParte2[i];
        }

        seguir = novoSeguidor;

        return true;
    }

}
