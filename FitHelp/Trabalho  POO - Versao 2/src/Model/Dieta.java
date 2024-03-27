/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class Dieta {

    private int id;
    private int idPessoa;
    private int idAvaliacaoFisica;
    private int idTipoDieta;
    private String objetivo;
    private double calorias;
    private int numeroRefeicoes;
    private Date dataCriacao;
    private Date dataModificacao;

    public Dieta(int id, int idPessoa, int idAvaliacaoFisica, int idDieta, String objetivo, double calorias, int numeroRefeicoes, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idAvaliacaoFisica = idAvaliacaoFisica;
        this.idTipoDieta = idDieta;
        this.objetivo = objetivo;
        this.calorias = calorias;
        this.numeroRefeicoes = numeroRefeicoes;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Dieta(int id,int idPessoa, int idAvaliacaoFisica, int idTipoDieta, String objetivo, double calorias, int numeroRefeicoes) {
        this.idPessoa = idPessoa;
        this.idAvaliacaoFisica = idAvaliacaoFisica;
        this.idTipoDieta = idTipoDieta;
        this.objetivo = objetivo;
        this.calorias = calorias;
        this.numeroRefeicoes = numeroRefeicoes;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdAvaliacaoFisica() {
        return idAvaliacaoFisica;
    }

    public void setIdAvaliacaoFisica(int idAvaliacaoFisica) {
        this.idAvaliacaoFisica = idAvaliacaoFisica;
    }

    public int getIdDieta() {
        return idTipoDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idTipoDieta = idDieta;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

   
}
