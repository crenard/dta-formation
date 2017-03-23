package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/pizzas/*", "/technique" })
public class AuthentificationFilter implements Filter {

	private FilterConfig config = null;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest reqHttp = ((HttpServletRequest) request);
		HttpSession session = reqHttp.getSession();
		Object login = session.getAttribute("login");
		Object password = session.getAttribute("password");
		if (login == null || password == null) {
			session.setAttribute("errorMsg", "Veuillez vous identifier");
			((HttpServletResponse) response).sendRedirect(reqHttp.getContextPath() + "/login");
		} else if (!"admin@pizzeria.fr".equalsIgnoreCase(login.toString())
				|| !"admin".equalsIgnoreCase(password.toString())) {
			session.setAttribute("errorMsg", "Login ou mot de passe incorrect");
			((HttpServletResponse) response).sendRedirect(reqHttp.getContextPath() + "/login");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
