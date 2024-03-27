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
public class AlimentoRefeicao {

    
    private int idRefeicao;
    private int idAlimento;
    private double porcao;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private double calorias;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AlimentoRefeicao(int idRefeicao,int idAlimento, double porcao, double carboidratos, double proteinas, double gorduras, double calorias, LocalDate dataCriacao) {
        
        this.idRefeicao = idRefeicao;
        this.idAlimento = idAlimento;
        this.porcao = porcao;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.calorias = calorias;
        this.dataCriacao = dataCriacao;
  
    }
    
    

    public int getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(int idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }


    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
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

    @Override
    public String toString() {
        return "AlimentoRefeicao{" + "idRefeicao=" + idRefeicao + ", idAlimento=" + idAlimento + ", porcao=" + porcao + ", carboidratos=" + carboidratos + ", proteinas=" + proteinas + ", gorduras=" + gorduras + ", calorias=" + calorias + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idRefeicao;
        hash = 67 * hash + this.idAlimento;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.porcao) ^ (Double.doubleToLongBits(this.porcao) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.carboidratos) ^ (Double.doubleToLongBits(this.carboidratos) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.proteinas) ^ (Double.doubleToLongBits(this.proteinas) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.gorduras) ^ (Double.doubleToLongBits(this.gorduras) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
        hash = 67 * hash + Objects.hashCode(this.dataModificacao);
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
        final AlimentoRefeicao other = (AlimentoRefeicao) obj;
        if (this.idRefeicao != other.idRefeicao) {
            return false;
        }
        if (this.idAlimento != other.idAlimento) {
            return false;
        }
        if (Double.doubleToLongBits(this.porcao) != Double.doubleToLongBits(other.porcao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidratos) != Double.doubleToLongBits(other.carboidratos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteinas) != Double.doubleToLongBits(other.proteinas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gorduras) != Double.doubleToLongBits(other.gorduras)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }



}
