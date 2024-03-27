/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class AvaliacaoFisica {

    private int id;
    private int idPessoa;
    private double peso;
    private String sexo;
    private String relatorio;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double fatorAtividade;
    private double imc;
    private double tmb;
    private double bf;
    private double massaGorda;
    private double massaMagra;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AvaliacaoFisica(int id,int idPessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril, double imc, double tmb, double bf, double massaGorda, double massaMagra, LocalDate dataCriacao) {
       
        this.id = id;
        this.idPessoa = idPessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.imc = imc;
        this.tmb = tmb;
        this.bf = bf;
        this.dataCriacao = dataCriacao;
        this.massaGorda = massaGorda;
        this.massaMagra = massaMagra;

    }

    public AvaliacaoFisica(int id, int idPessoa, double peso, double altura, int idade, double fatorAtividade, double pescoco, double cintura, double quadril, double imc, double tmb, double bf, double massaGorda, double massaMagra, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.fatorAtividade = fatorAtividade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.imc = imc;
        this.tmb = tmb;
        this.bf = bf;
        this.massaGorda = massaGorda;
        this.massaMagra = massaMagra;
        this.dataModificacao = dataModificacao;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public double getFatorAtividade() {
        return fatorAtividade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTmb() {
        return tmb;
    }

    public void setTmb(double tmb) {
        this.tmb = tmb;
    }

    public double getBf() {
        return bf;
    }

    public void setBf(double bf) {
        this.bf = bf;
    }

    public double getMassaGorda() {
        return massaGorda;
    }

    public void setMassaGorda(double massaGorda) {
        this.massaGorda = massaGorda;
    }

    public double getMassaMagra() {
        return massaMagra;
    }

    public void setMassaMagra(double massaMagra) {
        this.massaMagra = massaMagra;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica{" + "id=" + id + ", idPessoa=" + idPessoa + ", peso=" + peso + ", sexo=" + sexo + ", relatorio=" + relatorio + ", altura=" + altura + ", idade=" + idade + ", pescoco=" + pescoco + ", cintura=" + cintura + ", quadril=" + quadril + ", fatorAtividade=" + fatorAtividade + ", imc=" + imc + ", tmb=" + tmb + ", bf=" + bf + ", massaGorda=" + massaGorda + ", massaMagra=" + massaMagra + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.idPessoa;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.sexo);
        hash = 89 * hash + Objects.hashCode(this.relatorio);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 89 * hash + this.idade;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.pescoco) ^ (Double.doubleToLongBits(this.pescoco) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.fatorAtividade) ^ (Double.doubleToLongBits(this.fatorAtividade) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.imc) ^ (Double.doubleToLongBits(this.imc) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.tmb) ^ (Double.doubleToLongBits(this.tmb) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.bf) ^ (Double.doubleToLongBits(this.bf) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.massaGorda) ^ (Double.doubleToLongBits(this.massaGorda) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.massaMagra) ^ (Double.doubleToLongBits(this.massaMagra) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.dataCriacao);
        hash = 89 * hash + Objects.hashCode(this.dataModificacao);
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
        final AvaliacaoFisica other = (AvaliacaoFisica) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (Double.doubleToLongBits(this.pescoco) != Double.doubleToLongBits(other.pescoco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cintura) != Double.doubleToLongBits(other.cintura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quadril) != Double.doubleToLongBits(other.quadril)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fatorAtividade) != Double.doubleToLongBits(other.fatorAtividade)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imc) != Double.doubleToLongBits(other.imc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tmb) != Double.doubleToLongBits(other.tmb)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bf) != Double.doubleToLongBits(other.bf)) {
            return false;
        }
        if (Double.doubleToLongBits(this.massaGorda) != Double.doubleToLongBits(other.massaGorda)) {
            return false;
        }
        if (Double.doubleToLongBits(this.massaMagra) != Double.doubleToLongBits(other.massaMagra)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.relatorio, other.relatorio)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }



}
