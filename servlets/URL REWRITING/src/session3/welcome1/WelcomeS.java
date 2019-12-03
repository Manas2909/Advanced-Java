package session3.welcome1;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class WelcomeS extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
			String employeename=request.getParameter("ename1");
			String employeeid=request.getParameter("eid1");
			String employeegender=request.getParameter("egender1");
			
		
			
			
				if(employeegender.equals("male")==true)
				{
					pw.println("<html><body>Mr.</body></html>");
					
					
					
				}
				
				else
				{
					pw.println("<html><body>Mrs./Miss.</body></html>");
					
					
				}
			
			
					pw.println("<html><body>"+employeename+"</body></html>");
					
					
					
				
					pw.println("<html><body>. Your id is "+employeeid+"</body></html>");
					
					
					
				
			
			
		
				
		pw.println("<html><body><br><br><a href='HomePage.html'>GO BACK TO HOME PAGE</a></body></html>");
		
	}

}
