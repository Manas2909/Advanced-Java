package pack1.proj4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Serv1 extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletConfig sc=this.getServletConfig();
		/*
		 * getServletConfig() is a predefined non static member method of the javax.servlet.Servlet interface and the this.getServletConfig()
		 * returns the implicit object of the ServletConfig interface using which we can obtain the parameter names and values
		 * of all local parameters passed to the servlet through the <init-param> tag.
		 *  
		 */
		ServletContext sc1=sc.getServletContext();
		/*
		 * getServletContext() is a predefined non static member method of the javax.servlet.ServletConfig interface and the sc.getServletContext()
		 * returns the implicit object of the ServletContext interface using which we can obtain the parameter names and values
		 * of all global parameters passed to the all the servlets through the <context-param> tag.
		 *  
		 */
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><br><b>The names and values of global parameters are </b><br></body></html>");
		Enumeration e=sc1.getInitParameterNames();
		
		
		while(e.hasMoreElements())//checks whether there are any more parameter names remaining to be accessed in the collection 
		{
			String parametername=(String)(e.nextElement());
			
			String parametervalue=sc1.getInitParameter(parametername);
		
			
			pw.println("<html><body><b>PARAMETER NAME:"+parametername+"&nbsp;&nbsp;&nbsp;PARAMETER VALUE:"+parametervalue+"</body></html>");
		}
	
	}

}
