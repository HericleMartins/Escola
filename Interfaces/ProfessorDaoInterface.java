package Interfaces;

import java.util.ArrayList;

import Model.Professor;

public interface ProfessorDaoInterface {
    public Professor consultarProfessorCodigoFuncionario(int codigoFuncionario);
    public Professor consultarProfessorCodigoProfessor(int codigoProfessor);
    public Professor consultarProfessorCpf(int cpf);
    public ArrayList<Professor> consultarProfessorNome(String nome);
    public ArrayList<Professor> listarProfessors();
    public boolean inserirProfessor(Professor p);
    public boolean alterarProfessor(Professor p);
}
