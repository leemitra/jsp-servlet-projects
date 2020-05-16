package com.test;

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

/**
 * Servlet Filter implementation class AppFilter
 */
@WebFilter( urlPatterns= {"/app/list","/app/users" })
public class AppFilter implements Filter {

 
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletResponse res=(HttpServletResponse) response;
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String userid= (String) session.getAttribute("userid");
		System.out.println("inside filter");
		// pass the request along the filter chain
		
		if(userid !=null) {
			chain.doFilter(request, response);	
		}else {
		
			res.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
