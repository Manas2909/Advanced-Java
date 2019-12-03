//bidirectional chat application using TCP protocol
//suppose client wants to stop chat then the person will need to send message as exit
//to client
//client sends the 1st data to server and while running we need to start server
//first and then client


package client1.pgm1;
import java.net.*;
import java.io.*;

public class Client1 {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Socket s=new Socket("localhost",1381);
		//we can use any temporary port number to communicate data between clienty and data
		//but both the client and server port numbers must be same because we are using
		//TCP i.e. connection orineted secure protocol
		//so the above statement sends a connection request to the server on port number
		//1381 where localhost passed as 1st argument to constructor of java.net.Socket class
		//represents the hostname of the pc on which the server is running.
		//because the server is running on same pc as same so we have passed the strring value
		//"hostname" as argument to the constructor of Socket class
		
		while(true)
		{
			//reading data from the keyboard of client and sending to server
			System.out.print("\nCLIENT:");
			String str=br.readLine();
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			//getOutputStream() is a predefined non static member method of the java.net.Socket class
			//and it returns the implicit object of the java.io.OutputStream interface
			//which we have passed as argument to constructor of java.io.DataOutputStream class
			//and so in above statement a new object of DataOutputStream class is created
			//which is used to send data from client to server
			
			dos.writeUTF(str);
			//writeUTF() IS A PREDEFINED non static member method of java.io.DataOutputStream class
			//which string value of str to the server from client
			
			DataInputStream dis=new DataInputStream(s.getInputStream());
			//getInputStream() is a predefined non static member method of the java.net.Socket class
			//and it returns the implicit object of the java.io.InputStream interface
			//which we have passed as argument to constructor of java.io.DataInputStream class
			//and so in above statement a new object of DataInputStream class is created
			//which is used to receive data from server at client
			try
			{
			str=dis.readUTF();
			//reads data from server at client side
			}
			
			catch(Exception e)
			{
				
			}
			if((str==null)||(str.equalsIgnoreCase("exit")==true))
			{
				
				break;
			}
			
			System.out.println("\nSERVER:"+str);
			
		}
		try
		{
		s.close();
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		}

}
