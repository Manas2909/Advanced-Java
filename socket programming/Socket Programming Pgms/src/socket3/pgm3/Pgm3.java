/*
 * URLConnection class:
 * It is a predefined class in java.net package. It is used to establish connectivity with a particular
 * resource mentioned in the URL and obtain all the contents of that resource.
 */
package socket3.pgm3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
public class Pgm3 {
	
String urlstring="http://www.yahoo.com:80/index.html";
	
	void getValues()throws MalformedURLException,IOException
	{
		URL u1=new URL(urlstring);
		URLConnection uc1=u1.openConnection();
		
		InputStream i1=uc1.getInputStream();
		//getInputStream() is a predefined non static member method of the java.net.URLConnection class
		//and uc1.getInputStream() returns the implicit object of the java.io.InputStream interface
		//and this implicit object assigned to reference variable i1 of java.io.InputStream interface
		//can be used to read the contents of the resource index.html in the url object
		//associated with teh URLConnection object uc1 using which we obtained the implicit object of the
		//java.io.InputStream interface
		
		System.out.println("\n The contents of the index.html file in the yahoo.com server are ");
		int m=0;
		while((m=i1.read())!=-1)
		{
			System.out.print((char)m);
		}
		
		
	}
	

	public static void main(String[] args) throws MalformedURLException,IOException
	{
		// TODO Auto-generated method stub
		
		Pgm3 p3=new Pgm3();
		p3.getValues();

	}

}
