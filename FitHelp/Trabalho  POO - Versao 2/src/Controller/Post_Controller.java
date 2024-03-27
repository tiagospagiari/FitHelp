/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pessoa;
import Model.Pessoa_DAO;
import Model.Post;
import Model.Post_DAO;
import java.time.LocalDate;


/**
 *
 * @author Alunos
 */
public class Post_Controller {
    
    private Post_DAO postDAO;
   

    public Post_Controller() {
        this.postDAO = new Post_DAO();

    }

    public Post criarNovopPost(Post novoPost) {
        if (novoPost != null) {
            postDAO.criarPost(novoPost);
        } else {
            return null;
        }

        return novoPost;
    }

    public Post buscarPostPorID(int id) {
        Post[] posts = postDAO.listarPosts();
        for (Post post : posts) {
            if (post.getId()== (id)) {
                return post;
            }
        }
        return null;
    }

    public boolean deletarPostPorId(int id) {

        boolean foiDeletado = postDAO.deletarPost(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }

    public Post[] mostrarPost() {
        
        Post[] post = postDAO.listarPosts();
       
        return post;
    }

}
