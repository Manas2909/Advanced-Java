package proj2.signup;

import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;
import java.sql.*;

public class EmployeeSignupS extends HttpServlet
{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		// TODO Auto-generated method stub
		String ename=request.getParameter("ename");
		//getParameter() is a predefined non static member method of the HttpServletRequest class and it is used to obtain the value typed or selected by the user
		//in the field whose logical name ie ename in the form on html page whose data after submission was sent to this servlet.
		String eid=request.getParameter("eid");
		String egender=request.getParameter("egender");
		String languages[]=request.getParameterValues("elanguage");
		//getParameterValues() is a predefined non static member method of the HttpServletRequest class and it is used to obtain the multiple values typed or selected by the user
				//in the field whose logical name is elanguage in the form on html page whose data after submission was sent to this servlet.
		
			
		String eaddress=request.getParameter("eaddress");
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		String pass1=request.getParameter("epassword1");
		String pass2=request.getParameter("epassword2");
		
		if((ename.equals("")==true)||(ename==null)||(eid.equals("")==true)||(eid==null)||(languages==null)||(eaddress.equals("")==true)||(eaddress==null)||(email.equals("")==true)||(email==null)||(uname.equals("")==true)||(uname==null)||(pass1.equals("")==true)||(pass1==null)||(pass2.equals("")==true)||(pass2==null))
		{
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><center><h1>ALL FIELDS MUST BE COMPULSORILY FILLED</h1></center><br></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("EmployeeSignup.html");
			rd.include(request, response);
		}
		
		else
		{
			if(pass1.equalsIgnoreCase(pass2)==true)
			{
			
String language="";
		
		for(int i=0;i<languages.length;i++)
		{
			language=language+languages[i]+" ";
		}
			
		
			
		
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","root");
					
					

					if(con!=null)
					{
					System.out.println("\n Connectivity is successfully established");
					Statement stmt=con.createStatement();
				
						PreparedStatement stmt1=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
			/*
			PreparedStatement is a predefined interface of java.sql package. prepareStatement() is a predefined non static member method of the java.sql.Connection interface. con.prepareStatement() returns an implicit object of the PreparedStatement interface. We have passed a dyanamic insert query as argument to con.prepareStatement() where the 6 ? symbols, represent the dyanamic data to be stored into the query at runtime before the query is sent to the database. The data represented by the question mark symbol in the dyanamic query may vary as per the nature of the query. Because the above query is an insert query, so the 6 ? symbols represent the 6 columns of the employee2 table.



			*/
					

					stmt1.setString(1,ename);
					stmt1.setInt(2,Integer.parseInt(eid));
					stmt1.setString(3,egender);
					stmt1.setString(4,language);
					stmt1.setString(5,eaddress);
					stmt1.setString(6,email);
					stmt1.setString(7,uname);
					stmt1.setString(8,pass1);
					
					
			/*
			stmt1.setInt(),.... etc. non static member methods of the PreparedStatement interface, will set the values of the 6 ? symbols in the dyanamic insert query and so those question mark symbols wll be replaced by the variable values in the query to complete the dyanamic insert query.

			*/

					stmt1.executeUpdate();
					
					PrintWriter pw=response.getWriter();
					pw.println("<html><body><center><h1>THE REGISTRATION IS COMPLETED</h1></center><br></body></html>");
					RequestDispatcher rd=request.getRequestDispatcher("HomePage.html");
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
					
					rd.include(request, response);
					//include() is a predefined non static member method of the javax.servlet.RequestDispatcher class
					// and the above statement rd.include(request,response) is using include mode of servlet chaining
					//to map the current servlet pgm with HomePage.html file
					//so the contents of the HomePage.html file will be included in the response of the current servlet pgm
					
					

		}
					
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("PasswordError");
						rd.forward(request, response);
						//forward() is a predefined non static member method of the javax.servlet.RequestDispatcher class
						// and the above statement rd.forward(request,response) is using forward mode of servlet chaining
						//to map the current servlet pgm with servlet pgm whose url pattern is /PasswordError in web.xml file
						
						//so only the contents of the servlet java pgm whose url pattern is /PasswordError will be sent back to the client
						//and none of the response of the current servlet pgm EmployeeSignupS.java will be sent to the client
						
						
					}
			
			}
		
		}
		}
		
		catch(Exception e1)
		{
			
		}
		
		
	}

}
