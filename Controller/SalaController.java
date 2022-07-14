package Controller;
import Dao.SalaDao;
import Model.Professor;
import Model.Sala;

import static java.util.Objects.isNull;

import java.util.ArrayList;


/**
 *  Classe resposavel por se comunicar com a classe SalaDao 
 *  da tabela Sala no banco de dados e retornar para as Views de Sala
 * @author Héricles Martins
 */
public class SalaController {

    /**
     *  Função responsavel por acessar a função de inserir sala
     * no banco de dados
     * @param sala instancia de sala a ser cadastrada
     * @return retorna true se cadastrado ou false caso nao 
     */
    public boolean cadastrarSala(Sala sala) {
        SalaDao sd = new SalaDao();
        return sd.inserirSala(sala);
    }
    
    /**
     *  Função responsavel por acessar a função de consulta sala por codigo
     * no banco de dados
     * @param codigo codigo da sala para consulta
     * @return retorna uma instancia de sala caso haja ou null caso nao 
     */
    public Sala consultarSalaCodigo(int codigo) {
        SalaDao sd = new SalaDao();
        return sd.consultarSalaCodigo(codigo);
    }

    /**
     *  Função responsavel por acessar a função de consulta sala por nome
     * ou parte dele
     * @param nomeSala nome da sala a ser consultada ou parte
     * @return retorna um arraylist de sala caso ache ou null caso nao 
     */
    public ArrayList<Sala> consultarSalaNome( String nomeSala) {
        SalaDao sd = new SalaDao();
        ArrayList<Sala> aSalas = sd.consultarSalaNome(nomeSala);
        if (aSalas.isEmpty()) {
            return null;
        } else {
            return aSalas;
        }
    }

    /**
     * Função responsavel por acessar a função de listar salas do banco de dados
     * @return retorna um arraylist do tipo sala ou null caso nao ache
     */
    public ArrayList<Sala> consultarSalas() {
        SalaDao sd = new SalaDao();
        ArrayList<Sala> aSalas = sd.listarSalas();
        if (aSalas.isEmpty()) {
            return null;
        } else {
            return aSalas;
        }
    }

    /**
     *  Função responsavel por acessar a função de alteração de sala no banco
     * de dados
     * @param sala instancia de sala a ser alterada no banco de dados
     * @return retorna true caso seja alterado ou false caso nao 
     */
    public boolean alterarSala(Sala sala) {
        SalaDao sd = new SalaDao();
        return sd.alterarSala(sala);        
    }
    public String validarCamposSala(Sala sala) {
		String camposVazios = "";
		camposVazios = isNull(sala) ? camposVazios + "Sala vazio\n" : camposVazios; 
		camposVazios = isNull(sala.getNome()) ? camposVazios + "Nome\n" : camposVazios; 
		camposVazios = isNull(sala.getPredio()) ? camposVazios + "N�Predio\n" : camposVazios; 
		camposVazios = isNull(sala.getSala()) ? camposVazios + "N�Sala\n" : camposVazios; 
		camposVazios = isNull(sala.getCapacidade()) ? camposVazios + "Capacidade\n" : camposVazios; 
		camposVazios = camposVazios.trim().isEmpty() ? null : camposVazios; 
		return camposVazios;
	}
}
