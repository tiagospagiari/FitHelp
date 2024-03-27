/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Alimento_DAO {

    private Alimento[] alimentos;

    public Alimento_DAO() {
        this.alimentos = null;

        Alimento alimento1 = new Alimento(1, "Amendoim grão cru", 20.3, 43.9, 27.2, "100g", 544, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento1);

        Alimento alimento2 = new Alimento(2, "Peito de Frango grelhado", 0, 2.5, 32, "100g", 159, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento2);

        Alimento alimento3 = new Alimento(3, "Feijão carioca cozido", 13.6, 0.5, 4.8, "100g", 76, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento3);

        Alimento alimento4 = new Alimento(4, "Pão francês", 58.6, 3.1, 8, "100g", 300, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento4);

        Alimento alimento5 = new Alimento(5, "Banana nanica", 23.8, 0.1, 1.4, "100g", 92, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento5);

        Alimento alimento6 = new Alimento(6, "Suco de Laranja pêra", 7.6, 0.1, 0.7, "100g", 33, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento6);

        Alimento alimento7 = new Alimento(7, "Maçã fuji", 15.2, 0, 0.3, "100g", 56, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento7);

        Alimento alimento8 = new Alimento(8, "Morango", 6.8, 0.3, 0.9, "100g", 30, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento8);

        Alimento alimento9 = new Alimento(9, "Salmão Grelhado", 0, 14.5, 26.1, "100g", 243, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento9);

        Alimento alimento10 = new Alimento(10, "Iogurte natural", 1.9, 3, 4.1, "100g", 51, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento10);

        Alimento alimento11 = new Alimento(11, "Queijo minas", 3.6, 24.6, 21.2, "100g", 321, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento11);

        Alimento alimento12 = new Alimento(12, "Ovo cozido", 0.6, 9.5, 13.3, "100g", 146, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento12);

        Alimento alimento13 = new Alimento(13, "Doce de leite cremoso", 59.5, 6, 5.5, "100g", 306, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento13);

        Alimento alimento14 = new Alimento(14, "Arroz cozido", 28.1, 0.2, 2.5, "100g", 128, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento14);

        Alimento alimento15 = new Alimento(15, "Café torrado", 65.8, 11.9, 14.7, "100g", 419, LocalDate.now(), LocalDate.now());
        AdicionarAlimento(alimento15);

    }

    public Alimento AdicionarAlimento(Alimento alimento) {

        if (alimentos == null) {
            alimentos = new Alimento[1];
            alimentos[0] = alimento;
            return alimento;
        }
        int novoTamanho = alimentos.length + 1;
        Alimento[] novoArray = new Alimento[novoTamanho];
        for (int i = 0; i < alimentos.length; i++) {
            novoArray[i] = alimentos[i];

        }
        alimentos = novoArray;
        alimentos[alimentos.length - 1] = alimento;
        return alimento;
    }

    public Alimento atualizarAlimento(Alimento alimentoAtualizado) {
        for (int i = 0; i < alimentos.length; i++) {
            Alimento alimento = alimentos[i];
            if (alimento.getId() == alimentoAtualizado.getId()) {
                alimentos[i] = alimentoAtualizado;
                return alimentoAtualizado;
            }
        }
        return null;
    }

    public boolean deletarAlimentoPorId(int id) {
        int indexDeletar = -1;

        for (int i = 0; i < alimentos.length; i++) {

            Alimento alimento = alimentos[i];
            if (alimento.getId() == id) {
                indexDeletar = i;
            }

        }
        if (indexDeletar == -1) {
            return false;
        }
        if (indexDeletar != -1 && alimentos.length == 1) {
            alimentos = null;
            return true;
        }
        alimentos[indexDeletar] = null;

        Alimento[] arrayParte1 = new Alimento[indexDeletar];
        Alimento[] arrayParte2 = new Alimento[alimentos.length - indexDeletar - 1];
        for (int i = 0; i < indexDeletar; i++) {

            arrayParte1[i] = alimentos[i];

        }
        int j = 0;
        for (int i = indexDeletar + 1; i < alimentos.length; i++) {
            arrayParte2[j] = alimentos[i];
            j++;
        }
        Alimento[] novoAlimento = new Alimento[alimentos.length - 1];
        for (int i = 0; i < arrayParte1.length; i++) {
            novoAlimento[i] = arrayParte1[i];
        }
        for (int i = 0; i < arrayParte2.length; i++) {
            novoAlimento[i + arrayParte1.length] = arrayParte2[i];
        }

        alimentos = novoAlimento;

        return true;
    }

    public Alimento listarAlimentoPorId(int id) {
        Alimento[] alimentos = listarAlimentos();
        for (Alimento alimento : alimentos) {
            if (alimento.getId() == id) {
                return alimento;
            }
        }
        return null;
    }
    
    public Alimento BuscarAlimentoPornome(String nome) {
        Alimento[] alimentos = listarAlimentos();
        for (Alimento alimento : alimentos) {
            if (alimento.getNome().equals(nome)) {
                return alimento;
            }
        }
        return null;
    }

    public Alimento[] listarAlimentos() {

        return alimentos;
    }

}
