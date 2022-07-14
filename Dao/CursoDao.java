package Dao;


import Model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;

/**
 * Classe reponsavel por se comunicar com a tabela Curso no banco de dados
 * @author Héricles Martins
 */
public class CursoDao extends Conexao  {

    private final String INSERT = "INSERT INTO CURSO ( CODIGO_PROFESSOR,CODIGO_SALA,NOME,CARGA_HORARIA,DESCRICAO,STATUS )VALUES(?,?,?,?,?,?)";
    private final String SELECT = "SELECT * FROM CURSO ";
    private final String UPDATE = "UPDATE CURSO SET CODIGO_PROFESSOR = ?, CODIGO_SALA = ?, NOME = ?, CARGA_HORARIA = ?, DESCRICAO = ?,  STATUS = ? WHERE CODIGO_CURSO = ?";

    public CursoDao() {
    }

    /**
     * Função responsavel pela a alteração de um 
     * registro de curso no banco de dados
     * @param curso instancia de curso que sera alterada no banco
     * @return retorna true caso a alteração seja feita, false caso nao
     */
    public Boolean alterarCurso(Curso curso) {
        Connection con = conector();
        String sql = UPDATE;
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, curso.getProfessor().getCodigoProfessor());
            psmt.setLong(2, curso.getSala().getCodigo());
            psmt.setString(3, curso.getNome());
            psmt.setDouble(4, curso.getCargaHoraria());
            psmt.setString(5, curso.getDescricao());
            psmt.setBoolean(6, curso.getStatus());
            psmt.setInt(7, curso.getCodigo());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    /**
     * Função responsavel pela inserção de um registro de curso no banco de dados
     * @param curso instancia de curso que sera cadastrada no banco de dados
     * @return retorna true caso o curso seja inserido, false caso nao
     */
    public boolean inserirCurso(Curso curso) {
        Connection con = conector();
        String sql = INSERT;
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, curso.getProfessor().getCodigoProfessor());
            psmt.setLong(2, curso.getSala().getCodigo());
            psmt.setString(3, curso.getNome());
            psmt.setDouble(4, curso.getCargaHoraria());
            psmt.setString(5, curso.getDescricao());
            psmt.setBoolean(6, curso.getStatus());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    /**
     *  Função responsavel por listar todos registros de curso no banco de dados
     * de acorto com o status selecionado
     * @param status status de ativo(true), inativo(false) ou todos(null) do banco de dados
     * @return retorna um arraylist do tipo curso
     */
    public ArrayList<Curso> listarCursos(Boolean status) {
        Connection con = conector();
        String sql = SELECT;
        if (!isNull(status)) {
            sql += "WHERE STATUS = " + status + "";
        }
        ArrayList<Curso> aCursos = new ArrayList<>();
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Curso curso = setarCurso(rs);
                aCursos.add(curso);
            }
            return aCursos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    /**
     *  Função reponsavel por consultar o curso de acordo com o codigo no banco 
     * de dados
     * @param codigo codigo do curso a ser consultado
     * @return retorna uma instancia de curso caso haja, null caso nao 
     */
    public Curso consultarCursoCodigo(int codigo) {
        Connection con = conector();
        String sql = SELECT;
        sql += " WHERE CODIGO_CURSO = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, codigo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Curso curso = setarCurso(rs);
                return curso;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    /**
     *  Função responsavel por consultar registro de curso no banco de dados
     * pelo nome do curso e seu status
     * @param nomeCurso nome ou parte do nome a ser consultado
     * @param status status do curso a ser consultado ativo(true), inativo(false)
     * todos(null)
     * @return retorna um arraylist de curso
     */
    public ArrayList<Curso> consultarCursoNome(String nomeCurso, Boolean status) {
        Connection con = conector();
        String sql = SELECT;
        sql += " WHERE NOME LIKE '%" + nomeCurso + "%'";
        if (!isNull(status)) {
            sql += " AND STATUS = " + status + "";
        }
        try {
            ArrayList<Curso> aCursos = new ArrayList<>();
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Curso curso = setarCurso(rs);
                aCursos.add(curso);
            }
            return aCursos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    
}
