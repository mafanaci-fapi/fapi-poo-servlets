package br.edu.fapi.poo.servlets.usuario.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.servlets.aluno.util.CookieUtils;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Trabalhando com session.
//		req.getSession().removeAttribute("usuario.logado");
//		req.getSession().invalidate();
		
		Cookie cookie = CookieUtils.getCookieUsuarioLogado(req);

		PrintWriter out = resp.getWriter();
		out.write("<html><body><div id='logout'>");

		if (cookie == null) {
			out.write("<h1>Usuário não estava logado</h1>");
			return;
		}
		out.write("<h1>Usuário deslogado</h1>");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		out.write("</body></html>");
		out.close();
	}

}
