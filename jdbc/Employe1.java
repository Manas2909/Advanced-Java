package pack1.emp1;

import java.io.*;
import java.util.Scanner;

public class Employee1
{

	String ename;
	int eid;
	String egender;
	float esalary;
	int eage;
	String cname;

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Scanner sc=new Scanner(System.in);

	public Employee1()throws IOException
	{
		System.out.println("\n Enter employee id:");
		eid=sc.nextInt();

		System.out.println("\n Enter employee name:");
		ename=br.readLine();

		
		System.out.println("\n Enter employee gender:");
		egender=br.readLine();

		System.out.println("\n Enter employee salary:");
		esalary=Float.parseFloat(sc.next());


		System.out.println("\n Enter employee age:");
		eage=sc.nextInt();


		System.out.println("\n Enter employee company name:");
		cname=br.readLine();
	
		
	



	}

	public String getName()
	{
		return ename;

	}


	public int getId()
	{
		return eid;

	}

	public String getGender()
	{
		return egender;

	}

	public int getAge()
	{
		return eage;

	}

	public int getSalary()
	{
		return esalary;

	}

	public String getCName()
	{
		return cname;

	}

	void display()
	{
		System.out.println("\n The employee name is "+ename+"\n The employee id is "+eid+"\n The employee gender is "+egender+"\n The employee salary is "+esalary+"\n The employee age is "+eage+"\n The employee company name is "+cname);

	}


}