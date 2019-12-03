package cookie1.login1;




import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;
import java.sql.*;

public class EmployeeLoginS2 extends HttpServlet
{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
						pw.println("<html><body><center><h1>THE PASSWORD IS INCORRECT.</h1></center><br><form action='EmployeeLoginS2' method='post'><b><font size='5'>ENTER EMPLOYEE USERNAME:<input type='text' name='uname' value='"+uname+"'><br>ENTER EMPLOYEE PASSWORD:<input type='password' name='epassword'><br></font></b><input type='submit' value='SUBMIT'></form></body></html>");
						
						
					}
					
					else 
					{
						
						Cookie ck1=new Cookie("employeename", ename);
						Cookie ck2=new Cookie("employeeid", Integer.toString(eid));
						Cookie ck3=new Cookie("employeegender", egender);
						
					PrintWriter pw=response.getWriter();
					
					
					response.addCookie(ck1);
					response.addCookie(ck2);
					response.addCookie(ck3);
					
					RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
					rd.include(request, response);
					
					
					
					
					
					/*
					 * Servlet chaining:
					 * in servlet chaining, a servlet is mapped to another web resource pgm like abnother servlet page or html page.
					 * There are 2 modes of servlet chaining:
					 * 1. forward mode:
					 * in this mode, the servlet will forward the request it recieves to another servlet or another jsp page or another html page and
					 * that web resource pgm like servlet/jsp/html page will then send the response back to the client and the response of the 1st servlet
					 * which forwarded the request is not even considered.
					 * 
					 * 2. include mode:
					 * in this mode, the servlet will forward the request it recieves to another servlet or another jsp page or another html page and
					 * that web resource pgm like servlet/jsp/html page will then send the response back to the 1st servlet and the 1st servlet will include the response of
					 * that web resource pgm into its own servlet response and the combined rresponse is sent as the final response
					 * of the 1st servlet back to the client.
					 * 
					 * RequestDispatcher is a predefined class of javax.servlet package and it is used to create the chain of servlet with another web resource pgm
					 * like another servlet/jsp/html page.
					 * 
					 * the getRequestDispatcher() is a predefined non static member method of the javax.servlet.RequestDispatcher class
					 * and the above request.getRequestDispatcher("HomePage.html") statement will return an implicit object of the javax.servlet.RequestDispatcher
					 * class and map the current servlet pgm EmployeeSignUpS.java in which we have executed the above code with the HomePage.html file through the
					 * RequestDispatcher class object rd.
					 * 
					 */
					
					}
					
					}
		
					
					}
		}
		
		catch(Exception e1)
		{
			
		}
		
		
	}

}
