/*

write a java pgm to accept employee details from keyboard and store them in table using dyanamic sql query

*/

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import pack1.emp1.Employee;


public class Jdbc3
{
	public void load1()throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");

	}


	public void connect1()throws SQLException,ClassNotFoundException,IOException
	{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");
		
		

		if(con!=null)
		{
		System.out.println("\n Connectivity is successfully established");
		Statement stmt=con.createStatement();
		try
		{
			stmt.executeUpdate("create table employee2(eid int,ename varchar(100),egender varchar(10),esalary float,eage int,cname varchar(100))");


		}


		catch(Exception e1)
		{


		}
			Employee e1=new Employee();
			PreparedStatement stmt1=con.prepareStatement("insert into employee2 values(?,?,?,?,?,?)");
/*
PreparedStatement is a predefined interface of java.sql package. prepareStatement() is a predefined non static member method of the java.sql.Connection interface. con.prepareStatement() returns an implicit object of the PreparedStatement interface. We have passed a dyanamic insert query as argument to con.prepareStatement() where the 6 ? symbols, represent the dyanamic data to be stored into the query at runtime before the query is sent to the database. The data represented by the question mark symbol in the dyanamic query may vary as per the nature of the query. Because the above query is an insert query, so the 6 ? symbols represent the 6 columns of the employee2 table.



*/
		String name=e1.getName();
		int id=e1.getId();
		String gender=e1.getGender();
		float salary=e1.getSalary();
		int age=e1.getAge();
		String cname=e1.getCName();

		stmt1.setInt(1,id);
		stmt1.setString(2,name);
		stmt1.setString(3,gender);
		stmt1.setFloat(4,salary);
		stmt1.setInt(5,age);
		stmt1.setString(6,cname);
/*
stmt1.setInt(),.... etc. non static member methods of the PreparedStatement interface, will set the values of the 6 ? symbols in the dyanamic insert query and so those question mark symbols wll be replaced by the variable values in the query to complete the dyanamic insert query.

*/

		stmt1.executeUpdate();
//executeUpdate() is also a non static member method of the PreparedStatement interface and when //called on the PreparedStatement interface object, no argument is passed to it. 
//PreparedStatement is a predefined subclass of the java.sql.Statement interface


		stmt1=con.prepareStatement("select * from employee2");
		ResultSet rs=stmt1.executeQuery();

		System.out.println("\n The current employees in the table are ");

		int i=1;
		while(rs.next())
		{
		System.out.println("\n\n Employee details of employee no:"+i+" are "+"\n Employee id:"+rs.getInt(1)+"\n Employee Name:"+rs.getString(2)+"\n Employee Gender:"+rs.getString(3)+"\n The employee salary is:+rs.getFloat(4)+"\n Employee age:"+rs.getInt(5)+"\n Employee company name:"+rs.getString(6));

		}


				

		}

	}

	public static void main(String args[])throws SQLException,ClassNotFoundException,IOException
	{
		Jdbc3 j1=new Jdbc3();
		j1.loadDriver1();
		j1.connect1();		

	}

}