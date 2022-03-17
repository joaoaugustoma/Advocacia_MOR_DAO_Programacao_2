package classes;

import java.sql.Date;

public class Custas {
    int id;
    int nProcessos;
    Date dataCustas;
    String descricao;
    String valor;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getnProcessos(){
        return nProcessos;
    }

    public void setNProcessos(int nProcessos){
        this.nProcessos = nProcessos;
    }

    public Date getData(){
        return dataCustas;
    }

    public void setData(Date dataCustas){
        this.dataCustas = dataCustas;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getValor(){
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }
}