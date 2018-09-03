package br.edu.fapi.poo.servlets.aluno.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.servlets.aluno.dao.AlunoDAO;
import br.edu.fapi.poo.servlets.aluno.model.Aluno;

public class MockAlunoDaoImpl implements AlunoDAO {

	private List<Aluno> alunos = new ArrayList<>();

	public int cadastrar(Aluno aluno) {
		alunos.add(aluno);
		return 1;
	}

	public Aluno buscar(Aluno aluno) {
		for (Aluno alunoLista : alunos) {
			if (alunoLista.equals(aluno)) {
				return alunoLista;
			}
		}
		return new Aluno();
	}

	public int excluir(Aluno aluno) {
		return alunos.remove(aluno) ? 1 : 0;
	}

	public int atualizar(Aluno aluno) {
		Aluno alunoEncontrado = null;
		for (Aluno alunoLista : alunos) {
			if (alunoLista.equals(aluno)) {
				alunoEncontrado = alunoLista;
				break;
			}
		}
		if (alunoEncontrado != null) {
			alunoEncontrado = aluno;
			return 1;
		} else {
			return 0;
		}

	}

	public List<Aluno> listarPorCurso(String curso) {
		return alunos;
	}

	public List<Aluno> listarMaiorNotaPorCurso() {
		return alunos;
	}

	public List<Aluno> listarTodos() {
		return alunos;
	}

}
