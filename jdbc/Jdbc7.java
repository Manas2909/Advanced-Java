/*

write a java pgm to obtain information about th employee4 table in the mysql sub database  named database1 and then also obtain information regarding the sub database database1.

*/

import java.sql.*;



public class Jdbc7
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
		PreparedStatement stmt1=con.prepareStatement("select * from employee4");		
		ResultSet rs=stmt1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
/*
getMetaData() is a non static member method of the java.sql.ResultSet interface and it returns the implicit object of the ResulSetMetaData interface of java.sql package. So the above object rsmd of the ResultSetMetaData interfacecn be used obtain information regarding the structure of the employee4 table associated with the ResultSet object rs.

*/
			int no_of_columns=rsmd.getColumnCount();
//rsmd.getColumnCount() where getColumnCount() is a non static member method of //java.sql.ResultMetaData interface returns the total number of columns of the employee4 table //associated with the ResultSet interface object rs.

			System.out.println("\n The information regarding the structure of employee4 table is ");

			for(int i=1;i<=no_of_columns;i++)
			{
				System.out.println("\n\n Column No:"+i+"\n Column Name:"+rsmd.getColumnName(i)+"\n Column Type:"+rsmd.getColumnTypeName(i));

			}

/*
rsmd.getColumnName(i) and rsmd.getColumnTypeName(i)  where getColumnName() and getColumnTypeNmae() are non static member methods of //java.sql.ResultMetaData interface and rsmd.getColumnName(i) returns the name of column of column no. i and rsmd.getColumnTypeName(i) returns the data type name of the column of column no. i of the employee 4 table associated with the ResultSet object rs.

*/
	
			DatabaseMetaData dsmd=con.getMetaData();
/*
getMetaData() is also a non static member method of the java.sql.Connection interface and it returns the implicit object of the DatabaseMetaData interface of java.sql package. So the above object dsmd of the DatabaseMetaData interface can be used obtain information regarding the structure of the entire sub database named database1 in mysql database associated with the Connection interface con.


*/
			

			System.out.println("\n The information regarding the structure of database is ");

			System.out.println("\n Database name is "+dsmd.getDatabaseName()+"\n Database Driver name is "+dsmd.getDriverName()"\n Database version name is "+dsmd.getDatabaseVersion()+"\n Database driver version name is "+dsmd.getDriverVersion());

//getDatabaseName()..... etc. are the non static member methods of java.sql.DatabaseMetaData //interface



		}

	}

	public static void main(String args[])throws SQLException,ClassNotFoundException,IOException
	{
		Jdbc7 j1=new Jdbc7();
		j1.loadDriver1();
		j1.connect1();		

	}

}