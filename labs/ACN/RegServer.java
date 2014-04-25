//Server for exam registration

import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;

class RegServer
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket welcomeSocket = new ServerSocket(1994);
		Socket connectionSocket = welcomeSocket.accept();

		System.out.println("Connection received from :"+connectionSocket.getInetAddress());

		DataInputStream fromClient = new DataInputStream(connectionSocket.getInputStream());
		PrintStream toClient = new PrintStream(connectionSocket.getOutputStream());

		toClient.println("Hello, this message is from Server.");

		boolean avail[]=new boolean[5];
		String time[]=new String[5];
		int nCurrent=0; //number of enrollments

		for(int i=0;i<5;i++)
		{
			avail[i]=true;
		}

		String response;
		do
		{
			response = new String(fromClient.readLine());
			String status = new String("N");
			if(response.equals("Y"))
			{	
				String response2 = new String(fromClient.readLine());
				System.out.println("Received request for enrolling : "+response2);
				for(int i=0;i<5;i++)
				{
					if(response2.equals(time[i]) && !avail[i])
					{
						System.out.println("Time slot already allocated to another user.Select new time slot.");
						break;
					}
					else if(!response2.equals(time[i]) && avail[i])
					{
						System.out.println("Time slot allocated to user.");
						time[i]=response2;
						avail[i]=false;
						status=new String("Y");
						break;
					}
				}	
			}
			toClient.println(status);
		}
		while(response.equals("Y"));

	}
}
