package Model;

public abstract class Pessoa extends Endereco {

    private String nome;
    private Long cpf;
    private String email;
    private Long celular;

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getNome() {
        return this.nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Long getCelular() {
        return this.celular;
    }
}
