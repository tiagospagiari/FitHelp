/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author tiago
 */
public class IdNext {

    private static int[] postIds = new int[0];
    private static int[] pessoaIds = new int[0];
    private static int[] alimentoIds = new int[0];
    private static int[] refeicoesIds = new int[0];
    private static int[] avaliacaoIds = new int[0];
    private static int[] dietaIds = new int[0];
    private static int[] mensagensIds = new int[0];
    private static int[] seguirIds = new int[0];
    private static int[] prefIds = new int[0];

    public static int getNextIdPost() {

        int nextId = postIds.length;
        postIds = Arrays.copyOf(postIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdPessoa() {
        int nextId = pessoaIds.length;
        pessoaIds = Arrays.copyOf(pessoaIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdAlimento() {
        int nextId = alimentoIds.length;
        alimentoIds = Arrays.copyOf(alimentoIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdRefeicoes() {
        int nextId = refeicoesIds.length;
        refeicoesIds = Arrays.copyOf(refeicoesIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdAvaliacoes() {
        int nextId = avaliacaoIds.length;
        avaliacaoIds = Arrays.copyOf(avaliacaoIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdDieta() {
        int nextId = dietaIds.length;
        dietaIds = Arrays.copyOf(dietaIds, nextId + 1);
        return nextId;
    }

    public static int getNextIdMensagens() {
        int nextId = mensagensIds.length;
        mensagensIds = Arrays.copyOf(mensagensIds, nextId + 1);
        return nextId;
    }
    public static int getNextIdseguidores() {
        int nextId = seguirIds.length;
        seguirIds = Arrays.copyOf(seguirIds, nextId + 1);
        return nextId;
    }
    public static int getNextIdpref() {
        int nextId = prefIds.length;
        prefIds = Arrays.copyOf(prefIds, nextId + 1);
        return nextId;
    }

    
}
