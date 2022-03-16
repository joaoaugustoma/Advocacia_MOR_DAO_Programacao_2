package classes;

import java.sql.Date;

public class Audiencia {
    int id;
    Date dataaudiencia;
    String parecer;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Date getData(){
        return dataaudiencia;
    }

    public void setData(Date dataaudiencia){
        this.dataaudiencia = dataaudiencia;
    }

    public String getParecer(){
        return parecer;
    }

    public void setParecer(String parecer){
        this.parecer = parecer;
    }
}
