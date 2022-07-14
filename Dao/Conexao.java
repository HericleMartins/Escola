package Dao;

import Funcoes.FuncoesAuxiliares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static java.util.Objects.isNull;

/**
 * Classe abstrata de conexao com o banco de dados todas CLASSES DAO serão
 * extendidas a essa
 * 
 * @author Héricles Martins
 */
public abstract class Conexao extends FuncoesAuxiliares {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/escola";
	private String user;
	private String password;

	public void lerArquivoConexao() {
		FileInputStream stream;
		File arquivoConexao = new File("conexao.txt");
		try {
			stream = new FileInputStream(arquivoConexao);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);
			String usuario = br.readLine();
			String senha = br.readLine();
			user = isNull(usuario) ? "root" :  usuario;
			password = isNull(senha) ? "" :  senha;
			stream.close();
			gravarArquivoConfiguracao(user, password);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void lerArquivoConfiguracao() {
		FileInputStream stream;
		File arquivoConfiguracao = new File("config\\cfg.cfg");
		try {
			if (arquivoConfiguracao.exists()) {
				stream = new FileInputStream(arquivoConfiguracao);
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader br = new BufferedReader(reader);
				String usuario = br.readLine();
				String senha = br.readLine();
				user = isNull(usuario) ? "root" :  usuario;
				password = isNull(senha) ? "" :  senha;
			}else {
				user = "root";
				password = "";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void gravarArquivoConfiguracao(String usuario, String password) {
		File diretorio = new File("config");
		diretorio.mkdir();
		FileWriter arq;
		try {
			arq = new FileWriter("config\\cfg.cfg");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(usuario);
			gravarArq.printf(password);
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Função Responsavel por criar a conexão no banco de dados
	 * 
	 * @return retorna uma instancia da classe Connectio se conexao bem sucedida ou
	 *         null caso nao
	 */
	public Connection conector() {
		java.sql.Connection conexao = null;
		File arquivoConexao = new File("conexao.txt");
		if (arquivoConexao.exists() && arquivoConexao.isFile()) {
			lerArquivoConexao();
			arquivoConexao.delete();
		} else {
			lerArquivoConfiguracao();
		}
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e);
			return null;
		}
	}
}
