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

*/
package abc.def;

import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
import java.net.*;


public class ChatServer 
{
	public static void main(String args[])throws RemoteException,MalformedURLException
	{
		ChatInterface c1=new ChatClass();
//above object c1 represents the stub object.

	Naming.rebind("rmi://localhost:3311/stub1",c1);
/*
	Naming is a predefined class in java.rmi.server package and rebind() is the static member method of the Naming class and the above statement creates an entry of the c1 object i.e. the stub object in the rmi registry and the logical name assigned to the stub object is stub1 and we have used port number 3311 for the rmi registry which can be any positive integer value but that same integer value i.e. the same port number must be used when we run the rmi registry on command prompt and also the same above mentioned port number must be used at the client side.


*/


	}	

}
