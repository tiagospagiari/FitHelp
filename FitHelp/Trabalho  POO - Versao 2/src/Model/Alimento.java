/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class Alimento {

    private int id;
    private String nome;
    private double carboidratos;
    private double gorduras;
    private double proteinas;
    private String porcao;
    private double calorias;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Alimento(int id, String nome, double carboidratos, double gorduras, double proteinas, String porcao, double calorias, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
        this.proteinas = proteinas;
        this.porcao = porcao;
        this.calorias = calorias;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Alimento( int id, String nome, double carboidratos, double gorduras, double proteinas, String porcao, double calorias) {

        this.nome = nome;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
        this.proteinas = proteinas;
        this.porcao = porcao;
        this.calorias = calorias;

    }

    public int getNextId() {

        return id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Alimento{" + "id=" + id + ", nome=" + nome + ", carboidratos=" + carboidratos + ", gorduras=" + gorduras + ", proteinas=" + proteinas + ", calorias=" + calorias + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.nome);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.carboidratos) ^ (Double.doubleToLongBits(this.carboidratos) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.gorduras) ^ (Double.doubleToLongBits(this.gorduras) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.proteinas) ^ (Double.doubleToLongBits(this.proteinas) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.porcao);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 31 * hash + Objects.hashCode(this.dataCriacao);
        hash = 31 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alimento other = (Alimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidratos) != Double.doubleToLongBits(other.carboidratos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gorduras) != Double.doubleToLongBits(other.gorduras)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteinas) != Double.doubleToLongBits(other.proteinas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.porcao, other.porcao)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

}
