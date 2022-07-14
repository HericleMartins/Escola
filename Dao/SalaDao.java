package Dao;


import Model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Função responsavel por se comunicar com a tabela Sala no banco de dados
 *
 * @author Héricles Martins
 */
public class SalaDao extends Conexao {

    private final String INSERT = "INSERT INTO SALA (capacidade,nome,numero_sala,predio)VALUES(?,?,?,?)";
    private final String SELECT = "SELECT * FROM SALA ";
    private final String UPDATE = "UPDATE sala SET nome = ?, predio = ?, numero_sala = ?, capacidade = ? WHERE CODIGO_SALA = ?";

    public SalaDao() {
    }

    /**
     * Função responsavel por fazer alterações de registro de sala
     * @param sala instancia de sala que sera alterada
     * @return retorna true se ela foi alterada false se nao
     */
    public Boolean alterarSala(Sala sala) {
        Connection con = conector();
        String sql = UPDATE;
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, sala.getNome());
            psmt.setInt(2, sala.getPredio());
            psmt.setInt(3, sala.getSala());
            psmt.setInt(4, sala.getCapacidade());
            psmt.setInt(5, sala.getCodigo());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    /**
     *  Função responsavel por inserir um registro de sala no banco de dados
     * @param sala instancia de sala que sera inserida 
     * @return retorna true se inserida e false se nao
     */
    public boolean inserirSala(Sala sala) {
        Connection con = conector();
        String sql = INSERT;
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, sala.getCapacidade());
            psmt.setString(2, sala.getNome());
            psmt.setInt(3, sala.getSala());
            psmt.setLong(4, sala.getPredio());
            return psmt.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    /**
     *  Função responsavel por listar todos registro de sala do banco de dados
     * @return retorna um arrayList de sala com registros encontrados
     */
    public ArrayList<Sala> listarSalas() {
        Connection con = conector();
        String sql = SELECT;
        ArrayList<Sala> aSalas = new ArrayList<>();
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Sala sala = setarSala(rs);
                aSalas.add(sala);
            }
            return aSalas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    /**
     *  Função responsavel por consultar registro de sala por codigo no banco de
     * dados
     * @param codigo codigo  da sala a ser consultada no banco de dados
     * @return retorna uma instancia de sala caso haja ou null caso nao
     */
    public Sala consultarSalaCodigo(int codigo) {
        Connection con = conector();
        String sql = SELECT;
        sql += " WHERE CODIGO_SALA = ? limit 1";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setInt(1, codigo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Sala sala = setarSala(rs);
                return sala;
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    /**
     *  Função responsavel por consultar registro de sala por nome ou parte dele
     * @param nomeSala nome ou parte do nome da sala a ser consultada
     * @return retorna um arraylist de sala com registros encontrados
     */
    public ArrayList<Sala> consultarSalaNome(String nomeSala) {
        ArrayList<Sala> aSalas = new ArrayList<>();
        Connection con = conector();
        String sql = SELECT;
        sql += "SALA WHERE NOME LIKE '%" + nomeSala + "%' ;";
        try {
            Statement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                Sala sala = setarSala(rs);
                aSalas.add(sala);
            }
            return aSalas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

}
