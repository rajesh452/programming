package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("do post");
		String userId= request.getParameter("user");
		String password=request.getParameter("pass");
		LoginDAO loginDAO= new LoginDAO();
		RequestDispatcher dispatcher;
		if(loginDAO.isValidUser(userId, password)==true)
		{
			dispatcher= request.getRequestDispatcher("home.html");
			dispatcher.forward(request,response);
		}
		else
		{
			dispatcher= request.getRequestDispatcher("login page.html");
		    PrintWriter writter= response.getWriter();
		    writter.append("Invalid user name and password ...try again");
		    dispatcher.include(request,response);
		}
	}

}
