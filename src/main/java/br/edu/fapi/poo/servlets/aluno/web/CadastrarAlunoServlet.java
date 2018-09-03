package br.edu.fapi.poo.servlets.aluno.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import br.edu.fapi.poo.servlets.aluno.model.Aluno;
import br.edu.fapi.poo.servlets.aluno.service.AlunoService;

@WebServlet(urlPatterns = "/cadastrarAluno")
public class CadastrarAlunoServlet extends HttpServlet {

	private static int instancias = 0;
	
	private static final long serialVersionUID = 1L;

	private AlunoService alunoService = new AlunoService();

	@Override
	public void init() throws ServletException {
		super.init();
		instancias++;
		System.out.println("Inicializando o servlet CadastrarAlunoServlet. Esse servlet posuí: " + instancias + " instância(s)");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo o servlet CadastrarAlunoServlet.");
	}
	
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Específicamos o tipo de retorno que o servidor enviará.
		resp.setContentType("text/html");

		// Tentamos recuperar os parâmetros "nome" e "curso" da requisição.
		String paramNome = req.getParameter("nome");
		String paramCurso = req.getParameter("curso");

		// A partir do objeto de response da API de servlets obtemos uma stream para
		// escrita.
		PrintWriter out = resp.getWriter();

		// Escrevemos manualmente o que será retornado ao cliente.
		out.write("<html><body><div id='parametros'>");
		out.write("<h1>Parâmetros enviados ao servidor: </h1>");
		boolean parametroFaltando = false;
		if (StringUtils.isBlank(paramNome)) {
			out.write("<p style='color:red;'>Parâmetro \"nome\" deve ser informado !</p>");
			parametroFaltando = true;
		}

		if (StringUtils.isBlank(paramCurso)) {
			out.write("<p style='color:red;'>Parâmetro \"curso\" deve ser informado !</p>");
			parametroFaltando = true;
		}
		if (parametroFaltando) {
			return;
		} else {
			Aluno aluno = new Aluno();
			aluno.setNome(paramNome);
			aluno.setCurso(paramCurso);

			boolean resultado = alunoService.cadastrarAluno(aluno);
			if (resultado) {
				List<Aluno> alunosCadastrados = alunoService.listarTodos();

				out.write("<p style='color:blue;'>Aluno cadastrado com sucesso.</p>");
				out.write("<p>Lista de alunos cadastrados: </p>");
				for (Aluno alunoCadastrado : alunosCadastrados) {
					out.write("Matrícula: " + alunoCadastrado.getMatricula() + "<br/>");
					out.write("Nome: " + alunoCadastrado.getNome() + "<br/>");
					out.write("Curso: " + alunoCadastrado.getCurso() + "<br/>");
					out.write("<hr>");
				}

			}
		}
		out.write("</body></html>");
		out.close();
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

}
