/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tiago
 */
public class Preferencias {

    private int id;
    private int idPessoa;
    private int idAlimento;
    private int[] idAlimentoPrefCarb;
    private int[] idAlimentoPrefProt;
    private int[] idAlimentoPrefGord;
    private Date dataCriacao;
    private Date dataModificacao;

    public Preferencias(int id, int idPessoa,int idAlimento, int[] idAlimentoPrefcarb, int[] idAlimentoPrefProt, int[] idAlimentoPrefGord, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idAlimentoPrefCarb = null;
        this.idAlimentoPrefProt = null;
        this.idAlimentoPrefGord = null;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Preferencias(int id, int idPessoa, int idAlimento, Date dataCriacao) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idAlimento= idAlimento;
        this.dataCriacao = dataCriacao;
    }
    

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
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

    public int[] getIdAlimentoPrefCarb() {
        return idAlimentoPrefCarb;
    }

    public void setIdAlimentoPrefCarb(int[] idAlimentoPrefCarb) {
        this.idAlimentoPrefCarb = idAlimentoPrefCarb;
    }

    public int[] getIdAlimentoPrefProt() {
        return idAlimentoPrefProt;
    }

    public void setIdAlimentoPrefProt(int[] idAlimentoPrefProt) {
        this.idAlimentoPrefProt = idAlimentoPrefProt;
    }

    public int[] getIdAlimentoPrefGord() {
        return idAlimentoPrefGord;
    }

    public void setIdAlimentoPrefGord(int[] idAlimentoPrefGord) {
        this.idAlimentoPrefGord = idAlimentoPrefGord;
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

    @Override
    public String toString() {
        return "Preferencias{" + "id=" + id + ", idPessoa=" + idPessoa + ", idAlimentoPrefcarb=" + idAlimentoPrefCarb + ", idAlimentoPrefProt=" + idAlimentoPrefProt + ", idAlimentoPrefGord=" + idAlimentoPrefGord + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.idPessoa;
        hash = 97 * hash + Arrays.hashCode(this.idAlimentoPrefCarb);
        hash = 97 * hash + Arrays.hashCode(this.idAlimentoPrefProt);
        hash = 97 * hash + Arrays.hashCode(this.idAlimentoPrefGord);
        hash = 97 * hash + Objects.hashCode(this.dataCriacao);
        hash = 97 * hash + Objects.hashCode(this.dataModificacao);
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
        final Preferencias other = (Preferencias) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (!Arrays.equals(this.idAlimentoPrefCarb, other.idAlimentoPrefCarb)) {
            return false;
        }
        if (!Arrays.equals(this.idAlimentoPrefProt, other.idAlimentoPrefProt)) {
            return false;
        }
        if (!Arrays.equals(this.idAlimentoPrefGord, other.idAlimentoPrefGord)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    
   

}
