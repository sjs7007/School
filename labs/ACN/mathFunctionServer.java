//Server for math function

import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;

class mathFunctionServer
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket welcomeSocket = new ServerSocket(1994);
		Socket connectionSocket = welcomeSocket.accept();

		System.out.println("Connection received from "+connectionSocket.getInetAddress());

		DataInputStream fromClient = new DataInputStream(connectionSocket.getInputStream());
		PrintStream toClient = new PrintStream(connectionSocket.getOutputStream());

		toClient.println("Connection Established.");
	}
}