/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import Controller.Pessoa_Controller;
import java.time.LocalDate;
import java.util.Scanner;
import View.GUI;

/**
 *
 * @author tiago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    GUI menu = new GUI();

    private static Pessoa usuarioLogado;

    public Main() {
        
        menu.MenuLogin();
    }

    public static void main(String[] args) {

        new Main();

    }

}
