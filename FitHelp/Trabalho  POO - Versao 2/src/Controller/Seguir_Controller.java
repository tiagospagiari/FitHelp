/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Seguir;
import Model.Seguir_DAO;

/**
 *
 * @author tiago
 */
public class Seguir_Controller {
    private Seguir_DAO seguirDAO;
   

    public Seguir_Controller() {
        this.seguirDAO = new Seguir_DAO();

    }

    public Seguir criarNovoseguidor(Seguir novoSeguidor) {
        if (novoSeguidor != null) {
            seguirDAO.AdicionarPessoaParaSeguir(novoSeguidor);
        } else {
            return null;
        }

        return novoSeguidor;
    }

    public Seguir buscarSeguidorPorID(int id) {
        Seguir[] seguidor = seguirDAO.listarSeguidores();
        for (Seguir seguidores : seguidor) {
            if (seguidores.getId()== (id)) {
                return seguidores;
            }
        }
        return null;
    }

    public boolean deletarSeguidorPorId(int id) {

        boolean foiDeletado = seguirDAO.deixarSeguir(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }

    public Seguir[] mostrarSeguidores() {
        
        Seguir[] seguir = seguirDAO.listarSeguidores();
       
        return seguir;
    }
}
