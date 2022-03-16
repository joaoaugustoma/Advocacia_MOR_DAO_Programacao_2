package classes;

public class PessoaJuridica extends Pessoa{
    private Long cnpj;

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
}
