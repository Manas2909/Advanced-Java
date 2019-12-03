package cookie1.welcome1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class WelcomeS2 extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		Cookie arr[]=request.getCookies();
		
		for(Cookie ck1:arr)
		{
			String name=ck1.getName();
			String value=ck1.getValue();
			
			if(name.equals("employeegender")==true)
			{
				if(value.equals("male")==true)
				{
					pw.println("<html><body>Mr.</body></html>");
					break;
					
					
				}
				
				else
				{
					pw.println("<html><body>Mrs./Miss.</body></html>");
					break;
					
				}
			}
			
			
			
		}
		
		for(Cookie ck1:arr)
		{
			String name=ck1.getName();
			String value=ck1.getValue();
			
			if(name.equals("employeename")==true)
			{
					pw.println("<html><body><br>YOUR NAME IS"+value+"</body></html>");
					
					
				
			}
			
			
			else if(name.equals("employeeid")==true)
			{
					pw.println("<html><body><br>YOUR ID IS"+value+"</body></html>");
					
					
				
			}
			
			
		}
		
		pw.println("<html><body><br><br><a href='HomePage.html'>GO BACK TO HOME PAGE</a></body></html>");
		
	}

}
