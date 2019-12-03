/*
 * URL CLASS:
 * URL is a uniform resource locator. It is used to locate a resource or file anywhere on the network.
 * URL is a predefined class in java.net package.
 * 
 *  
 * 
 * */
 
//pgm to obtain all details regarding a url 

package socket2.pgm2;
import java.net.*;
public class Pgm2 
{
	String urlstring="http://www.yahoo.com:80/index.html";
	
	void getValues()throws MalformedURLException
	{
		URL u1=new URL(urlstring);
		System.out.println("\n Protocol name is "+u1.getProtocol()+"\n Host name of server is "+u1.getHost()+"\n Port number is "+u1.getPort()+"\n File name accessed is "+u1.getFile());;
		
	}
	public static void main(String[] args) throws MalformedURLException 
	{
		// TODO Auto-generated method stub
		Pgm2 p2=new Pgm2();
		p2.getValues();

	}

}
