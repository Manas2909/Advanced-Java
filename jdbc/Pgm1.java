/*
write a java pgm to connect to the oracle database



*/

package jdbc1.pack1;

import java.sql.*;

class Jdbc1
{

	void loadDriver1()throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
/*
there is a predefined class in java.lang package called as java.lang.Class class. The main use of the java.lang.Class predefined class is to load any class in RAM memory at runtime of the java pgm where the class name is supplied as a string argument to Class.forName().

forName() is a static member method of the java.lang.Class predefined class.

So the above statement Class.forName("com.mysql.jdbc.Driver") will load the jdbc type 4 driver class whose name is Driver and which is stored in package com.mysql.jdbc which is stored in the mysqlconnector.jar file. So we will need to first load the mysqlcnnector.jar file into the CLASSPATH of the java project in which we are executing the java pgm.

Class.forName() may cause a checked exception java.lang.ClassNotFoundException to occur so we need to compulsorily handle or declare the java.lang.ClassNotFoundException in the method definition in whose body we have called Class.forName().

so Class.forName() will load the type 4 jdbc driver class com.mysql.jdbc.Driver in RAM memory and inform the database mysql that which driver is being used by the jdbc java pgm to connect with it.



There is another way of loading the driver class in RAM memory. There is a predefined class called as DriverManager class of java.sql package and DriverManager.registerDriver(new com.mysql.jdbc.Driver()) will first create the explicit object of the jdbc type 4 driver class for mysql and during the creation of the jdbc type 4 driver class object the driver class will automatically be loaded into RAM memory and then the type 4 driver class name for mysql will be registered with the mysql database.

The registerDriver() is also a static member method of DriverManager class. 

DriverManager.registerDriver(new com.mysql.jdbc.Driver()) may cause a checked exception java.sql.SQLException to occur so we need to compulsorily handle or declare the java.sql.SQLException in the method definition in whose body we have called DriverManager.registerDriver().

The main disadvantage of the DriverManager.registerDriver() is that we need to pass an explicit object of the type 4 driver class as argument to DriverManager.registerDriver() to load it into RAM memory and so RAM memory gets wasted.

Also DriverManager.registerDriver() cannot be used to load other classes into the RAM memory and can be used to load only the driver classes of jdbc into RAM memory.

DriverManager is an abstract class of java.sql package.

*/

	}

	void connect1()throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");

/*
getConnection() is a predefined static member method of DriverManager class. In above statement we have passed the url of the database along with the user name and password of the database, each in string format as 1st and 2nd and 3rd arguments to DriverManager.getConnection().

in the url of the mysql database passed as 1st argument to DriverManager.getConnection(), jdbc is main protocol, mysql is the name of the database, localhost is the ip address or host name of the pc on which the mysql database is running, and because it is running on same pc as the client jdbc java pgm so we have mentioned the string name as loalhost instead of the ipaddress or host name in the url argument passed to getConnection(). 3306 is the port number on which mysql database listens to incoming clients. This port number can be anything and must be set when we install the mysql databas on the system. database1 is the name of the sub database in mysql in which we want to create tables and store data in the tables in the mysql database. So first we need to also create the database1 sub database in mysql database by going to mysql command prompt, typing password, then typing create database sub_database_name;

Connection is a predefined interface of java.sql package.

so suppose the DriverManager.getConnection() establishes the connection successfully with the mysql database then it returns an implicit object of java.sql.Conection interface which represents the logical connection between the jdbc pgm and database. But suppose the DriverManager.getConnection() doesnt establish the connectivity successfully with the mysql database then it returns null. The value returned by DriverManager.getConnection() is assigned to reference variable con of the java.sql.Connection interface.

*/
		if(con!=null)
		System.out.println("\n Connectivity is successfully established");


		else
		System.out.println("\n Connectivity is not successfully established");

	}

	public static void main(String args[])throws SQLException,ClassNotFoundException
	{
		Jdbc1 j1=new Jdbc1();
		j1.loadDriver1();
		j1.connect1();		

	}
}
