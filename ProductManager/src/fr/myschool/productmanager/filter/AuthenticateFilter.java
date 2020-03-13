package fr.myschool.productmanager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {				
		String username = (String) ((HttpServletRequest) request).getSession().getAttribute("username");
		if (username != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/ProductManager/login");
		}
	}	
}
