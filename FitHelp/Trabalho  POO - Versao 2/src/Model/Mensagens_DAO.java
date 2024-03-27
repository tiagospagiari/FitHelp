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
public class Mensagens_DAO {

    private Mensagens[] mensagem;
    private int proximoId;

    public Mensagens_DAO() {
        this.mensagem = null;
        this.proximoId = 1;
    }

    public Mensagens adicionarMensagem(Mensagens mensagens) {

        if (mensagem == null) {
            mensagem = new Mensagens[1];
            mensagem[0] = mensagens;
            return mensagens;
        }
        int novoTamanho = mensagem.length + 1;
        Mensagens[] novoArray = new Mensagens[novoTamanho];
        for (int i = 0; i < mensagem.length; i++) {
            novoArray[i] = mensagem[i];

        }
        mensagem = novoArray;
        mensagem[mensagem.length - 1] = mensagens;
        return mensagens;
    }

    public Mensagens[] listarMensagem() {
        return mensagem;
    }

    public Mensagens listarMenagensPorId(int id) {
        Mensagens[] avaliacoesFisicas = listarMensagem();
        for (Mensagens menagens : avaliacoesFisicas) {
            if (menagens.getId() == id) {
                return menagens;
            }
        }
        return null;
    }

   

}
