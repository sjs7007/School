//Client for Math Function

import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;

class mathFunctionClient
{
	public static void main(String args[]) throws IOException
	{
		Scanner ip = new Scanner(System.in);
		Socket clientSocket = new Socket("localhost",1994);

		DataInputStream fromServer = new DataInputStream(clientSocket.getInputStream());
		PrintStream toServer = new PrintStream(clientSocket.getOutputStream());

		String response = fromServer.readLine();
		System.out.println(response);

		System.out.print("Enter Number 1, Operation and Number 2: ");
		toServer.println(ip.next());
		toServer.println(ip.next());
		toServer.println(ip.next());

		response=fromServer.readLine();
		System.out.println(response);
	}
}