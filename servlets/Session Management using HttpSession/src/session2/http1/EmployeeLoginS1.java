package session2.http1;




import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;
import java.sql.*;

public class EmployeeLoginS1 extends HttpServlet
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
						pw.println("<html><body><center><h1>THE PASSWORD IS INCORRECT.</h1></center><br><form action='EmployeeLoginS' method='post'><b><font size='5'>ENTER EMPLOYEE USERNAME:<input type='text' name='uname' value='"+uname+"'><br>ENTER EMPLOYEE PASSWORD:<input type='password' name='epassword'><br></font></b><input type='submit' value='SUBMIT'></form></body></html>");
						
						
					}
					
					else 
					{
						
						HttpSession hs=request.getSession();
						hs.setAttribute("username", uname);
						hs.setAttribute("password", pass);
						/*
						 * setAttribute() is a predefined non static member method of javax.servlet.http.HttpSession class
						 * and the above statements hs.setAttribute() are adding 2 attributes or parameters to the HttpSession class 
						 * object one attribute having name as username and its value is the value of String variable uname and
						 * 2nd attribute having name as password and its value is value of String variable pass.
						 * 
						 */
						hs.setAttribute("employeename", ename);
						hs.setAttribute("employeegender", egender);
						hs.setAttribute("employeeid", Integer.toString(eid));
						
						
					PrintWriter pw=response.getWriter();
					
					
					
					
					RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
					rd.include(request, response);
					
					
					
					
					
					}
					
					}
		
					
					}
		}
		
		catch(Exception e1)
		{
			
		}
		
		
	}

}
