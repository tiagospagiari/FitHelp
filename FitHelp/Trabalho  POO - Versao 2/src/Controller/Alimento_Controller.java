/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Alimento;
import Model.Alimento_DAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Alunos
 */
public class Alimento_Controller {

    private Alimento_DAO alimentoDAO;

    public Alimento_Controller() {
        this.alimentoDAO = new Alimento_DAO();

    }

    public Alimento criarNovoAlimento(Alimento novoAlimento) {
        if (novoAlimento != null) {
            alimentoDAO.AdicionarAlimento(novoAlimento);
        } else {
            return null;
        }

        return novoAlimento;
    }

    public Alimento buscarAlimentoPorNome(String nomeAlimento) {
        Alimento[] alimentos = alimentoDAO.listarAlimentos();
        for (Alimento alimento : alimentos) {
            if (alimento.getNome().equalsIgnoreCase(nomeAlimento)) {
                return alimento;
            }
        }
        return null;
    }

    public boolean deletarAlimentoporId(int id) {

        boolean foiDeletado = alimentoDAO.deletarAlimentoPorId(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }
    public Alimento buscarAlimentoPorId(int id){
      return  alimentoDAO.listarAlimentoPorId(id);
    }

    public Alimento[] listarAlimentos() {

        return alimentoDAO.listarAlimentos();
    }

    private double calcularCalorias(double carboidratos, double proteinas, double gorduras) {

        return (4 * carboidratos + 4 * proteinas + 9 * gorduras);
    }
}
