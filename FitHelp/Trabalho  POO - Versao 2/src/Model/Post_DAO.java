/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Pessoa_Controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class Post_DAO {

    private Post[] posts;
    private Pessoa_Controller pessoa = new Pessoa_Controller();
   

    public Post_DAO() {
        this.posts = null;
        

        Post post1 = new Post(IdNext.getNextIdPost(), pessoa.buscarPessoaPorNome("Rafael").getId(), "De hoje ta pago", null);
        criarPost(post1);
        Post post2 = new Post(IdNext.getNextIdPost(), pessoa.buscarPessoaPorNome("Tiago").getId(), "No pain no gain", null);
        criarPost(post2);
        Post post3 = new Post(IdNext.getNextIdPost(), pessoa.buscarPessoaPorNome("Fischer").getId(), "dieta muito boa feita por esse app", null);
        criarPost(post3);
        Post post4 = new Post(IdNext.getNextIdPost(), pessoa.buscarPessoaPorNome("Fabão").getId(), "De hoje falhouu", null);
        criarPost(post4);

    }

    public Post criarPost(Post post) {

        if (posts == null) {
            posts = new Post[1];
            posts[0] = post;
            return post;
        }
        int novoTamanho = posts.length + 1;
        Post[] novoArray = new Post[novoTamanho];
        for (int i = 0; i < posts.length; i++) {
            novoArray[i] = posts[i];

        }
        posts = novoArray;
        posts[posts.length - 1] = post;
        return post;
    }

    public Post[] listarPosts() {

        return posts;
    }

    public Post buscarPostPorId(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public boolean atualizarPost(int id, Post novoPost) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i].getId() == id) {
                posts[i] = novoPost;
                return true;
            }
        }
        return false;
    }

    public boolean deletarPost(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < posts.length; i++) {

            Post post = posts[i];
            if (post.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && posts.length == 1) {
            posts = null;
            return true;
        }
        posts[indexDeletar] = null;

        Post[] arrayParte1 = new Post[indexDeletar];
        Post[] arrayParte2 = new Post[posts.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = posts[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < posts.length; i++) {
            arrayParte2[j] = posts[i];
            j++;
        }
        Post[] novoPost = new Post[posts.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novoPost[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novoPost[i + arrayParte1.length] = arrayParte2[i];
        }

        posts = novoPost;

        return true;
    }

}
