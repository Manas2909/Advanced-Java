package socket7.pgm7;

import java.io.*;
import java.net.*;
//udp server
public class Pgm7
{

	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		DatagramSocket s=new DatagramSocket(1600,InetAddress.getByName("localhost"));
		//above statement creates a DatagramSocket on this machine for server with port number 1500 and whose ip address is returned by InetAddress.getByName("localhost" where the string "localhost" represents the host name of current pc
		
		byte buf[]=new byte[500];
		
		while(true)
		{
			DatagramPacket d1=new DatagramPacket(buf, buf.length);
			/*
			 * above statement creates a new object of java.net.DatagramPacket class where the above DatagramPacket
			 * object is to be read from client at server. The data is read into the DatagramPacket object
			 * using using 1d byte array buf,  the maximum no. of bytes to be read is represented
			 * by buf.length.
			 */
			
			s.receive(d1);
			//data is read from client into the DatagramPacket object d1 at server side
			
			String str=new String(d1.getData(),0,d1.getLength());
			
			if((str.equalsIgnoreCase("exit"))==true)
			{
				
				System.exit(1);
			}
			
			System.out.println("\nCLIENT:"+str);
			
			System.out.print("\nSERVER:");
			
			str=br.readLine();
			
			DatagramPacket d2=new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 1500);
			
			
			/*
			 * above statement creates a new object of java.net.DatagramPacket class where the above DatagramPacket
			 * object is to be sent to server. The data in the DatagramPacket object is obtained
			 * using str.getBytes(), the length of the datagram packet in number of bytes is obtained from 2nd argumebt passed to constructor of java.net.DatagramPacket class, ip address 
			 * of pc on which server is running is obtained using 3rd argument passed to constructor of DatagramPacket class and port number of the server is obtained by 4th argument passed
			 * to constructor of DatagramPacket class.
			 *  
			 */
			
			
				
				
			
			s.send(d2);
			
			
			
		}
		
		
		
		
	}

}
