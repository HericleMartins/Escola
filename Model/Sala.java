package Model;

public class Sala {
    private Integer codigo;
    private String nome;
    private Integer predio;
    private Integer sala;
    private Integer capacidade;
    public Sala() {}

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getCapacidade() {
        return this.capacidade;
    }
    public Integer getPredio() {
        return predio;
    }
    public void setPredio(Integer predio) {
        this.predio = predio;
    }
    public Integer getSala() {
        return sala;
    }
    public void setSala(Integer sala) {
        this.sala = sala;
    }
}
