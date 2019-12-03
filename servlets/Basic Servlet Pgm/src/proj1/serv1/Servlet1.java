package proj1.serv1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;


public class Servlet1 extends HttpServlet
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
			doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	Date d1=new Date();
	//Date is a predefined class in java.util package and its object stores the system date and time
	
	String str=d1.toString();
	PrintWriter pw=response.getWriter();
	/*
	 * response.getWriter() where getWriter() is a predefined non static member method of the javax.servlet.HttpServletResponse class, will return the implicit object
	 * of java.io.PrintWriter class and whatever data we write inside the PrintWriter class object will automatically be sent back to client as a web page or html page.
	 * 
	 */
	
	pw.println(str);
	//above statement where println() is a predefined non static member method of java.io.PrintWriter class will write the data to be sent as a response
	//to client into the PrintWriter class object pw and this data is automatically sent back by the web server as a response in form of html page back to client
	
	}

}
