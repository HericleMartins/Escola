package Controller;

import Dao.CursoDao;
import Model.Curso;
import Model.Sala;

import static java.util.Objects.isNull;

import java.util.ArrayList;

/**
 *  Classe resposavel por se comunicar com a classe CursoDao 
 *  da tabela CURSO no banco de dados e retornar para as Views de CURSO
 * @author Héricles Martins
 */
public class CursoController {
    
    /**
     * Função responsavel por acessar a função de 
     * Cadastro de curso no Banco de dados
     * @param curso instancia Curso que vai ser cadastrado
     * @return retorna True se sucesso no cadastro do CURSO 
     */
    public boolean cadastrarCurso(Curso curso) {
        CursoDao cd = new CursoDao();
        return cd.inserirCurso(curso);
    }
    /**
     * Função responsavel por acessar a função 
     * de Consulta de cursos
     * @param status, parametro para buscar cursos ativos ou inativos, null se quiser buscar todos
     * @return retorna um arraylist do tipo curso caso sucesso
     */
    public ArrayList<Curso> consultarCursos(Boolean status) {
        CursoDao cd = new CursoDao();
        ArrayList<Curso> aCursos = cd.listarCursos(status);
        if (aCursos.isEmpty()) {
            return null;
        } else {
            return aCursos;
        }
    }
    /**
     * Função responsavel por acessar a função de
     * Consulta cursos pelo nome no BD
     * @param nomeCurso nome do curso ou parte dele 
     * @param status, parametro para buscar cursos ativos ou inativos, null se quiser buscar todos
     * @return retorna um arraylist do tipo curso caso sucesso
     */    
    public ArrayList<Curso> consultarCursoNome(String nomeCurso, Boolean status) {
        CursoDao cd = new CursoDao();
        ArrayList<Curso> aCursos = cd.consultarCursoNome(nomeCurso,status);
        if (aCursos.isEmpty()) {
            return null;
        } else {
            return aCursos;
        }
    }
    /**
     * Função responsavel por acessar a função de Consulta de
     * cursos pelo codigo do curso no BD
     * @param codigo codigo do curso para consulta 
     * @return retorna uma instancia de curso caso sucesso
     */    
    public Curso consultarCursoCodigo(int codigo) {
        CursoDao cd = new CursoDao();
        return cd.consultarCursoCodigo(codigo);
    }
    
    /**
    * Função responsavel por acessar a função de Alterar curso no BD 
    * @param curso instancia da classe curso com a alteração
    * @return retorna true se foi alterado com sucesso
    */
    public boolean alterarCurso(Curso curso){
        CursoDao cd = new CursoDao();
        return cd.alterarCurso(curso);        
    }
    public String validarCamposCurso(Curso curso) {
		String camposVazios = "";
		camposVazios = isNull(curso) ? camposVazios + "Curso vazio\n" : camposVazios; 
		camposVazios = isNull(curso.getProfessor()) ? camposVazios + "Professor\n" : camposVazios; 
		camposVazios = isNull(curso.getSala()) ? camposVazios + "Sala\n" : camposVazios; 
		camposVazios = isNull(curso.getNome()) ? camposVazios + "Nome\n" : camposVazios; 
		camposVazios = isNull(curso.getCargaHoraria()) ? camposVazios + "Carga horaria\n" : camposVazios; 
		camposVazios = isNull(curso.getDescricao()) ? camposVazios + "Descri��o\n" : camposVazios; 
		camposVazios = camposVazios.trim().isEmpty() ? null : camposVazios; 
		return camposVazios;
	}

}
