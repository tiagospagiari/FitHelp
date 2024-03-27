/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Pessoa_Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author tiago
 */
public class Pessoa_DAO {

    private Pessoa[] pessoas;

    public Pessoa_DAO() {
        this.pessoas = null;
        Pessoa userteste = new Pessoa(1, "Tiago", "Masculino", LocalDate.now(), "Tim", "123", "Padrao", LocalDate.now(), LocalDate.now());
        adicionarPessoa(userteste);
        Pessoa userteste2 = new Pessoa(2, "Rafael", "Feminino", LocalDate.now(), "raf", "1234", "Padrao", LocalDate.now(), LocalDate.now());
        adicionarPessoa(userteste2);
        Pessoa userteste3 = new Pessoa(3, "Fabão", "Feminino", LocalDate.now(), "fab", "12345", "Padrao", LocalDate.now(), LocalDate.now());
        adicionarPessoa(userteste3);
        Pessoa userteste4 = new Pessoa(4, "Fischer", "Masculino", LocalDate.now(), "fis", "123456", "Padrao", LocalDate.now(), LocalDate.now());
        adicionarPessoa(userteste4);

    }

    public Pessoa adicionarPessoa(Pessoa pessoa) {

        if (pessoas == null) {
            pessoas = new Pessoa[1];
            pessoas[0] = pessoa;
            return pessoa;
        }
        int novoTamanho = pessoas.length + 1;
        Pessoa[] novoArray = new Pessoa[novoTamanho];
        for (int i = 0; i < pessoas.length; i++) {
            novoArray[i] = pessoas[i];
        }
        pessoas = novoArray;
        pessoas[pessoas.length - 1] = pessoa;
        return pessoa;
    }

    public Pessoa[] listarPessoas() {
        return pessoas;
    }

    public Pessoa buscarPessoaPorId(int id) {
        System.out.println(id);
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId());
            if (pessoa.getId() == id) {
              
                return pessoa;
            }
        }
        return null; // Se não encontrar a pessoa com o ID especificado
    }

    public boolean atualizarPessoa(int id, Pessoa novaPessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i] = novaPessoa;
                return true; // Pessoa atualizada com sucesso
            }
        }
        return false; // Pessoa com o ID especificado não encontrada
    }

    public boolean deletarPessoa(int id) {

        int indexDeletar = -1;

        for (int i = 0; i < pessoas.length; i++) {

            Pessoa pessoa = pessoas[i];
            if (pessoa.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && pessoas.length == 1) {
            pessoas = null;
            return true;
        }
        pessoas[indexDeletar] = null;

        Pessoa[] arrayParte1 = new Pessoa[indexDeletar];
        Pessoa[] arrayParte2 = new Pessoa[pessoas.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = pessoas[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < pessoas.length; i++) {
            arrayParte2[j] = pessoas[i];
            j++;
        }
        Pessoa[] novaPessoa = new Pessoa[pessoas.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novaPessoa[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novaPessoa[i + arrayParte1.length] = arrayParte2[i];
        }

        pessoas = novaPessoa;

        return true;
    }

    public Pessoa validaLogin(String login, String senha) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {

            }
            if (pessoa != null && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                return pessoa;
            }
        }

        return null;
    }

    public boolean loginEmUso(String login) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

// Função para gerar um novo ID (você pode implementar essa lógica)
    private int gerarNovoId() {
        // Implemente a lógica para gerar um novo ID exclusivo
        // Pode ser com base no tamanho da lista de pessoas, por exemplo
        return pessoas.length + 1;
    }
}
