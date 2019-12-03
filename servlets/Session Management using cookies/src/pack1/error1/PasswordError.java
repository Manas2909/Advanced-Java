package pack1.error1;

import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class PasswordError extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><center><h1>THE 2 PASSWORDS DONOT MATCH. PLEASE SIGN UP AGAIN </h1></center><br></body></html>");
		
		RequestDispatcher rd=request.getRequestDispatcher("EmployeeSignup.html");
		rd.include(request, response);
		
	}

}
