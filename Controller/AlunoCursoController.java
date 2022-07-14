package Controller;

import Dao.AlunoCursoDao;
import Model.Aluno;
import Model.Curso;
import java.util.ArrayList;

/**
 *  Classe resposavel por se comunicar com a classe AlunoCursoDao 
 *  da tabela ALUNO_CURSO no banco de dados e retornar para as Views de Aluno e curso
 * @author Héricles Martins
 */
public class AlunoCursoController {
    public AlunoCursoController(){
    }
    
    /**
     *  Função responsavel por acessar a função que vai matricular aluno no banco de dados
     * @param aluno instancia da classe aluno que sera matriculado no banco de dados
     * @param curso
     * @return retorna true se aluno matriculado, false se ocorreu erro
     */
    public boolean matricularAluno(Aluno aluno,Curso curso){
        AlunoCursoDao acd = new AlunoCursoDao();
        return acd.matricularAluno(aluno, curso);
    }
    
    /**
     *  Função responsavel por acessar a função responsavel
     * por buscar cursos que o aluno nao esteja matriculado
     * @param aluno aluno para buscar os cursos
     * @return devolve arraylist do tipo curso caso haja ou null se nao houver
     */
    public ArrayList<Curso> buscarCursosValidosAluno(Aluno aluno){
        AlunoCursoDao acd = new AlunoCursoDao();
        return acd.buscarCursosValidosAluno(aluno);
    }
    
    /**
     *  Função responsavel por acessar a função responsavel em 
     * verificar a quantidade de alunos em um curso
     * e a capacidade da sala que o curso esta alocado
     * @param curso instancia de curso para validar
     * @return retorna true se ainda tiver capacidade livre
     */
    public boolean validarQuantidadeCurso(Curso curso){
        AlunoCursoDao acd = new AlunoCursoDao();
        return acd.validarQuantidadeCurso(curso) < curso.getSala().getCapacidade();
    }
    
    /**
     *  Função responsavel por acessar a função 
     *  responsavel por buscar os alunos de um respectivo curso
     *  no banco de dados
     * @param curso que sera buscado os alunos
     * @return devolve um arraylist de alunos matriculados no respectivo curso
     */
    public ArrayList<Aluno> buscarAlunosCurso(Curso curso){
        AlunoCursoDao acd = new AlunoCursoDao();
        return acd.buscarAlunosCurso(curso);
    }

    /**
     *  Função responsavel por acessar a função que vai buscar
     * os cursos do aluno no banco de dados
     * @param aluno aluno para pesquisar seus cursos
     * @return retorna um arraylist de curso do respectivo aluno
     */
    public ArrayList<Curso> buscarCursosAluno(Aluno aluno){
        AlunoCursoDao acd = new AlunoCursoDao();
        return acd.buscarCursosAluno(aluno);
    }
    
}
