package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.entity.UserDetails;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/*String fname = request.getParameter("fname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println("Fullname is : "+fname+" email : "+email);*/
		String operation = request.getParameter("option");
		UserDetails user=(UserDetails) request.getAttribute("userData");
		System.out.println(user.getFullName() +" user full name and email : "+user.getEmail());
		try {
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			//ResultSet rs= st.executeQuery("select *from user_login where user_name='"+username+"' and user_pass='"+password+"'");
			String query="insert into user_login (user_name,user_pass,full_name,email, phone) "
					+ "values ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFullName()+"','"+user.getEmail()+"','"+user.getPhone()+"')";
			int i=st.executeUpdate(query);
			if(i>0) {
				response.getWriter().append("User added successfully...");
			}else {
				response.getWriter().append("Failed to add user...");
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
