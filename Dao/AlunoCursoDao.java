package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Aluno;
import Model.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *  Classe resposavel por se comunicar com a tabela Aluno_Curso no banco de dados e 
 * retornar para o controller de AlunoCurso
 * @author Héricles Martins
 */
public class AlunoCursoDao extends Conexao {
    
    private final String INSERT = "INSERT INTO ALUNO_CURSO VALUES (?,?)";
    private final String SELECT = "SELECT * FROM ";

    /**
     *  Função responsavel por matricular aluno ao respectivo curso no banco
     * de dados na tabela Aluno_curso
     * @param aluno instancia do aluno a ser matriculado
     * @param curso instancia do curso que o aluno vai se matricular
     * @return retorna true caso nao haja nenhum erro no cadastramento
     */
    public boolean matricularAluno(Aluno aluno, Curso curso) {
        Connection con = conector();
        try {
            PreparedStatement psmt = con.prepareStatement(INSERT);
            psmt.setInt(1, aluno.getCodigoAluno());
            psmt.setInt(2, curso.getCodigo());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }


    /**
     *  Função responsavel por buscar cursos validos para o aluno
     * cursos que ele ainda nao se matriculou
     * @param aluno instancia de aluno para ser validado
     * @return retorna um arraylist de curso 
     */
    public ArrayList<Curso> buscarCursosValidosAluno(Aluno aluno) {
        ArrayList<Curso> aCursos = new ArrayList<>();
        Connection con = conector();
        String sql = SELECT;
        sql +=  " CURSO"
                + " WHERE CODIGO_CURSO NOT IN ( "
                + " SELECT ALUNO_CURSO.CODIGO_CURSO FROM ALUNO_CURSO "
                + " INNER JOIN ALUNO ON ALUNO.CODIGO_ALUNO = ALUNO_CURSO.CODIGO_ALUNO "
                + " WHERE ALUNO_CURSO.CODIGO_ALUNO = ? );";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, aluno.getCodigoAluno());
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Curso curso = setarCurso(rs);
                aCursos.add(curso);
            }
            return aCursos;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel para buscar no banco de dados os alunos
     * do respectivo curso
     * @param curso instancia de curso para ser buscado no banco
     * @return retorna um arraylist de aluno com os alunos do curso caso haja
     */
    public ArrayList<Aluno> buscarAlunosCurso(Curso curso) {
        ArrayList<Aluno> aAlunos = new ArrayList<>();
        Connection con = conector();
        String sql = SELECT;
        sql +=      " ALUNO "
                  + " WHERE CODIGO_ALUNO IN ( "
                  + " SELECT ALUNO_CURSO.CODIGO_ALUNO FROM ALUNO_CURSO WHERE ALUNO_CURSO.CODIGO_CURSO = ?)";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, curso.getCodigo());
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = setarAluno(rs);
                aAlunos.add(aluno);
            }
            return aAlunos;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por buscar os cursos que o aluno esta matriculado
     * no banco de dados
     * @param aluno instancia de aluno que sera pesquisado no banco
     * @return retorna um arraylist do tipo curso com os cursos do aluno 
     * caso haja
     */
    public ArrayList<Curso> buscarCursosAluno(Aluno aluno) {
        ArrayList<Curso> aCursos = new ArrayList<>();
        Connection con = conector();
        String sql = SELECT;
        sql +=       " CURSO "
                   + " WHERE CODIGO_CURSO IN ( "
                   + " SELECT ALUNO_CURSO.CODIGO_CURSO FROM ALUNO_CURSO WHERE ALUNO_CURSO.CODIGO_ALUNO = ?)";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, aluno.getCodigoAluno());
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Curso curso = setarCurso(rs);
                aCursos.add(curso);
            }
            return aCursos;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por verificar quantos alunos ja estao matriculados
     * no curso, no banco de dados
     * @param curso instancia de curso que sera validada
     * @return retorna a quantidade de alunos matriculados no curso
     */
    public int validarQuantidadeCurso(Curso curso) {
        Connection con = conector();
        String sql = " SELECT count(CODIGO_CURSO) AS QUANTIDADE FROM ALUNO_CURSO "
                   +" WHERE CODIGO_CURSO = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, curso.getCodigo());
            ResultSet rs = psmt.executeQuery();
            if ( rs.next() ){
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }else{
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    
}
