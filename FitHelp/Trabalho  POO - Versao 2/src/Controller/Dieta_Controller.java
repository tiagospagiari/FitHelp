/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AvaliacaoFisica;
import Model.AvaliacaoFisica_DAO;
import Model.Dieta;
import Model.Dieta_DAO;
import Model.Pessoa;
import Model.Pessoa_DAO;
import Model.TipoDieta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tiago
 */
public class Dieta_Controller {

    private Dieta_DAO dietaDAO = new Dieta_DAO();
    private Pessoa_DAO pessoaDAO;

    AvaliacaoFisica_Controller avaliacaoController = new AvaliacaoFisica_Controller(null);

    public Dieta criarDieta(Dieta novaDieta) {

        if (novaDieta != null) {
            dietaDAO.adicionarDieta(novaDieta);
        } else {
            return null;
        }

        return novaDieta;
    }

   

    public boolean deletarRefeicaoporId(int id) {

        boolean foiDeletado = dietaDAO.excluirDieta(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }
    
     public Dieta listarDietaPorId(int id) {

        return dietaDAO.listarDietaPorId(id);

    }

    public Dieta[] listarDietas() {
        return dietaDAO.listarDietas();
    }

}
