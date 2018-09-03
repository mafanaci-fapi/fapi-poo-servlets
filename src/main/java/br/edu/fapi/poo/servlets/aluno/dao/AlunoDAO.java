package br.edu.fapi.poo.servlets.aluno.dao;

import java.util.List;

import br.edu.fapi.poo.servlets.aluno.model.Aluno;

public interface AlunoDAO {

	int cadastrar(Aluno aluno);
	
	Aluno buscar(Aluno aluno);
	
	int excluir(Aluno aluno);
	
	int atualizar(Aluno aluno);
	
	List<Aluno> listarPorCurso(String curso);
	
	List<Aluno> listarMaiorNotaPorCurso();
	
	List<Aluno> listarTodos();
	
}
