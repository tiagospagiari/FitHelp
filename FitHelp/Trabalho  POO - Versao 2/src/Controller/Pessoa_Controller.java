/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Pessoa;
import Model.Pessoa_DAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author tiago
 */
public class Pessoa_Controller {

    Pessoa_DAO pessoaDAO = new Pessoa_DAO();

    public Pessoa criarCadastro(Pessoa novaPessoa) {
        if (novaPessoa != null) {
            pessoaDAO.adicionarPessoa(novaPessoa);
        } else {
            return null;
        }

        return novaPessoa;
    }

    public Pessoa fazerLogin(String login, String senha) {

        return pessoaDAO.validaLogin(login, senha);

    }

    public void ListarPessoas() {
        Pessoa[] todasAsPessoas = pessoaDAO.listarPessoas();
        for (Pessoa pessoa : todasAsPessoas) {
            System.out.println("ID:   "+pessoa.getId()+"   Nome: " + pessoa.getNome());
        }
    }

    public Pessoa EncontrarPessoa(int id) {
        Pessoa pessoaEncontrada = pessoaDAO.buscarPessoaPorId(id);
        if (pessoaEncontrada != null) {
            System.out.println("Pessoa encontrada: " + pessoaEncontrada.getNome());
        } else {
            System.out.println("Pessoa não encontrada.");
        }
        return pessoaEncontrada;
    }

    public Pessoa buscarPessoaPorNome(String nomePessoa) {
        Pessoa[] pessoas = pessoaDAO.listarPessoas();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePessoa)) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean AtualizarPessoa(int id, Pessoa novaPessoa) {

        boolean atualizacaoSucesso = pessoaDAO.atualizarPessoa(id, novaPessoa);
        if (atualizacaoSucesso) {
            System.out.println("Pessoa atualizada com sucesso.");
        } else {
            System.out.println("Pessoa com o ID especificado não encontrada.");
        }
        return atualizacaoSucesso;
    }

    public boolean Removerpessoa(int id) {
        boolean remocaoSucesso = pessoaDAO.deletarPessoa(id);
        if (remocaoSucesso) {
            System.out.println("Pessoa removida com sucesso.");
        } else {
            System.out.println("Pessoa com o ID especificado não encontrada.");
        }
        return remocaoSucesso;
    }

}
