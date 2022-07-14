package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import Model.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import Interfaces.ProfessorDaoInterface;

/**
 *  Classe responsavel por se comunicar com a tabela professor no banco de dados
 * @author Héricles Martins
 */
public class ProfessorDao extends Conexao implements ProfessorDaoInterface {

    public ProfessorDao() {
    }

    /**
     *  Função responsavel por inserir um registro de professor no banco de dados
     * @param professor
     * @return retorna true caso sucesso, false caso nao
     */
    @Override
    public boolean inserirProfessor(Professor professor) {
        Connection con = conector();
        String sql = "INSERT INTO PROFESSOR (codigo_funcionario, nome, cpf, celular, email, logradouro, numero_endereco,complemento_endereco, cidade_endereco, bairro_endereco,uf_endereco)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, professor.getCodigoFuncionario());
            psmt.setString(2, professor.getNome());
            psmt.setLong(3, professor.getCpf());
            psmt.setLong(4, professor.getCelular());
            psmt.setString(5, professor.getEmail());
            psmt.setString(6, professor.getLogradouro());
            psmt.setInt(7, professor.getNumero());
            psmt.setString(8, professor.getComplemento());
            psmt.setString(9, professor.getCidade());
            psmt.setString(10, professor.getBairro());
            psmt.setString(11, professor.getEstado());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     *  Função responsavel por consultar registro de professor pelo codigo de
     * professor
     * @param codigoProfessor codigo do professor a ser consultado no banco
     * @return retorna uma instancia de professor caso ache um registro
     * null caso nao 
     */
    @Override
    public Professor consultarProfessorCodigoProfessor(int codigoProfessor) {
        Connection con = conector();
        String sql = "SELECT * FROM PROFESSOR WHERE CODIGO_PROFESSOR = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, codigoProfessor);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Professor professor = setarProfessor(rs);
                return professor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por consultar registro de professor pelo codigo de
     * funcionario
     * @param codigoFuncionario codigo de funcionario a ser consultado no banco
     * @return retorna uma instancia de professor caso ache um registro
     * null caso nao 
     */
    @Override
    public Professor consultarProfessorCodigoFuncionario(int codigoFuncionario) {
        Connection con = conector();
        String sql = "SELECT * FROM PROFESSOR WHERE CODIGO_FUNCIONARIO = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, codigoFuncionario);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Professor professor = setarProfessor(rs);
                return professor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por listar todos registro de professores no banco de dados
     * 
     * @return retorna um arraylist do tipo professor
     */
    @Override
    public ArrayList<Professor> listarProfessors() {
        ArrayList<Professor> aProfessors = new ArrayList<>();
        Connection con = conector();
        String sql = "SELECT * FROM PROFESSOR;";
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Professor professor = setarProfessor(rs);
                aProfessors.add(professor);
            }
            return aProfessors;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por consultar registro de professor por Cpf
     * @param cpf cpf do professor a ser consultado
     * @return retorna uma instancia de professor caso ache
     * null caso nao 
     */
    @Override
    public Professor consultarProfessorCpf(int cpf) {
        Connection con = conector();
        String sql = "SELECT * FROM PROFESSOR WHERE CPF = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, cpf);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Professor professor = setarProfessor(rs);
                return professor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por consultar registros de professores por nome
     * ou parte dele
     * @param nome nome ou parte do nome do professor a ser consultado
     * @return retorna um arraylist de professor 
     */
    @Override
    public ArrayList<Professor> consultarProfessorNome(String nome) {
        ArrayList<Professor> aProfessors = new ArrayList<>();
        Connection con = conector();
        String sql = "SELECT * FROM PROFESSOR WHERE NOME LIKE '%" + nome + "%' ;";
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Professor professor = setarProfessor(rs);
                aProfessors.add(professor);
            }
            return aProfessors;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     *  Função responsavel por alterar registro de professor no banco de dados
     * 
     * @param professor instancia de professor que sera alterado no banco
     * @return retorna true caso sucesso ou false caso nao
     */
    @Override
    public boolean alterarProfessor(Professor professor) {
        Connection con = conector();
        String sql = "UPDATE PROFESSOR SET "
                + "NOME = ?,"
                + "CPF = ?,"
                + "CELULAR = ?,"
                + "EMAIL = ?,"
                + "LOGRADOURO = ?,"
                + "NUMERO_ENDERECO = ?,"
                + "COMPLEMENTO_ENDERECO = ?,"
                + "CIDADE_ENDERECO = ?,"
                + "BAIRRO_ENDERECO = ?,"
                + "UF_ENDERECO = ? "
                + "WHERE CODIGO_PROFESSOR = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, professor.getNome());
            psmt.setLong(2, professor.getCpf());
            psmt.setLong(3, professor.getCelular());
            psmt.setString(4, professor.getEmail());
            psmt.setString(5, professor.getLogradouro());
            psmt.setInt(6, professor.getNumero());
            psmt.setString(7, professor.getComplemento());
            psmt.setString(8, professor.getCidade());
            psmt.setString(9, professor.getBairro());
            psmt.setString(10, professor.getEstado());
            psmt.setInt(11, professor.getCodigoProfessor());
            if (psmt.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }

    }

    

  
}
