package com.durga.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.write("<h1>This is my first servlet</h1><hr>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		 response.setContentType("text/html");  
		 PrintWriter out=response.getWriter();  
	     request.getRequestDispatcher("welcome.jsp").include(request, response);
	     String name = request.getParameter("name");  
	     String password = request.getParameter("password");
	     if(password.equals("prasanna")){  
	            out.print("You are successfully logged in!");  
	            out.print("<br>Welcome, "+name); 
	     }
	            else
	            {
	            	out.print("sorry, username or password error!");  
	                request.getRequestDispatcher("test.html").include(request, response);  
	            }
	     out.close();
	}

}
