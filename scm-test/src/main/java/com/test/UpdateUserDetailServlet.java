package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.entity.UserDetails;

/**
 * Servlet implementation class updateUserDetailServlet
 */
//@WebServlet("/updateUserDetails")
public class UpdateUserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*UserDetails user=(UserDetails) request.getAttribute("userData");
		System.out.println(user.getFullName() +" user full name and email : "+user.getEmail());
		try {
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			String updateQuery="update user_login set user_name='"+user.getUsername()+"', user_pass ='"+user.getPassword()+"', email='"+user.getEmail()+"', "
					+ " phone='"+user.getPhone()+"', full_name='"+user.getFullName()+"' where id="+user.getId();
			int i =st.executeUpdate(updateQuery);
			System.out.println("result updated "+i);
			 HttpSession session = request.getSession();
			 UserService service = new UserService();
			 List<UserDetails> list = service.getAllUsers();
				session.setAttribute("list", list);
				response.sendRedirect("home.jsp");
			 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
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
