package filter2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;

import javax.servlet.http.*;


public class EmployeeFilterS implements Filter {
	
    public void init(FilterConfig fc)
    {
    	
    }
    
    public void destroy()
    {
    	
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain fc1)throws ServletException
    {
    	//FilterChain is a predefined class of javax.servlet package and it is used to send the response to that web resource program to which the current
    	//servlet filter is mapped.
    	
    	//to map the filter to another servlet or html or jsp pgm, we will configure the web.xml file.
    	try
		{
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String pass=request.getParameter("epassword");
		
		if((uname.equals("")==true)||(uname==null)||(pass.equals("")==true)||(pass==null))
		{
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><center><h1>ALL FIELDS MUST BE COMPULSORILY FILLED</h1></center><br></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("EmployeeLogin.html");
			rd.include(request, response);
		}
		
		else
		{
					
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
					
					

					if(con!=null)
					{
					System.out.println("\n Connectivity is successfully established");
					Statement stmt=con.createStatement();
				
					int flag1=0;
					int flag2=0;
					String ename=null;
					String egender=null;
					int eid=0;
						ResultSet rs=stmt.executeQuery("select * from employeenew");
						
					while(rs.next())
					{
					
						String uname1=rs.getString(7);
						String pass1=rs.getString(8);
						if(uname.equalsIgnoreCase(uname1)==true)
						{
							flag1=1;
							if(pass.equals(pass1)==true)
							{
								flag2=1;
								ename=rs.getString(1);
								eid=rs.getInt(2);
								egender=rs.getString(3);
								
								
								break;
							}
						}
						
					}
					
					if(flag1==0)
					{
						PrintWriter pw=response.getWriter();
						pw.println("<html><body><center><h1>THE ENTERED USERNAME DOESNT EXIST. PLEASE ENTER PROPER USERNAME AND PASSWORD</h1></center><br></body></html>");
						RequestDispatcher rd=request.getRequestDispatcher("EmployeeLogin.html");
						rd.include(request, response);
						
					}
					
					else if((flag1==1)&&(flag2==0))
					{
						PrintWriter pw=response.getWriter();
						pw.println("<html><body><center><h1>THE PASSWORD IS INCORRECT.</h1></center><br><form action='EmployeeLoginS' method='post'><b><font size='5'>ENTER EMPLOYEE USERNAME:<input type='text' name='uname' value='"+uname+"'><br>ENTER EMPLOYEE PASSWORD:<input type='password' name='epassword'><br></font></b><input type='submit' value='SUBMIT'></form></body></html>");
						
						
					}
					
					else 
					{
						fc1.doFilter(request, response);
						
						//forwards the request and response objects to the servlet or web resource pgm which is mapped to this filter pgm
					
						
					
					
					
					
					
					}
					
					}
		
					
					}
		}
		
		catch(Exception e1)
		{
			
		}
		
		

    	
    }
}
