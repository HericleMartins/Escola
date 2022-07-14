package Model;

public class Endereco {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String bairro;
    private String estado;

    public Endereco() {
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return  "\n______ Endereco ______"
                + "\nLogradouro: " + getLogradouro()
                + "\nNumero: " + getNumero()
                + "\nComplemento: " + getComplemento()
                + "\nCidade: " + getCidade()
                + "\nBairro: " + getBairro()
                + "\nEstado: " + getEstado();
    }
}
