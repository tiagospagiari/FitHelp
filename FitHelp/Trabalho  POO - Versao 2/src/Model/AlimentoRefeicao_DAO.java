/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class AlimentoRefeicao_DAO {

    private AlimentoRefeicao[] alimentoRefeicaoArray;
    private Alimento_DAO alimentoDAO;
    private Refeicoes_DAO refeicoesDAO;

    public AlimentoRefeicao_DAO() {
        this.alimentoRefeicaoArray = null;

    }

    public AlimentoRefeicao AdicionarAlimentoRefeicao(AlimentoRefeicao alimentoRefeicao) {

        if (alimentoRefeicaoArray == null) {
            alimentoRefeicaoArray = new AlimentoRefeicao[1];
            alimentoRefeicaoArray[0] = alimentoRefeicao;
            return alimentoRefeicao;
        }
        int novoTamanho = alimentoRefeicaoArray.length + 1;
        AlimentoRefeicao[] novoArray = new AlimentoRefeicao[novoTamanho];
        for (int i = 0; i < alimentoRefeicaoArray.length; i++) {
            novoArray[i] = alimentoRefeicaoArray[i];

        }
        alimentoRefeicaoArray = novoArray;
        alimentoRefeicaoArray[alimentoRefeicaoArray.length - 1] = alimentoRefeicao;
        return alimentoRefeicao;
    }

    public AlimentoRefeicao atualizarAlimentoRefeicao(AlimentoRefeicao alimentoRefeicao) {
        for (int i = 0; i < alimentoRefeicaoArray.length; i++) {
            if (alimentoRefeicao.getIdAlimento() == alimentoRefeicaoArray[i].getIdAlimento() && alimentoRefeicao.getIdRefeicao() == alimentoRefeicaoArray[i].getIdRefeicao()) {
                alimentoRefeicaoArray[i] = alimentoRefeicao;
                return alimentoRefeicao;
            }
        }
        return null;
    }

    public boolean deletarAlimentoRefeicao(int idAlimento, int idRefeicao) {
        int indexDeletar = -1;

        for (int i = 0; i < alimentoRefeicaoArray.length; i++) {

            AlimentoRefeicao alimentoRefeicao = alimentoRefeicaoArray[i];
            if (alimentoRefeicao.getIdAlimento() == idAlimento && alimentoRefeicao.getIdRefeicao() == idRefeicao) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && alimentoRefeicaoArray.length == 1) {
            alimentoRefeicaoArray = null;
            return true;
        }
        alimentoRefeicaoArray[indexDeletar] = null;

        AlimentoRefeicao[] arrayParte1 = new AlimentoRefeicao[indexDeletar];
        AlimentoRefeicao[] arrayParte2 = new AlimentoRefeicao[alimentoRefeicaoArray.length - indexDeletar];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = alimentoRefeicaoArray[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < alimentoRefeicaoArray.length - indexDeletar; i++) {
            arrayParte2[j] = alimentoRefeicaoArray[i + indexDeletar];
            j++;
        }
        AlimentoRefeicao[] novoAlimentoRefeicao = new AlimentoRefeicao[alimentoRefeicaoArray.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novoAlimentoRefeicao[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novoAlimentoRefeicao[i + arrayParte1.length] = arrayParte2[i];
        }

        alimentoRefeicaoArray = novoAlimentoRefeicao;
        return true;
    }

    public AlimentoRefeicao buscarAlimentoRefeicaoPorId(int idAlimento, int idRefeicao) {
        AlimentoRefeicao[] alimentosRefeicao = listarAlimentoRefeicao();
        for (AlimentoRefeicao alimentoRefeicao : alimentosRefeicao) {
            if (alimentoRefeicao.getIdAlimento() == idAlimento && alimentoRefeicao.getIdRefeicao() == idRefeicao) {
                return alimentoRefeicao;
            }
        }
        return null;
    }

    public AlimentoRefeicao[] listarRefeicaoCompleta(int idRefeicao) {
        AlimentoRefeicao[] alimentosRefeicao = listarAlimentoRefeicao();
        AlimentoRefeicao[] auxAlimentoRefeicao = null;
        if(alimentoRefeicaoArray == null)
            return null;
        for (AlimentoRefeicao alimentoRefeicao : alimentosRefeicao) {
            if (alimentoRefeicao.getIdRefeicao() == idRefeicao) {
              
                if (auxAlimentoRefeicao == null) {
                    auxAlimentoRefeicao = new AlimentoRefeicao[1];
                    auxAlimentoRefeicao[0] = alimentoRefeicao;
                    continue;
                }
                int novoTamanho = auxAlimentoRefeicao.length + 1;
                AlimentoRefeicao[] novoArray = new AlimentoRefeicao[novoTamanho];
                for (int i = 0; i < auxAlimentoRefeicao.length; i++) {
                    novoArray[i] = auxAlimentoRefeicao[i];

                }
                auxAlimentoRefeicao = novoArray;
                auxAlimentoRefeicao[auxAlimentoRefeicao.length - 1] = alimentoRefeicao;

            }
        }
         
        return auxAlimentoRefeicao;
    }

    public AlimentoRefeicao[] listarAlimentoRefeicao() {

        return alimentoRefeicaoArray;
    }

}
