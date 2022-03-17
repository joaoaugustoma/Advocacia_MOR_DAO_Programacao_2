package classes;

import java.sql.Date;

public class Processos {

    private int idAudiencia;
    private int idNomeCliente;
    private int  idParteContraria;
    private int id;
    private Date dataAbertura;
    private Date dataConclusao;
    private String situacao;

    public int getIdAudiencia() {
        return idAudiencia;
    }

    public void setIdAudiencia(int idAudiencia) {
        this.idAudiencia = idAudiencia;
    }

    public int getIdNomeCliente() {
        return idNomeCliente;
    }

    public void setIdNomeCliente(int idNomeCliente) {
        this.idNomeCliente = idNomeCliente;
    }

    public int getIdParteContraria() {
        return idParteContraria;
    }

    public void setIdParteContraria(int idParteContraria) {
        this.idParteContraria = idParteContraria;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date DataAbertura) {
        this.dataAbertura = DataAbertura;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date DataConclusao) {
        this.dataConclusao = DataConclusao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String Situacao) {
        this.situacao = Situacao;
    }
}
