package Controller;

import Model.Preferencias;
import Model.Preferencias_DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tiago
 */
public class Preferencias_Controller {

    private Preferencias_DAO preferenciasDAO;
    private Preferencias preferencias;

    public Preferencias_Controller() {
        this.preferenciasDAO = new Preferencias_DAO();

    }

    public boolean criarNovaPreferenciaCarbo(Preferencias preferencia) {

        if (preferencia != null) {
            preferenciasDAO.criarPreferencias(preferencia);
            preferenciasDAO.adicionarCarboidrato(preferencia.getId(), preferencia.getIdAlimento());
            return true;
        } else {
            return false;
        }
    }

    public boolean criarNovaPreferenciaProt(Preferencias preferencia) {
        if (preferencia != null) {
            preferenciasDAO.criarPreferencias(preferencia);
            preferenciasDAO.adicionarProteina(preferencia.getId(), preferencia.getIdAlimento());
            return true;
        } else {
            return false;
        }
    }

    public boolean criarNovaPreferenciaGord(Preferencias preferencia) {

       if (preferencia != null) {
            preferenciasDAO.criarPreferencias(preferencia);
            preferenciasDAO.adicionarGordura(preferencia.getId(), preferencia.getIdAlimento());
            return true;
        } else {
            return false;
        }

    }

    public Preferencias buscarPreferenciaPorId(int idPreferencia) {
        Preferencias[] preferencias = preferenciasDAO.listarPreferencias();
        for (Preferencias preferencia : preferencias) {
            if (preferencia.getId() == (idPreferencia)) {
                return preferencia;
            }
        }
        return null;
    }

    public boolean deletarPreferenciaporId(int id) {

        boolean foiDeletado = preferenciasDAO.deletarPreferencia(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }

    public Preferencias[] listarPreferencias() {

        return preferenciasDAO.listarPreferencias();
    }

}
