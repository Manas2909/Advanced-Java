/*

write a java pgm to accept employee details from keyboard and store them in table using dyanamic sql query and transaction management

*/

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import pack1.emp1.Employee1;


public class Jdbc5
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
			stmt.executeUpdate("create table employee4(eid int,ename varchar(100),egender varchar(10),esalary float,eage int,cname varchar(100))");


		}


		catch(Exception e1)
		{



		}

			Scanner sc=new Scanner(System.in);
			int n=0;
			System.out.println("\n Enter how many employees data is to stored into the table ");
			n=sc.nextInt();

			int i=1;
			PreparedStatement stmt1=con.prepareStatement("insert into employee4 values(?,?,?,?,?,?)");


			while(i<=n)
			{

			Employee1 e1=new Employee1();
			
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
		stmt1.addBatch();
//addBatch() is a non static member method of the java.sql.PreparedStatement interface. The above //statement stmt1.addBatch() adds the complete dyanamic insert query associated with the //PreparedStatement interface implicit object stmt1, to the batch or group associated with the //stmt1 object. So everytime the loop runs, we are adding data in place of the ? symbols into the //dyanamic insert query associated with the stmt1 object and then we are adding the complete //dyanamic insert query to the batch or group associated with the stmt1 object



		}
		stmt1.executeBatch();
//executeBatch() is also a non static member method of the PreparedStatement interface and the //above statement stmt1.executeBatch() will send the entire batch or group of the dyananic insert //queries with complete data in them associated with the stmt1 object at once to the database


		con.commit();

		stmt1=con.prepareStatement("select * from employee4");
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
		Jdbc5 j1=new Jdbc5();
		j1.loadDriver1();
		j1.connect1();		

	}

}