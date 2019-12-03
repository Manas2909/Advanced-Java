package socket6.pgm6;
//udp client
/*
 * In UDP, we have UDPDatagramSocket and UDPDatagramPacket.
 * 
 * UDPDatagramSocket represents the connection less and unsecure communication endpoints
 * between the client and server application when the data is transmitted using UDP protocol
 * between client and server.
 * 
 * UDPDatagramPacket represents the actual data in bytes transmitted using UDP protocol
 * between client and server.
 * 
 * 
 */

import java.net.*;
import java.io.*;

public class Pgm6{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket s=new DatagramSocket(1500);
		//above statement creates a DatagramSocket on this machine for client with port number 1500
		
		while(true)
		{
			//reading data from the keyboard of client and sending to server
			System.out.print("\nCLIENT:");
			String str=br.readLine();
			
			DatagramPacket d1=new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 1600);
			
			
			/*
			 * above statement creates a new object of java.net.DatagramPacket class where the above DatagramPacket
			 * object is to be sent to server. The data in the DatagramPacket object is obtained
			 * using str.getBytes(), the length of the datagram packet in number of bytes is obtained from 2nd argumebt passed to constructor of java.net.DatagramPacket class, ip address 
			 * of pc on which server is running is obtained using 3rd argument passed to constructor of DatagramPacket class and port number of the server is obtained by 4th argument passed
			 * to constructor of DatagramPacket class.
			 *  
			 */
			
			if((str.equalsIgnoreCase("exit"))==true)
			{
			
				s.send(d1);
				System.exit(1);
				
			}
				
				
			
			s.send(d1);
			//above statement sends the datagram socket to server from client
			
			byte buf[]=new byte[500];
			DatagramPacket d2=new DatagramPacket(buf, buf.length);
			/*
			 * above statement creates a new object of java.net.DatagramPacket class where the above DatagramPacket
			 * object is to be read from server at client. 
			 */
			
			
			s.receive(d2);
			//data is read from client into the DatagramPacket object d1 at server side
			
		
			
			 str=new String(d2.getData(),0,d2.getLength());
			
			if((str==null)||(str.equals("")==true))
			{
				
				break;
			}
			
			System.out.println("\nSERVER:"+str);
			
		}
		
		
		}

}
