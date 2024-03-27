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
 * @author Alunos
 */
public class Seguir {

    private int id;
    private int idOrigem;
    private int idSeguindo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Seguir(int id, int idOrigem, int idSeguindo, LocalDate dataCriacao) {
        this.id = id;
        this.idOrigem = idOrigem;
        this.idSeguindo = idSeguindo;
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public int getIdSeguindo() {
        return idSeguindo;
    }

    public void setIdSeguindo(int idSeguindo) {
        this.idSeguindo = idSeguindo;
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
        return "Seguir{" + "id=" + id + ", idOrigem=" + idOrigem + ", idSeguindo=" + idSeguindo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.idOrigem;
        hash = 47 * hash + this.idSeguindo;
        hash = 47 * hash + Objects.hashCode(this.dataCriacao);
        hash = 47 * hash + Objects.hashCode(this.dataModificacao);
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
        final Seguir other = (Seguir) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idOrigem != other.idOrigem) {
            return false;
        }
        if (this.idSeguindo != other.idSeguindo) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    

}
