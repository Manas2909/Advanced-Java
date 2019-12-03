package session3.http3;

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
		HttpSession hs=request.getSession(false);
		
		Enumeration e1=hs.getAttributeNames();
		
		while(e1.hasMoreElements())
		{
			String paramname=(String)e1.nextElement();
			String paramvalue=(String)hs.getAttribute(paramname);
		
			
			
			if(paramname.equals("employeegender")==true)
			{
				if(paramvalue.equals("male")==true)
				{
					pw.println("<html><body>Mr.</body></html>");
					
					
					
				}
				
				else
				{
					pw.println("<html><body>Mrs./Miss.</body></html>");
					
					
				}
			}
			
			if(paramname.equals("employeename")==true)
			{
				
					pw.println("<html><body>"+paramvalue+"</body></html>");
					
					
					
				
			}
			
			if(paramname.equals("employeeid")==true)
			{
				
					pw.println("<html><body>. Your id is "+paramvalue+"</body></html>");
					
					
					
				
			}
			
		}
				
		pw.println("<html><body><br><br><a href='HomePage.html'>GO BACK TO HOME PAGE</a></body></html>");
		
	}

}
