package classes;

import java.util.ArrayList;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String endereco;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private ArrayList<String> telefone = new ArrayList<>();
    private String email;
    private TipoPessoa tipoPessoa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone(int index) {
        return telefone.get(index);
    }

    public void setTelefone(String telefone) {
        this.telefone.add(telefone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa(){
        return tipoPessoa.getLabel();
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa){
        this.tipoPessoa = tipoPessoa;
    }
}
