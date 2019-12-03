/*

write a java pgm to accept employee details from keyboard and store them in table using dyanamic sql query and transaction management

*/

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import pack1.emp1.Employee1;


public class Jdbc4
{
	public void load1()throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");

	}


	public void connect1()throws SQLException,ClassNotFoundException,IOException
	{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1",root","root");
		
		

		if(con!=null)
		{
		System.out.println("\n Connectivity is successfully established");
		con.setAutoCommit(false);
		Statement stmt=con.createStatement();
		try
		{
			stmt.executeUpdate("create table employee3(eid int,ename varchar(100),egender varchar(10),esalary float,eage int,cname varchar(100))");


		}


		catch(Excepton e1)
		{


		}
			Employee1 e1=new Employee1();
			PreparedStatement stmt1=con.prepareStatement("insert into employee3 values(?,?,?,?,?,?)");

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


		stmt1.executeUpdate();

		con.commit();

		stmt1=con.prepareStatement("select * from employee3");
		System.out.println("\n The current employees in the table are ");

		int i=1;

		ResultSet rs=stmt1.executeQuery();
	

		while(rs.next())
		{
		System.out.println("\n\n Employee details of employee no:"+i+" are "+"\n Employee id:"+rs.getInt(1)+"\n Employee Name:"+rs.getString(2)+"\n Employee Gender:"+rs.getString(3)+"\n The employee salary is:+rs.getFloat(4)+"\n Employee age:"+rs.getInt(5)+"\n Employee company name:"+rs.getString(6));

		}


				

		}

	}

	public static void main(String args[])throws SQLException,ClassNotFoundException,IOException
	{
		Jdbc4 j1=new Jdbc4();
		j1.loadDriver1();
		j1.connect1();		

	}

}