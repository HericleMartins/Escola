package Controller;

import Dao.ProfessorDao;
import Funcoes.FuncoesAuxiliares;
import java.util.ArrayList;

import Model.Aluno;
import Model.Professor;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;
/**
 *  Classe resposavel por se comunicar com a classe ProfessorDao 
 *  da tabela Professor no banco de dados e retornar para as Views de Professor
 * @author Héricles Martins
 */
public class ProfessorController extends FuncoesAuxiliares {

    public ProfessorController() {
    }

    /**
     *  Função responsavel por acessar a função de 
     * cadastrar professor no banco de dados
     * @param professor instancia da classe professor para cadastrar
     * @return retorna true se cadastrado com sucesso ou false caso não
     */
    public boolean cadastrarProfessor(Professor professor) {
        ProfessorDao pd = new ProfessorDao();
        boolean retorno;
        if ( validarProfessor( professor)){
            retorno = pd.inserirProfessor(professor);
        }else{
            JOptionPane.showMessageDialog(null, "Codigo funcionario ja existe");
            retorno = false;        
        }
        return retorno;        
    }
    
    /**
     * Função responsavel validar o codigo de funcionario do professor
     * @param professor professor que esta sendo validado
     * @return retorna true caso seja valido e false caso não
     */
    public boolean validarProfessor(Professor professor) {
        ProfessorDao pd = new ProfessorDao();
        return isNull(pd.consultarProfessorCodigoFuncionario(professor.getCodigoFuncionario()));
    }

    /**
     *  Função responsavel por acessar a função de listagem de professores
     * do banco de dados
     * @return retorna um arraylist do tipo professor
     */
    public ArrayList <Professor> consultarProfessores(){
        ProfessorDao pd = new ProfessorDao();
        ArrayList<Professor> aProfessors = pd.listarProfessors();
        if (aProfessors.isEmpty()) {
            return null;
        } else {
            return aProfessors;
        }
    }
    
    /**
     *  Funçao responsavel por acessar a função de consulta professor por
     * codigo de professor no banco de dados
     * @param codigoProfessor codigo do professor que vai ser consultado
     * @return retorna o professor ou null caso nao ache
     */
    public Professor consultarProfessorCodigoProfessor(int codigoProfessor){
        ProfessorDao pd = new ProfessorDao();
        Professor professor = pd.consultarProfessorCodigoProfessor(codigoProfessor);
        if (isNull(professor)) {
            return null;
        } else {
            return professor;
        }
    }
    
    /**
     *  Funçao responsavel por acessar a função de consulta professor por
     * codigo de funcionario no banco de dados
     * @param codigoFuncionario codigo de funcionario do professor
     * que vai ser consultado
     * @return retorna o professor ou null caso nao ache
     */
    public Professor consultarProfessorCodigoFuncionario(int codigoFuncionario){
        ProfessorDao pd = new ProfessorDao();
        Professor professor = pd.consultarProfessorCodigoFuncionario(codigoFuncionario);
        if (isNull(professor)) {
            return null;
        } else {
            return professor;
        }
    }

    /**
     *  Função responsavel por acessar a função de consulta professor por nome
     * ou parte dele
     * @param nomeProfessor nome ou parte dele para ser consultada
     * @return retorna um arraylist do tipo professor ou null caso nao ache
     */
    public ArrayList<Professor> consultarProfessorNome( String nomeProfessor) {
        ProfessorDao pd = new ProfessorDao();
        ArrayList<Professor> aProfessors = pd.consultarProfessorNome(nomeProfessor);
        if (aProfessors.isEmpty()) {
            return null;
        } else {
            return aProfessors;
        }
    }

    /**
     *  Função responsavel por acessar a função de consulta de professor por cpf
     * no banco de dados
     * @param cpf cpf do professor a ser consultado
     * @return retorna uma instancia de professor ou null caso nao ache
     */
    public Professor consultarProfessorCpf(int cpf){
        ProfessorDao pd = new ProfessorDao();
        Professor professor = pd.consultarProfessorCpf(cpf);
        if (isNull(professor)) {
            return null;
        } else {
            return professor;
        }
    }

    /**
     *  Função responsavel por acessar a função de 
     * alteração de professor no banco de dados
     * @param professor instancia de professor a ser alterado
     * @return retorna true caso a alterção seja feita
     */
    public boolean alterarProfessor(Professor professor){
        ProfessorDao pd = new ProfessorDao();
        return pd.alterarProfessor(professor);        
    }
    public String validarCamposProfessor(Professor professor) {
		String camposVazios = "";
		camposVazios = isNull(professor) ? camposVazios + "Professor vazio\n" : camposVazios; 
		camposVazios = isNull(professor.getCodigoFuncionario()) ? camposVazios + "Codigo funcionario\n" : camposVazios; 
		camposVazios = isNull(professor.getNome()) ? camposVazios + "Nome\n" : camposVazios; 
		camposVazios = isNull(professor.getLogradouro()) ? camposVazios + "Logradouro\n" : camposVazios; 
		camposVazios = isNull(professor.getNumero()) ? camposVazios + "Numero casa\n" : camposVazios; 
		camposVazios = isNull(professor.getEmail()) ? camposVazios + "Email\n" : camposVazios; 
		camposVazios = isNull(professor.getCelular()) ? camposVazios + "Celular\n" : camposVazios; 
		camposVazios = isNull(professor.getCidade()) ? camposVazios + "Cidade\n" : camposVazios; 
		camposVazios = isNull(professor.getEstado()) ? camposVazios + "Estado\n" : camposVazios; 
		camposVazios = isNull(professor.getBairro()) ? camposVazios + "Bairro\n" : camposVazios; 
		camposVazios = isNull(professor.getCpf()) ? camposVazios + "CPF\n" : camposVazios; 
		
		camposVazios = camposVazios.trim().isEmpty() ? null : camposVazios; 
		return camposVazios;
	}

}
