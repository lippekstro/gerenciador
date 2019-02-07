package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/controlador") os filtros nao tem ordem definida no tomcat se usarmos dessa maneira, mudamos o uso para definicoes no arquivo web.xml
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehAcaoProtegida = !(paramAcao.equals("ChamaLogin")||paramAcao.equals("Login"));
		
		if(usuarioNaoLogado && ehAcaoProtegida) {
			response.sendRedirect("controlador?acao=ChamaLogin");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
