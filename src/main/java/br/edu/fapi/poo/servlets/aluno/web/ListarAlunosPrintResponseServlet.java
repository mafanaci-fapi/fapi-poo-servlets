package br.edu.fapi.poo.servlets.aluno.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

//Quando o cliente tentar acessar a url http://localhost:8080/fapi-poo-servlets/listarAlunosPrintResponse
//ele estar� acessando o servlet ListarAlunosPrintResponseServlet pois � essa classe que, devido a anota��o abaixo,
//est� respons�vel por atender as requisi��es a essa URL.
@WebServlet(urlPatterns="/listarAlunosPrintResponse")
public class ListarAlunosPrintResponseServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//req = Request (Requisi��o)
	//resp = Response (Resposta)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Espec�ficamos o tipo de retorno que o servidor enviar�.
		resp.setContentType("text/html");
		
		//Tentamos recuperar os par�metros "nome" e "age" da requisi��o.
		String paramNome = req.getParameter("nome");
		String paramIdade = req.getParameter("idade");
		
		//A partir do objeto de response da API de servlets obtemos uma stream para escrita.
		PrintWriter out = resp.getWriter();
		
		//Escrevemos manualmente o que ser� retornado ao cliente.
		out.write("<html><body><div id='parametros'>");
		out.write("<h1>Par�metros enviados ao servidor: </h1>");
		if(StringUtils.isNotEmpty(paramNome)) {
			out.write("<p> Nome: " + paramNome + "</p>");
		}
		
		if(StringUtils.isNotEmpty(paramIdade)) {
			out.write("<p> Idade: " + paramIdade + "</p>");
		}
		
		if(StringUtils.isEmpty(paramNome) && StringUtils.isEmpty(paramIdade)) {
			out.write("<p> Nenhum par�metro enviado ao servidor </p>");
		}
		out.write("</body></html>");
		//Fechamos a stream de retorno
		out.close();
	}
	
}