package br.edu.fapi.poo.servlets.usuario.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.fapi.poo.servlets.usuario.Usuario;
import br.edu.fapi.poo.servlets.usuario.service.LoginService;

@WebServlet(urlPatterns = "/loginSession")
public class LoginSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		PrintWriter out = resp.getWriter();

		boolean logado = loginService.login(usuario);
		out.write("<html><body><div id='login'>");
		if (logado) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			out.write("<h1>Usuário logado</h1>");
		} else {
			out.write("<h1>Usuário não logado</h1>");
		}
		out.write("</body></html>");
		out.close();
	}

}
