package Controller;

import Dao.AlunoDao;
import Funcoes.FuncoesAuxiliares;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Aluno;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;

/**
 * Classe responsavel por comunicar com a Classe Dao.AlunoDao que se comunica
 * com o banco de dados ALUNO e retornar para as Views de Aluno
 * 
 * @author Héricles Martins
 */
public class AlunoController extends FuncoesAuxiliares {

	private List<String> camposVazios;

	public AlunoController() {
	}

	/**
	 * Cadastra aluno no banco de dados
	 * 
	 * @param aluno instancia ta classe aluno para cadastrar
	 * @return retorna true se aluno for valido e se for cadastrado com sucesso
	 */
	public boolean cadastrarAluno(Aluno aluno) {
		AlunoDao ad = new AlunoDao();
		boolean retorno;
		if (validarAluno(aluno)) {
			retorno = ad.inserirAluno(aluno);
		} else {
			JOptionPane.showMessageDialog(null, "Matricula ja existente");
			retorno = false;
		}
		return retorno;
	}

	public String validarCamposAluno(Aluno aluno) {
		String camposVazios = "";
		camposVazios = isNull(aluno) ? camposVazios + "Aluno vazio\n" : camposVazios; 
		camposVazios = isNull(aluno.getMatricula()) ? camposVazios + "Matricula\n" : camposVazios; 
		camposVazios = isNull(aluno.getNome()) ? camposVazios + "Nome\n" : camposVazios; 
		camposVazios = isNull(aluno.getLogradouro()) ? camposVazios + "Logradouro\n" : camposVazios; 
		camposVazios = isNull(aluno.getNumero()) ? camposVazios + "Numero casa\n" : camposVazios; 
		camposVazios = isNull(aluno.getEmail()) ? camposVazios + "Email\n" : camposVazios; 
		camposVazios = isNull(aluno.getCelular()) ? camposVazios + "Celular\n" : camposVazios; 
		camposVazios = isNull(aluno.getCidade()) ? camposVazios + "Cidade\n" : camposVazios; 
		camposVazios = isNull(aluno.getEstado()) ? camposVazios + "Estado\n" : camposVazios; 
		camposVazios = isNull(aluno.getBairro()) ? camposVazios + "Bairro\n" : camposVazios; 
		camposVazios = isNull(aluno.getCpf()) ? camposVazios + "CPF\n" : camposVazios; 
		
		camposVazios = camposVazios.trim().isEmpty() ? null : camposVazios; 
		return camposVazios;
	}

	/**
	 * Valida se ja existe a matricula gravada no banco de dados
	 * 
	 * @param aluno instanca da classe aluno para validar
	 * @return se for null retorna true, pois é valido a matricula que vai ser
	 *         cadastrada
	 */
	public boolean validarAluno(Aluno aluno) {
		AlunoDao ad = new AlunoDao();
		return isNull(ad.consultarAlunoMatricula(aluno.getMatricula()));
	}

	/**
	 * Traz todos alunos do banco de dados
	 * 
	 * @return retorna um ArrayList do tipo aluno
	 */
	public ArrayList<Aluno> consultarAlunos() {
		AlunoDao ad = new AlunoDao();
		ArrayList<Aluno> aAlunos = ad.listarAlunos();
		if (aAlunos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado alunos");
			return null;
		} else {
			return aAlunos;
		}
	}

	/**
	 * Consulta de aluno por matricula no banco de dados
	 * 
	 * @param matricula do aluno
	 * @return Retorna a instancia de aluno caso encontre, caso nao retornal null
	 */
	public Aluno consultarAlunoMatricula(int matricula) {
		AlunoDao ad = new AlunoDao();
		Aluno aluno = ad.consultarAlunoMatricula(matricula);
		if (isNull(aluno)) {
			return null;
		} else {
			return aluno;
		}
	}

	/**
	 * Consulta de aluno por parte do nome no banco de dados
	 * 
	 * @param nomeAluno parte do nome do aluno a ser pesquisado
	 * @return retorna um arrayList do tipo aluno com todos alunos com nome parecido
	 *         caso nao encontre nenhum retorna null
	 */
	public ArrayList<Aluno> consultarAlunoNome(String nomeAluno) {
		AlunoDao ad = new AlunoDao();
		ArrayList<Aluno> aAlunos = ad.consultarAlunoNome(nomeAluno);
		if (aAlunos.isEmpty()) {
			return null;
		} else {
			return aAlunos;
		}
	}

	/**
	 * consulta de aluno por cpf
	 * 
	 * @param cpf cpf do aluno a ser pesquisado no banco
	 * @return retorna o aluno, caso encontre no banco de dados, caso nao retorna
	 *         null
	 */
	public Aluno consultarAlunoCpf(int cpf) {
		AlunoDao ad = new AlunoDao();
		Aluno aluno = ad.consultarAlunoCpf(cpf);
		if (isNull(aluno)) {
			return null;
		} else {
			return aluno;
		}
	}

	/**
	 * Alteração do aluno no banco de dados
	 * 
	 * @param aluno instancia de aluno a ser modificado
	 * @return retorna true se alterado com sucesso, false se der algum problema
	 */
	public boolean alterarAluno(Aluno aluno) {
		AlunoDao ad = new AlunoDao();
		return ad.alterarAluno(aluno);
	}
}
