package pack1.proj3;

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
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><br><b>The names and values of parameters passed to Serv1 servlet are </b><br></body></html>");
		Enumeration e=sc.getInitParameterNames();
		/*
		 * getInitParameterNames() is a predefined non static member method of the javax.servlet.ServletConfig interface
		 * and sc.getInitParameterNames() returns the names of all parameters passed to the current servlet Serv1 through the <init-param>
		 * tag in the <servlet> tag of the Serv1 servlet in web.xml file. Also sc.getInitParameterNames() returns the implicit object
		 * of java.util.Enumeration interface and using the above object e of java.util.Enumeration interface we can access
		 * the collection containing the names of all the local parameters passed to the Serv1 servlet through the
		 * <init-param> tag in the web.xml file.
		 *  
		 * 
		 */
		
		while(e.hasMoreElements())//checks whether there are any more parameter names remaining to be accessed in the collection 
		{
			String parametername=(String)(e.nextElement());
			//above statement returns the value of next element i.e. next parameter name in the collection
			//and the reference type of the element value returned by e.nextElement() is java.lang.Object
			//and so we have to explicitly convert the reference type of return value of e.nextElement() from java.lang.Object
			//to java.lang.String class
			
			String parametervalue=sc.getInitParameter(parametername);
			//above statement returns the value of the parameter in String format where the parameter name has been
			//passed as string argument to sc.getInitParameter()
			
			pw.println("<html><body><b>PARAMETER NAME:"+parametername+"&nbsp;&nbsp;&nbsp;PARAMETER VALUE:"+parametervalue+"</body></html>");
		}
	
	}

}
