package com.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.entity.UserDetails;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url=request.getServletPath();
		System.out.println(url +" request servlet path ");
		switch (url) {
		case "/login":
				loginAction(request,response);
			break;

		case "/logout":
			logoutAction(request, response);
			break;
		case "/register":
			registerAction(request, response);
			break;
		case "/deleteUser":
			deleteAction(request, response);
			break;
		case "/updateUserDetails":
			updateuserAction(request, response);
			break;
			
		case "/updateUser":
			updateUsersData(request, response);
			break;
		default:
			break;
		}
		
	}

	private void updateUsersData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("userid"));
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
	
	}

	private void updateuserAction(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDetails user=(UserDetails) request.getAttribute("userData");
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
		}
	}

	private void deleteAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
int id = Integer.parseInt(request.getParameter("userId"));
		
		try {
			
			Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			int rs= st.executeUpdate("delete from user_login where id='"+id+"'");
		if(rs>0) {
			System.out.println("delete done "+rs);
		}else {
			System.out.println("delete failed");
		}
			 HttpSession session = request.getSession();
			 UserService service = new UserService();
			 List<UserDetails> list = service.getAllUsers();
			 
				session.setAttribute("list", list);
				response.sendRedirect("home.jsp");
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void registerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		 EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		 EntityManager manager= emf.createEntityManager();
		
		String operation = request.getParameter("option");
		UserDetails user=(UserDetails) request.getAttribute("userData");
		System.out.println(user.getFullName() +" user full name and email : "+user.getEmail());
		try {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			
			/*Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			//ResultSet rs= st.executeQuery("select *from user_login where user_name='"+username+"' and user_pass='"+password+"'");
			String query="insert into user_login (user_name,user_pass,full_name,email, phone) "
					+ "values ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFullName()+"','"+user.getEmail()+"','"+user.getPhone()+"')";
			int i=st.executeUpdate(query);
			if(i>0) {
				response.getWriter().append("User added successfully...");
			}else {
				response.getWriter().append("Failed to add user...");
			}*/
			System.out.println("User registered successfully...");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}
		
	}

	private void logoutAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("userid");
		session.invalidate();
		System.out.println("logout called");
		response.sendRedirect("index.jsp");
	}

	private void loginAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetails user= (UserDetails)request.getAttribute("loginUser");
		System.out.println("user name : "+user.getUsername() +"  and password : " +user.getPassword());
		 EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		 EntityManager manager= emf.createEntityManager();
		
		try {
			Query query= manager.createQuery("select a from UserDetails a where username=:u and password=:p");
			query.setParameter("u", user.getUsername());
			query.setParameter("p", user.getPassword());
			UserDetails dbuser = (UserDetails)query.getSingleResult();
			
			 
			if(dbuser.getUsername()!=null) {	
			 HttpSession session = request.getSession();
			 UserService service = new UserService();
			 List<UserDetails> list = service.getAllUsers();
				//String uid= rs.getString("user_name");
				//String pass=rs.getString("user_pass");
			session.setAttribute("userid", dbuser.getUsername());
				System.out.println("DB username : "+dbuser.getUsername() +" and pass : "+dbuser.getPassword()) ;
				session.setAttribute("list", list);
				response.sendRedirect("home.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}
		
	}

}
