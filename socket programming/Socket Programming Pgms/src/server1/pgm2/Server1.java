package server1.pgm2;
import java.io.*;
import java.net.*;

public class Server1 {

	public static void main(String[] args)throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ServerSocket ss=new ServerSocket(1381);
		Socket s=ss.accept();
		//accept() is a predefined non static member method of java.net.ServerSocket class
		//and it will accept the incoming connection from client on the same port number 1381 as used by the
		//client
		
		//so the above statement ss.accept() will accept the client incoming connection request
		//sent on port number 1381 and return a new object of the java.net.Socket class
		//which is used provide service to the client on the same port number 1381
		
		while(true)
		{
			DataInputStream dis=new DataInputStream(s.getInputStream());
			//getInputStream() is a predefined non static member method of the java.net.Socket class
			//and it returns the implicit object of the java.io.InputStream interface
			//which we have passed as argument to constructor of java.io.DataInputStream class
			//and so in above statement a new object of DataInputStream class is created
			//which is used to receive data from client at server
			
			String str=dis.readUTF();
			
			if((str.equalsIgnoreCase("exit"))==true)
			{
				s.close();
				ss.close();
				System.exit(1);
			}
			
			System.out.println("\nCLIENT:"+str);
			
			System.out.print("\nSERVER:");
			str=br.readLine();
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			//getOutputStream() is a predefined non static member method of the java.net.Socket class
			//and it returns the implicit object of the java.io.OutputStream interface
			//which we have passed as argument to constructor of java.io.DataOutputStream class
			//and so in above statement a new object of DataOutputStream class is created
			//which is used to send data from server to client
			
			dos.writeUTF(str);
			//writeUTF() IS A PREDEFINED non static member method of java.io.DataOutputStream class
			//which string value of str from server to client
			
			
			
			
			
		}
		
		
		
		
	}

}
