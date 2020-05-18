package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.entity.UserDetails;

/**
 * Servlet implementation class UpdateUserServlet
 */
//@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*int id = Integer.parseInt(request.getParameter("userid"));
		System.out.println("request user to update "+id);
		try {
			
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select *from user_login where id='"+id+"'");
		
			if(rs.next()) {
				
			 
			 UserDetails user = new UserDetails();
			 user.setEmail(rs.getString("email"));
			 user.setPhone(rs.getString("phone"));
			 user.setFullName(rs.getString("full_name"));
			 user.setPassword(rs.getString("user_pass"));
			 user.setUsername(rs.getString("user_name"));
			 user.setId(id);
			 request.setAttribute("user", user);
			}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		request.getRequestDispatcher("update.jsp").forward(request, response);
		*/
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
