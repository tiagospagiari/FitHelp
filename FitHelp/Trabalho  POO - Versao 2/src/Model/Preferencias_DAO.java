/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.MacroNutriente;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tiago
 */
public class Preferencias_DAO {

    private Preferencias[] preferencias;

    public Preferencias_DAO() {
        this.preferencias = null;
    }
    
    

    public boolean adicionarCarboidrato(int idPreferencias, int idAlimento) {

        return adicionarAlimentoAoArray(idPreferencias, idAlimento, "Carboidrato");
    }

    public boolean adicionarProteina(int idPreferencias, int idAlimento) {
        return adicionarAlimentoAoArray(idPreferencias, idAlimento, "Proteina");
    }

    public boolean adicionarGordura(int idPreferencias, int idAlimento) {
        return adicionarAlimentoAoArray(idPreferencias, idAlimento, "Gordura");
    }

    private boolean adicionarAlimentoAoArray(int idPreferencias, int idAlimento, String macroNutriente) {
        Preferencias pref = buscarPreferenciaPorId(idPreferencias);

        switch (macroNutriente) {
            case "Carboidrato":

                if (pref.getIdAlimentoPrefCarb() == null) {
                    int[] novoCarb = new int[1];
                    novoCarb[0] = idAlimento;
                    pref.setIdAlimentoPrefCarb(novoCarb);
                    return true;
                } else {
                    int novoTamanho = pref.getIdAlimentoPrefCarb().length + 1;
                    int[] novoArray = new int[novoTamanho];
                    for (int i = 0; i < pref.getIdAlimentoPrefCarb().length; i++) {
                        novoArray[i] = pref.getIdAlimentoPrefCarb()[i];

                    }
                     novoArray[novoArray.length - 1] = idAlimento;
                    pref.setIdAlimentoPrefCarb(novoArray);
                    
                    return true;
                }

                

            case "Proteina":

                 if (pref.getIdAlimentoPrefProt() == null) {
                    int[] novaProt = new int[1];
                    novaProt[0] = idAlimento;
                    pref.setIdAlimentoPrefProt(novaProt);
                    return true;
                } else {
                    int novoTamanho = pref.getIdAlimentoPrefProt().length + 1;
                    int[] novoArray = new int[novoTamanho];
                    for (int i = 0; i < pref.getIdAlimentoPrefProt().length; i++) {
                        novoArray[i] = pref.getIdAlimentoPrefProt()[i];

                    }
                     novoArray[novoArray.length - 1] = idAlimento;
                    pref.setIdAlimentoPrefProt(novoArray);
                    
                    return true;
                }
                
                
            case "Gordura":

                if (pref.getIdAlimentoPrefGord() == null) {
                    int[] novaGord = new int[1];
                    novaGord[0] = idAlimento;
                    pref.setIdAlimentoPrefGord(novaGord);
                    return true;
                } else {
                    int novoTamanho = pref.getIdAlimentoPrefProt().length + 1;
                    int[] novoArray = new int[novoTamanho];
                    for (int i = 0; i < novoArray.length; i++) {
                        novoArray[i] = pref.getIdAlimentoPrefGord()[i];

                    }
                    pref.setIdAlimentoPrefGord(novoArray);
                    pref.getIdAlimentoPrefGord()[pref.getIdAlimentoPrefGord().length - 1] = idAlimento;
                    return true;
                }
                
            default:

                break;
        }


        return false;
    }

    public Preferencias[] listarPreferencias() {
        return preferencias;
    }
    public Preferencias criarPreferencias(Preferencias preferencia) {

        if (preferencias == null) {
            preferencias = new Preferencias[1];
            preferencias[0] = preferencia;
            return preferencia;
        }
        int novoTamanho = preferencias.length + 1;
        Preferencias[] novoArray = new Preferencias[novoTamanho];
        for (int i = 0; i < preferencias.length; i++) {
            novoArray[i] = preferencias[i];

        }
        preferencias = novoArray;
        preferencias[preferencias.length - 1] = preferencia;
        return preferencia;
    }

    public Preferencias buscarPreferenciaPorId(int id) {
      
        for (Preferencias preferencia : preferencias) {
            if (preferencia.getId() == id) {
                return preferencia;
            }
        }
        return null;
    }

    // Operação UPDATE
    public boolean atualizarPreferencia(int id, Preferencias novaPreferencia) {
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i].getId() == id) {
                preferencias[i] = novaPreferencia;
                return true;
            }
        }
        return false;
    }

    // Operação DELETE
    public boolean deletarPreferencia(int id) {

int indexDeletar = -1;

        for (int i = 0; i < preferencias.length; i++) {

            Preferencias preferencia = preferencias[i];
            if (preferencia.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if(indexDeletar != -1 && preferencias.length == 1) {
            preferencias = null;
            return true;
        }
        preferencias[indexDeletar] = null;

        Preferencias[] arrayParte1 = new Preferencias[indexDeletar];
        Preferencias[] arrayParte2 = new Preferencias[preferencias.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = preferencias[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < preferencias.length; i++) {
            arrayParte2[j] = preferencias[i];
            j++;
        }
        Preferencias[] novasPreferencias = new Preferencias[preferencias.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novasPreferencias[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novasPreferencias[i + arrayParte1.length] = arrayParte2[i];
        }

        preferencias = novasPreferencias;

        return true;
    }
}
