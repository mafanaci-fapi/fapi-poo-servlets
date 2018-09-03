package br.edu.fapi.poo.servlets.aluno.service;

import java.util.List;

import br.edu.fapi.poo.servlets.aluno.dao.AlunoDAO;
import br.edu.fapi.poo.servlets.aluno.dao.impl.MockAlunoDaoImpl;
import br.edu.fapi.poo.servlets.aluno.model.Aluno;
import br.edu.fapi.poo.servlets.aluno.util.Utils;

public class AlunoService {

	private AlunoDAO alunoDAO;
	
	public AlunoService() {
		this.alunoDAO = new MockAlunoDaoImpl();
	}
	
	public AlunoService(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}
	
	public boolean cadastrarAluno(Aluno aluno) {
		if(aluno != null) {
			aluno.setMatricula(Utils.gerarMatriculaAluno(aluno));
		}
		return alunoDAO.cadastrar(aluno) != 0 ? true : false;
	}

	public List<Aluno> listarTodos() {
		return alunoDAO.listarTodos();
	}
	
	public void setAlunoDAO(AlunoDAO alunoDAO) {
		if(alunoDAO == null ) {
			this.alunoDAO = alunoDAO;	
		}
	}
	
}
