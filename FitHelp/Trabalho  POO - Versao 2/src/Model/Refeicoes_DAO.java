/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author tiago
 */
public class Refeicoes_DAO {

    Dieta[] dieta = new Dieta[20];
    private Refeicoes[] refeicoes;
    Dieta_DAO dietaDAO = new Dieta_DAO();

    public Refeicoes_DAO() {
        this.refeicoes = null;

    }

    public Refeicoes criarRefeicoes(Refeicoes refeicao) {

        if (refeicoes == null) {
            refeicoes = new Refeicoes[1];
            refeicoes[0] = refeicao;
            return refeicao;
        }
        int novoTamanho = refeicoes.length + 1;
        Refeicoes[] novoArray = new Refeicoes[novoTamanho];
        for (int i = 0; i < refeicoes.length; i++) {
            novoArray[i] = refeicoes[i];

        }
        refeicoes = novoArray;
        refeicoes[refeicoes.length - 1] = refeicao;
        return refeicao;
    }

    public Refeicoes BuscarRefeicao(int id) {
        for (Refeicoes refeicao : refeicoes) {
            if (refeicao.getId() == id) {
                return refeicao;
            }
        }
        return null;
    }

    public void atualizarRefeicao(Refeicoes refeicaoAtualizada) {
        for (int i = 0; i < refeicoes.length; i++) {
            Refeicoes refeicao = refeicoes[i];
            if (refeicao.getId() == refeicaoAtualizada.getId()) {
                refeicoes[i] = refeicaoAtualizada;
                return;
            }
        }
    }

    public boolean deletarRefeicaoPorId(int id) {

        int indexDeletar = -1;

        for (int i = 0; i < refeicoes.length; i++) {

            Refeicoes refeicao = refeicoes[i];
            if (refeicao.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        refeicoes[indexDeletar] = null;

        Refeicoes[] arrayParte1 = new Refeicoes[indexDeletar];
        Refeicoes[] arrayParte2 = new Refeicoes[refeicoes.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = refeicoes[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < refeicoes.length; i++) {
            arrayParte2[j] = refeicoes[i];
            j++;
        }
        Refeicoes[] novaRefeicao = new Refeicoes[refeicoes.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novaRefeicao[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novaRefeicao[i + arrayParte1.length] = arrayParte2[i];
        }

        refeicoes = novaRefeicao;

        return true;
    }

    public Refeicoes[] listarRefeicoes() {
        return refeicoes;
    }

}
