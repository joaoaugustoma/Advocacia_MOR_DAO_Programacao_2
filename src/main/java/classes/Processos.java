package classes;

import java.sql.Date;

public class Processos {
    int id;
    Date dataAbertura;
    Date dataConclusao;
    String situacao;

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
