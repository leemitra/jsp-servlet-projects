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

import com.test.entity.BookDetails;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String url = request.getServletPath();
		System.out.println(url + " request servlet path ");
		switch (url) {
		case "/login":
			loginAction(request, response);
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

		case "/addBooks":
			addBooks(request, response);
			break;

		case "/updateBooks":
			updateBooks(request, response);
			break;
			
		default:
			break;
		}

	}

	private void updateBooks(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addBooks(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();
		BookDetails book = (BookDetails) request.getAttribute("book");
		System.out.println(book.toString());
		try {
			manager.getTransaction().begin();
			book.setStatus("NEW");
			manager.persist(book);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	private void updateUsersData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("userid"));
		System.out.println("request user to update " + id);
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			UserDetails user = (UserDetails)manager.find(UserDetails.class, id);
			manager.getTransaction().commit();
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.getRequestDispatcher("update.jsp").forward(request, response);

	}

	private void updateuserAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDetails user = (UserDetails) request.getAttribute("userData");
		System.out.println(user.getFullName() + " user full name and email : " + user.getEmail());

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();

		try {

			manager.getTransaction().begin();
			manager.merge(user);
			manager.getTransaction().commit();

			HttpSession session = request.getSession();
			List<UserDetails> list = manager.createQuery("select a from UserDetails a", UserDetails.class)
					.getResultList();

			session.setAttribute("list", list);
			response.sendRedirect("home.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}
	}

	private void deleteAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("userId"));

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();

		try {

			manager.getTransaction().begin();
			UserDetails user = manager.find(UserDetails.class, id);
			System.out.println("user exists"+ user.getEmail());
			manager.remove(user);
			manager.getTransaction().commit();

			HttpSession session = request.getSession();
			List<UserDetails> list = manager.createQuery("select a from UserDetails a", UserDetails.class)
					.getResultList();

			session.setAttribute("list", list);
			response.sendRedirect("home.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}
	}

	private void registerAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();

		String operation = request.getParameter("option");
		UserDetails user = (UserDetails) request.getAttribute("userData");
		System.out.println(user.getFullName() + " user full name and email : " + user.getEmail());
		try {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();

		
			System.out.println("User registered successfully...");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}

	}

	private void logoutAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		session.removeAttribute("userid");
		session.invalidate();
		System.out.println("logout called");
		response.sendRedirect("index.jsp");
	}

	private void loginAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetails user = (UserDetails) request.getAttribute("loginUser");
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager manager = emf.createEntityManager();

		try {
			Query query = manager.createQuery("select a from UserDetails a where username=:u and password=:p");
			query.setParameter("u", user.getUsername());
			query.setParameter("p", user.getPassword());
			UserDetails dbuser = (UserDetails) query.getSingleResult();

			if (dbuser.getUsername() != null) {
				HttpSession session = request.getSession();
				UserService service = new UserService();
				System.out.println(dbuser.toString());
				List<UserDetails> list = service.getAllUsers();
				
				String view="";
				if(dbuser.getRole().getRole().equals("ADMIN")) {
					view="admin.jsp";
				}else if (dbuser.getRole().getRole().equals("USER")) {
					view="home.jsp";
				}
				session.setAttribute("userid", dbuser.getUsername());
				System.out.println("DB username : " + dbuser.getUsername() + " and pass : " + dbuser.getPassword());
				session.setAttribute("list", list);
				response.sendRedirect(view);
			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			manager.close();
		}

	}

}
