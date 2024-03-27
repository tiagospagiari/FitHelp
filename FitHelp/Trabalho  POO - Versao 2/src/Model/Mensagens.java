/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Alunos
 */
public class Mensagens {

    private int id;
    private int idPessoaOrigem;
    private int idPessoaDestino;
    private String mensagem;
    private Date dataCriacao;
    private Date dataModificacao;

    public Mensagens(int id, int idPessoaOrigem, int idPessoaDestino, String mensagem, Date dataCriacao) {
        this.id = id;
        this.idPessoaOrigem = idPessoaOrigem;
        this.idPessoaDestino = idPessoaDestino;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoaOrigem() {
        return idPessoaOrigem;
    }

    public void setIdPessoaOrigem(int idPessoaOrigem) {
        this.idPessoaOrigem = idPessoaOrigem;
    }

    public int getIdPessoaDestino() {
        return idPessoaDestino;
    }

    public void setIdPessoaDestino(int idPessoaDestino) {
        this.idPessoaDestino = idPessoaDestino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
        return "Mensagens{" + "id=" + id + ", idPessoaOrigem=" + idPessoaOrigem + ", idPessoaDestino=" + idPessoaDestino + ", mensagem=" + mensagem + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.idPessoaOrigem;
        hash = 47 * hash + this.idPessoaDestino;
        hash = 47 * hash + Objects.hashCode(this.mensagem);
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
        final Mensagens other = (Mensagens) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPessoaOrigem != other.idPessoaOrigem) {
            return false;
        }
        if (this.idPessoaDestino != other.idPessoaDestino) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

   
}
