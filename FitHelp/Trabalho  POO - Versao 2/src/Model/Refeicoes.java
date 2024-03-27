/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class Refeicoes {

    private int id;
    private int idDieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String nomeRefeicao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Refeicoes(int id,int idDieta, double carboidrato, double proteina, double gordura, double calorias, String nomeRefeicao, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.idDieta = idDieta;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.nomeRefeicao = nomeRefeicao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Refeicoes(int id, int idDieta, double carboidrato, double proteina, double gordura, double calorias, String nomeRefeicao) {
        this.idDieta = idDieta;
        this.id= id;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.nomeRefeicao = nomeRefeicao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getidDieta() {
        return idDieta;
    }

    public void setDieta(int idDieta) {
        this.idDieta = idDieta;

    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;

    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;

    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;

    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;

    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;

    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + this.idDieta;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.carboidrato) ^ (Double.doubleToLongBits(this.carboidrato) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.proteina) ^ (Double.doubleToLongBits(this.proteina) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.gordura) ^ (Double.doubleToLongBits(this.gordura) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.nomeRefeicao);
        hash = 61 * hash + Objects.hashCode(this.dataCriacao);
        hash = 61 * hash + Objects.hashCode(this.dataModificacao);
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
        final Refeicoes other = (Refeicoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idDieta != other.idDieta) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidrato) != Double.doubleToLongBits(other.carboidrato)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteina) != Double.doubleToLongBits(other.proteina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordura) != Double.doubleToLongBits(other.gordura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (!Objects.equals(this.nomeRefeicao, other.nomeRefeicao)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        return "Refeicoes{" + "id=" + id + ", idDieta=" + idDieta + ", carboidrato=" + carboidrato + ", proteina=" + proteina + ", gordura=" + gordura + ", calorias=" + calorias + ", nomeRefeicao=" + nomeRefeicao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }



}
