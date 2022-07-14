package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import Model.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import Interfaces.AlunoDaoInterface;
import javax.swing.JOptionPane;

/**
 *  Classe responsavel por se comunicar com a tabela ALUNO no banco de dados
 * e retornar para AlunoController
 * @author Héricles Martins
 */
public class AlunoDao extends Conexao implements AlunoDaoInterface {

    public AlunoDao() {
    }

    /**
     *  Função responsavel por inserir aluno no banco de dados
     * @param aluno instancia de aluno a ser inserido no banco de dados
     * @return retorna true caso aluno inserido e false caso nao 
     */
    @Override
    public boolean inserirAluno(Aluno aluno) {
        Connection con = conector();
        String sql = "INSERT INTO ALUNO VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, aluno.getMatricula());
            psmt.setString(2, aluno.getNome());
            psmt.setLong(3, aluno.getCpf());
            psmt.setLong(4, aluno.getCelular());
            psmt.setString(5, aluno.getEmail());
            psmt.setString(6, aluno.getLogradouro());
            psmt.setInt(7, aluno.getNumero());
            psmt.setString(8, aluno.getComplemento());
            psmt.setString(9, aluno.getCidade());
            psmt.setString(10, aluno.getBairro());
            psmt.setString(11, aluno.getEstado());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            return false;
        }
    }

    /**
     *  Função responsavel por consultar aluno no banco de dados pela matricula
     * do aluno
     * @param matricula matricula do aluno a ser pesquisado no banco 
     * @return retorna uma insancia de aluno caso ache ou null caso nao 
     */
    @Override
    public Aluno consultarAlunoMatricula(int matricula) {
        Connection con = conector();
        String sql = "SELECT * FROM ALUNO WHERE MATRICULA = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, matricula);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = setarAluno(rs);
                return aluno;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
            return null;
        }
    }

    /**
     * Função responsavel por listar todos alunos cadastrados no banco de dados
     * @return retorna um arrayList do tipo aluno caso haja
     */
    @Override
    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> aAlunos = new ArrayList<>();
        Connection con = conector();
        String sql = "SELECT * FROM ALUNO;";
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = setarAluno(rs);
                aAlunos.add(aluno);
            }
            return aAlunos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }

    /**
     *  Função reponsavel por consultar aluno no banco de dados por cpf
     * @param cpf cpf do aluno a ser consultado no banco de dados
     * @return retorna uma instancia de aluno caso encontre ou null caso nao
     */
    @Override
    public Aluno consultarAlunoCpf(int cpf) {
        Connection con = conector();
        String sql = "SELECT * FROM ALUNO WHERE CPF = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, cpf);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = setarAluno(rs);
                return aluno;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }

    /**
     *  Função responsavel por consultar aluno por nome ou parte dele 
     * no banco de dados
     * @param nome nome ou parte do nome do aluno a ser consultado
     * @return retorna um arraylist de aluno caso encontre
     */
    @Override
    public ArrayList<Aluno> consultarAlunoNome(String nome) {
        ArrayList<Aluno> aAlunos = new ArrayList<>();
        Connection con = conector();
        String sql = "SELECT * FROM ALUNO WHERE NOME LIKE '%" + nome + "%' ;";
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = setarAluno(rs);
                aAlunos.add(aluno);
            }
            return aAlunos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }

    /**
     *  Função responsavel por alterar registro de aluno no banco de dados
     * @param aluno instancia de aluno a ser alterada
     * @return retorna true caso a alteração seja feita ou false caso nao 
     */
    @Override
    public Boolean alterarAluno(Aluno aluno) {
        Connection con = conector();
        String sql = "UPDATE ALUNO SET "
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
                + "WHERE CODIGO_ALUNO = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, aluno.getNome());
            psmt.setLong(2, aluno.getCpf());
            psmt.setLong(3, aluno.getCelular());
            psmt.setString(4, aluno.getEmail());
            psmt.setString(5, aluno.getLogradouro());
            psmt.setInt(6, aluno.getNumero());
            psmt.setString(7, aluno.getComplemento());
            psmt.setString(8, aluno.getCidade());
            psmt.setString(9, aluno.getBairro());
            psmt.setString(10, aluno.getEstado());
            psmt.setInt(11, aluno.getCodigoAluno());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }

    }
    
   
}
