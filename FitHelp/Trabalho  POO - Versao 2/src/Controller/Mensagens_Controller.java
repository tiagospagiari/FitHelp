/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Mensagens;
import Model.Mensagens_DAO;
import Model.Pessoa;

/**
 *
 * @author tiago
 */
public class Mensagens_Controller {
    private Mensagens_DAO mensagensDAO ;
        public Mensagens_Controller() {
        this.mensagensDAO = new Mensagens_DAO();

    }

    public Mensagens criarMensagem(Mensagens novaMensagem) {
        if (novaMensagem != null) {
            mensagensDAO.adicionarMensagem( novaMensagem);
        } else {
            return null;
        }

        return novaMensagem;
    }

    public Mensagens buscarMensagemPorID(int id) {
        Mensagens[] mensagens = mensagensDAO.listarMensagem();
        for (Mensagens mensagem : mensagens) {
            if (mensagem.getId()== (id)) {
                return mensagem;
            }
        }
        return null;
    }

 

    public Mensagens[] mostrarmensagens() {

        return mensagensDAO.listarMensagem();
    }
}
