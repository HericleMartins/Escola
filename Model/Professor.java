package Model;

import java.util.ArrayList;

public class Professor extends Pessoa{
    
    private Integer codigoProfessor;
    private Integer codigoFuncionario;
    private ArrayList<Curso> cursos;
    public Professor(){}
    
    public void setCodigoProfessor(Integer codigoProfessor){
        this.codigoProfessor = codigoProfessor;
    }    
    public Integer getCodigoProfessor(){
        return this.codigoProfessor;
    }
    public void setCodigoFuncionario(Integer codigoFuncionario){
        this.codigoFuncionario = codigoFuncionario;
    }    
    public Integer getCodigoFuncionario(){
        return this.codigoFuncionario;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    public void adicionarCurso( Curso curso ){
        this.cursos.add(curso);
    }
}
