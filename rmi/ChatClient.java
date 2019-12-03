/*
RMI:
It means remote method invocation. In RMI, there is a remote process or remote application which executes at the server side and it is executed by the application at client side.

There are 2 objects named stub and skeleton in every RMI application. Stub acts as gateway for the client application at the client side and skeleton acts as a gateway for the remote application at server side.

The client application will send the input parameters or values to the stub object which will transmit those parameters or values to the skeleton object at the server side to execute the remote application. This process of sending parameters or values to the srever side remote application from the stub object is called as marshalling.

The skeleton object receives these input parameters or values from the client side application and executes the remote application at the server side by passing those parameters or values as input values. The remote application will execute and its result is returned to the client application through the skeleton object and stub object. This process of reading the output parameter or value from the server side remote application to the client application is called as unmarshalling.

The stub object represents the server side remote application and so it acts as a dummy server for the client side application so whatever communication of data the client side application must do with the server it will do that with the stub object.

*/
/*
create a uni directional chat application using rmi i.e. only from client to server. We cannot create a bi directional chat application using rmi because in rmi application the emote application doesnt call any of the client side applications methods but only the client side application calls the remote application methods. So suppose we want to create a bidirectional chat application we can do that using socket programming.

*/
/*
to create any rmi application, we must create 4 java pgms.

1st java pgm must be a public interface which extends the java.rmi.Remote interface. In that sub interface of the java.rmi.Remote interface we will define those methods which must be called by the client application on the remote application.

2nd java pgm will be a class which implements the sub interface of java.rmi.Remote interface of 1st java pgm. The 2nd java pgm class will also extend the java.rmi.UnicastRemoteObject class and because the non parmeterised non default constructor in java.rmi.UnicastRemoteObject class declares a checked exception java.rmi.RemoteException so in the 2nd java pgm, when we define the subclass of the UnicastRemoteObject class we must define an explicit constructor in it which declares the checked exception java.rmi.RemoteException and also we must override the abstract methods of the interface of 1st java pgm in the class of 2nd java pgm which implements the interface of 1st java pgm and extends the java.rmi.UnicastRemoteObject class.

3rd java pgm will be the server pgm which will be a public java class which contains main() method in it. In the server java class we will be creating the stub object representing the server and storing its entry into the rmi registry. rmi registry is an inbuilt application in java rmi, which contains the entry to every stub object in every rmi application where each stub entry will be the logical name assigned to the stub along with the actual stub object instance.


4th java pgm will be the clien pgm which will be a public class which contains the main() method. In the client java pgm public class, we will be retreiving the entry of the stub object created by the server application in the rmi registry using same port number and same logical name assigned to the stub object at the server side application.

for execucting the rmi application first compile all the 4 java pgms on command prompt.
Then run the rmi compiler i.e. the rmic tool on the name of the class of the 2nd java pgm which extends UnicastRemoteObject class.
This rmi compiler will create the stub and skeleton objects.

then start the rmi registry using the rmiregistry command followed by the same port number as we used in the server and client pgms.

*/
package abc.def;

import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
import java.net.*;


public class ChatClient 
{
	public static void main(String args[])throws RemoteException,IOException,MalformedURLException,NotBoundException
	{
		ChatInterface c1=(ChatInterface)Naming.lookup("rmi://localhost:3311/stub1");

/*
	Naming is a predefined class in java.rmi.server package and lookup() is the static member method of the Naming class and the above statement will retreive the entry of the stub object created by the server pgm using same port number 3311 for the rmi registry as used by the server pgm and also using the same logical name stub1 which was used by server pgm to create the entry of the stub object in the rmi registry.

The Naming.lookup() returns the actual stub object from the rmi registry from that same entry using its logical name stub1 but the stub object returned by Naming.lookup() has reference type java.lang.Object and so we must explicitly convert the reference type of the return value of Naming.lookup() from java.lang.Object class type to ChatInterface type before assigning the return value of Naming.lookup() to c1 variable of ChatInterface type.
*/
	int option=1;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	while(true)
	{
		System.out.println("\n Do you want to send more messages to server ....1. Yes 2. No ");
		option=Integer.parseInt(br.readLine());

		if(option==2)
		break;

		String str=br.readLine();

		String str1=c1.sendData(str);

		System.out.println(str1);


	}
	}	

}
