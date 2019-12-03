package socket4.pgm4;

/*
 * HttpURLConnection class:
 * It is a predefined class in java.net package. It is used to establish connectivity with a particular
 * resource mentioned in the http URL and obtain information regarding the various http headers associated
 * with that website
 * 
 */

import java.net.*;

import java.io.*;
public class Pgm4
{
	
String urlstring="http://www.yahoo.com";
	
	void getValues()throws MalformedURLException,IOException
	{
		URL u1=new URL(urlstring);
		HttpURLConnection uc1=(HttpURLConnection)u1.openConnection();
		
		
		InputStream i1=uc1.getInputStream();
		
		System.out.println("\n The contents of the index.html file in the yahoo.com server are ");
		for(int i=1;i<=8;i++)//because there are 8 http headers
		{
			System.out.println("\n"+uc1.getHeaderFieldKey(i)+"  "+uc1.getHeaderField(i));
			//above statement returns the key and the corresponding value of the
			//http header of serial number i associated with the http protocol and associated
			//with the website yahoo.com
			
		}
		
	}
	

	public static void main(String[] args) throws MalformedURLException,IOException
	{
		// TODO Auto-generated method stub
		
		Pgm4 p3=new Pgm4();
		p3.getValues();

	}

}
