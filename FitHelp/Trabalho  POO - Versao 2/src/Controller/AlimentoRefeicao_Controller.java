/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AlimentoRefeicao;
import Model.AlimentoRefeicao_DAO;
import Model.Alimento_DAO;
import Model.Refeicoes_DAO;

/**
 *
 * @author tiago
 */
public class AlimentoRefeicao_Controller {

    private AlimentoRefeicao_DAO alimentoRefeicaoDAO;
    private Alimento_DAO alimentoDAO;
    private Refeicoes_DAO refeicoesDAO;

    public AlimentoRefeicao_Controller() {
        this.alimentoRefeicaoDAO = new AlimentoRefeicao_DAO();

    }

    public AlimentoRefeicao criarNovoAlimento(AlimentoRefeicao novoAlimentoRefeicao) {
        if (novoAlimentoRefeicao != null) {
            alimentoRefeicaoDAO.AdicionarAlimentoRefeicao(novoAlimentoRefeicao);
        } else {
            return null;
        }

        return novoAlimentoRefeicao;
    }

    public AlimentoRefeicao buscarAlimentoRefeicaoPorid(int idAlimento, int idRefeicao) {

        return alimentoRefeicaoDAO.buscarAlimentoRefeicaoPorId(idAlimento, idRefeicao);

    }

    public boolean deletarAlimentoRefeicaoporId(int idAlimento, int idRefeicao) {

        boolean foiDeletado = alimentoRefeicaoDAO.deletarAlimentoRefeicao(idAlimento, idRefeicao);
        if (foiDeletado) {
            return true;
        }

        return false;

    }

    public AlimentoRefeicao[] listarAlimentoRefeicao() {

        return alimentoRefeicaoDAO.listarAlimentoRefeicao();
    }
    
    public AlimentoRefeicao[] mostrarRefeicaoCompleta(int idRefeicao) {
       return alimentoRefeicaoDAO.listarRefeicaoCompleta(idRefeicao);
    }
}
