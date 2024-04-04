package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWordServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"utf-8\">\r\n"
				+ "<title>Página01</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	\r\n"
				+ "	<h1>HelloWord</h1>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");		
	}

}