package classes;

public class Varas {
    int id;
    private String nvaras;
    private String descricao;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNVaras() {return nvaras;}
    public String getDescricao() { return descricao;}

    public void setNVaras(String nvaras) { this.nvaras = nvaras;}
    public void setDescricao(String descricao) { this.descricao = descricao;}

}
