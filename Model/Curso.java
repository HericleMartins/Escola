package Model;
public class Curso {
    
    private Integer codigo;
    private String nome;
    private Double cargaHoraria;
    private String descricao;
    private Professor professor;
    private Sala sala;
    private boolean status;
    
    public Curso() {
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getCodigo() {
        return this.codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Professor getProfessor() {
        return this.professor;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Sala getSala() {
        return this.sala;
    }
    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public Double getCargaHoraria() {
        return this.cargaHoraria;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    

}
