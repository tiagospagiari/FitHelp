/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author tiago
 */
import Model.Dieta_DAO;
import Model.Refeicoes;
import Model.Refeicoes_DAO;
import Model.TipoDieta;
import java.time.LocalDate;
import Model.TipoDieta_DAO;

public class Refeicoes_Controller {

    private Refeicoes_DAO refeicoesDAO = new Refeicoes_DAO();

    public Refeicoes_Controller() {
        this.refeicoesDAO = refeicoesDAO;
    }

    public Refeicoes criarNovaRefeicao(Refeicoes novaRefeicao) {
        if (novaRefeicao != null) {
            refeicoesDAO.criarRefeicoes(novaRefeicao);
        } else {
            return null;
        }

        return novaRefeicao;
    }

    public Refeicoes buscarRefeicaoPorNome(String nomeRefeicao) {
        Refeicoes[] refeicoes = refeicoesDAO.listarRefeicoes();
        for (Refeicoes refeicao : refeicoes) {
            if (refeicao.getNomeRefeicao().equalsIgnoreCase(nomeRefeicao)) {
                return refeicao;
            }
        }
        return null;
    }
    
        public boolean deletarRefeicaoporId(int id) {

        boolean foiDeletado = refeicoesDAO.deletarRefeicaoPorId(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }
        public Refeicoes buscarRefeicaoPorId(int id){
            return refeicoesDAO.BuscarRefeicao(id);
        }

    public Refeicoes[] listarRefeicoes() {
        return refeicoesDAO.listarRefeicoes();
    }
}
