package Funcoes;

import Dao.ProfessorDao;
import Dao.SalaDao;
import Model.Aluno;
import Model.Curso;
import Model.Professor;
import Model.Sala;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class FuncoesAuxiliares {

    /**
     * Função responsavel por setar o curso e devolver ja setado uma instancia
     * de curso para facilitar nas consultas
     *
     * @param rs ResultSet no ponteiro atual de curso para ser setado
     * @return retorna uma instancia de curso ja setado
     * @throws java.sql.SQLException
     */
    public Curso setarCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        SalaDao salaDao = new SalaDao();
        ProfessorDao professorDao = new ProfessorDao();

        Professor professor = professorDao.consultarProfessorCodigoProfessor(rs.getInt(2));
        Sala sala = salaDao.consultarSalaCodigo(rs.getInt(3));

        curso.setCodigo(rs.getInt(1));
        curso.setSala(sala);
        curso.setProfessor(professor);
        curso.setNome(rs.getString(4));
        curso.setCargaHoraria(rs.getDouble(5));
        curso.setDescricao(rs.getString(6));
        curso.setStatus(rs.getBoolean(7));

        return curso;
    }

    /**
     * Função responsavel por setar aluno e facilitar nas funções de consulta ao
     * banco de dados
     *
     * @param rs ResultSet no ponteiro do aluno atual
     * @return retorna uma instancia de aluno ja setado
     * @throws java.sql.SQLException
     */
    public Aluno setarAluno(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setCodigoAluno(rs.getInt(1));
        aluno.setMatricula(rs.getInt(2));
        aluno.setNome(rs.getString(3));
        aluno.setCpf(rs.getLong(4));
        aluno.setCelular(rs.getLong(5));
        aluno.setEmail(rs.getString(6));
        aluno.setLogradouro(rs.getString(7));
        aluno.setNumero(rs.getInt(8));
        aluno.setComplemento(rs.getString(9));
        aluno.setCidade(rs.getString(10));
        aluno.setBairro(rs.getString(11));
        aluno.setEstado(rs.getString(12));
        return aluno;
    }

    /**
     * Função responsavel por setar professor e facilitar nas funções de
     * consulta ao banco de dados
     *
     * @param rs ResultSet no ponteiro do professor atual
     * @return retorna uma instancia de sala ja setado
     * @throws java.sql.SQLException
     */
    public Professor setarProfessor(ResultSet rs) throws SQLException {
        Professor professor = new Professor();
        professor.setCodigoProfessor(rs.getInt(1));
        professor.setCodigoFuncionario(rs.getInt(2));
        professor.setNome(rs.getString(3));
        professor.setCpf(rs.getLong(4));
        professor.setCelular(rs.getLong(5));
        professor.setEmail(rs.getString(6));
        professor.setLogradouro(rs.getString(7));
        professor.setNumero(rs.getInt(8));
        professor.setComplemento(rs.getString(9));
        professor.setCidade(rs.getString(10));
        professor.setBairro(rs.getString(11));
        professor.setEstado(rs.getString(12));
        return professor;
    }

    /**
     * Função responsavel por setar sala e facilitar nas funções de consulta ao
     * banco de dados
     *
     * @param rs ResultSet no ponteiro da sala atual
     * @return retorna uma instancia de sala ja setado
     * @throws java.sql.SQLException
     */
    public Sala setarSala(ResultSet rs) throws SQLException {
        Sala sala = new Sala();
        sala.setCodigo(rs.getInt(1));
        sala.setCapacidade(rs.getInt(2));
        sala.setNome(rs.getString(3));
        sala.setSala(rs.getInt(4));
        sala.setPredio(rs.getInt(5));
        return sala;
    }

    /**
     *  Função para validação de numeros inteiros e reais
     * @param texto texto para validar
     * @param ehDouble true para double e false para inteiro
     * @return retorna o texto formatado de acordo com os parametros
     */
    public static String passarParaNumero(String texto, boolean ehDouble) {
        String numeros = "1234567890";
        String retorno = "";
        boolean contaPonto = false;
        int contaDecimal = 0;
        if (ehDouble) {
            numeros += ".,";
        }
        for (int i = 0; i < texto.length(); i++) {
            if (numeros.indexOf(texto.charAt(i)) > -1) {
                if (ehDouble && (",".charAt(0) == texto.charAt(i) || ".".charAt(0) == texto.charAt(i))) {
                    if (!contaPonto) {
                        retorno += ".";
                        contaPonto = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato invalido!\n"
                        								  + "Digite minutos decimais\n"
                        								  + "Formula: H.( M / 0,6 )\n"
                                                          + "EX: 1h30m -> 1.( 30 / 0,6 ) = 1.50");
                    }
                } else {
                    if (contaPonto) {
                        contaDecimal++;
                        if (contaDecimal <= 2) {
                            retorno += texto.charAt(i);
                        } else {
                            JOptionPane.showMessageDialog(null, "Formato invalido!\n"
                            								  + "Digite minutos decimais\n"
                            								  + "Formula: H.( M / 0,6 )\n"
                            								  + "EX: 1h30m -> 1.( 30 / 0,6 ) = 1.50");
                        }

                    } else {

                        retorno += texto.charAt(i);

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite apenas numeros");
            }
        }
        return retorno;
    }

    /**
     *  Função para validar UF com apenas 2 digitos
     * @param texto texto para validar uf
     * @return retorna texto com as 2 primeiras letras
     */
    public static String validarUf(String texto) {
        String retorno;
        if (texto.length() > 2) {
            retorno = texto.substring(0, 1);
            JOptionPane.showMessageDialog(null, "Digite apenas a UF de duas letras");
        } else {
            retorno = texto;
        }
        return retorno;
    }
   

}
