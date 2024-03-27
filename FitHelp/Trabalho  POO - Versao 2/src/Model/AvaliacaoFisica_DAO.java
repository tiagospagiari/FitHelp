/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class AvaliacaoFisica_DAO {

    private AvaliacaoFisica[] avaliacoesFisicas;

    public AvaliacaoFisica_DAO() {
        this.avaliacoesFisicas = null;
//        
//    }
//      public int determinarNovoID(AvaliacaoFisica avaliacoesFisicas) {
//    int novoID = 1; // O novo ID padrão é 1
//
//    for (AvaliacaoFisica avaliacao : avaliacoesFisicas) {
//        if (avaliacao.getId() >= novoID) {
//            novoID = avaliacao.getId() + 1;
//        }
//    }

//        return novoID;
    }

    public AvaliacaoFisica adicionarAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {

        if (avaliacoesFisicas == null) {
            avaliacoesFisicas = new AvaliacaoFisica[1];
            avaliacoesFisicas[0] = avaliacaoFisica;
            return avaliacaoFisica;
        }
        int novoTamanho = avaliacoesFisicas.length + 1;
        AvaliacaoFisica[] novoArray = new AvaliacaoFisica[novoTamanho];
        for (int i = 0; i < avaliacoesFisicas.length; i++) {
            novoArray[i] = avaliacoesFisicas[i];

        }
        avaliacoesFisicas = novoArray;
        avaliacoesFisicas[avaliacoesFisicas.length - 1] = avaliacaoFisica;
        return avaliacaoFisica;
    }

    public AvaliacaoFisica[] listarAvaliacoesFisicas() {
//    
    return avaliacoesFisicas;
    }
    
    
    public AvaliacaoFisica listarAvaliacaoFisicaPorId(int id) {
        AvaliacaoFisica[] avaliacoesFisicas = listarAvaliacoesFisicas();
        for (AvaliacaoFisica avaliacaoFisica : avaliacoesFisicas) {
            if (avaliacaoFisica.getId() == id) {
                return avaliacaoFisica;
            }
        }
        return null;
    }

    private int obterProximoIndex(AvaliacaoFisica[] avaliacao) {
        for (int i = 0; i < avaliacao.length; i++) {
            if (avaliacao[i] == null) {
                return i;
            }
        }
        return 0;

    }

    public boolean atualizarAvaliacaoFisica(int id, AvaliacaoFisica novaAvaliacaoFisica) {

        for (int i = 0; i < avaliacoesFisicas.length; i++) {
            if (avaliacoesFisicas[i].getId() == id) {
                avaliacoesFisicas[i] = novaAvaliacaoFisica;
                return true;
            }
        }
        return false;
    }
//

    public boolean deletarAvalicaoFisicaPorId(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < avaliacoesFisicas.length; i++) {

            AvaliacaoFisica avaliacaoFisica = avaliacoesFisicas[i];
            if (avaliacaoFisica.getId() == id) {
                indexDeletar = i;
            }

        }
        
        if (indexDeletar == -1) {
            return false;
        }
        if(indexDeletar != -1 && avaliacoesFisicas.length == 1) {
            avaliacoesFisicas = null;
            return true;
        }
        avaliacoesFisicas[indexDeletar] = null;

        AvaliacaoFisica[] arrayParte1 = new AvaliacaoFisica[indexDeletar];
        AvaliacaoFisica[] arrayParte2 = new AvaliacaoFisica[avaliacoesFisicas.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = avaliacoesFisicas[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < avaliacoesFisicas.length; i++) {
            arrayParte2[j] = avaliacoesFisicas[i];
            j++;
        }
        AvaliacaoFisica[] novoAvaliacaoFisica = new AvaliacaoFisica[avaliacoesFisicas.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novoAvaliacaoFisica[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novoAvaliacaoFisica[i + arrayParte1.length] = arrayParte2[i];
        }

        avaliacoesFisicas = novoAvaliacaoFisica;

        return true;
    }
//    AvaliacaoFisica[] avaliacoesDaPessoa = new AvaliacaoFisica[20];
//
//        if (avaliacoesFisicas == null) {
//            System.out.println("Avaliação Física não encontrada");
//            return null;
//        }
//
//        int index = 0;
//
//        for (AvaliacaoFisica avaliacao : avaliacoesFisicas) {
//            if (avaliacao != null && avaliacao.getPessoa().getId() == pessoaId) {
//                if (index < avaliacoesDaPessoa.length) {
//                    avaliacoesDaPessoa[index] = avaliacao;
//                    index++;
//                } else {
//                    System.out.println("O vetor de avaliações está cheio.");
//                    break;
//                }
//            }
//        }
//
//        for (AvaliacaoFisica avaliacao : avaliacoesDaPessoa) {
//            if (avaliacao != null) {
//                System.out.println(avaliacao.toString());
//            }
//        }
//
//        return avaliacoesDaPessoa;
}
