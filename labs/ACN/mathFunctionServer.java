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

		double n1,n2,result=-1;
		String op;
		n1 = Double.parseDouble(fromClient.readLine());
		op = fromClient.readLine();
		n2 = Double.parseDouble(fromClient.readLine());

		if(op.equals("+"))
		{
			result = n1 + n2;
		}
		else if(op.equals("-"))
		{
			result = n1 - n2;
		}
		else if(op.equals("*"))
		{
			result = n1 * n2;
		}
		else if(op.equals("/"))
		{
			result = n1 / n2;
		}
		toClient.println(n1+" "+op+" "+n2+" is : "+result);
	}
}