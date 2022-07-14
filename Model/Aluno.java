package Model;
public class Aluno extends Pessoa {
    private Integer codigoAluno;
    private Integer matricula;
    public Aluno() {
    }
    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public Integer getCodigoAluno() {
        return this.codigoAluno;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return this.matricula;
    }
 
}
