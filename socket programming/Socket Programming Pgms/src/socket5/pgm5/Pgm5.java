package socket5.pgm5;
//InetAddress class
//it is a predefined class of java.net package and it is used to obtain 
//information about the host name and ip address of a particular host

import java.net.*;
public class Pgm5 {

	void getValues()throws UnknownHostException
	{
		InetAddress id=InetAddress.getByName("localhost");
		//above statement creates a new object of java.net.InetAddress class
		//associated with the pc whose hostname is local host i.e. in this case 
		//it is the pc on which this java pgm is running currently
		
		System.out.println("\n Host name:"+id.getHostName()+"\n Ip address:"+id.getHostAddress());
		
	}
	public static void main(String[] args) throws UnknownHostException
	{
		// TODO Auto-generated method stub

		Pgm5 p5=new Pgm5();
		p5.getValues();
	}

}
