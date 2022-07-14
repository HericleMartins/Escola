package Interfaces;

import java.util.ArrayList;

import Model.Aluno;

public interface AlunoDaoInterface {
    public Aluno consultarAlunoMatricula(int matricula);
    public Aluno consultarAlunoCpf(int cpf);
    public ArrayList<Aluno> consultarAlunoNome(String nome);
    public ArrayList<Aluno> listarAlunos();
    public boolean inserirAluno(Aluno a);
    public Boolean alterarAluno(Aluno a);
}
