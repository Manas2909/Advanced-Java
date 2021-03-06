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
*/
package abc.def;

import java.rmi.*;
import java.io.*;

public interface ChatInterface extends Remote
{
	
	public String sendData(String str)throws IOException,RemoteException;

}
