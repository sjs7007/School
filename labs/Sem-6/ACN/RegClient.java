//Client for exam registration

import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.*;

class RegClient
{
	public static void main(String args[]) throws IOException
	{
		Scanner ip = new Scanner(System.in);
		Socket clientSocket = new Socket("localhost",1994);

		DataInputStream fromServer = new DataInputStream(clientSocket.getInputStream());
		PrintStream toServer = new PrintStream(clientSocket.getOutputStream());

		String response = fromServer.readLine();
		System.out.println(response);

		String input,date,time;

		do
		{
			System.out.print("Do you want to enroll : ");
			input = new String(ip.next());
			toServer.println(input);

			if(input.equals("Y"))
			{
				System.out.print("Enter date : ");
				date = new String(ip.next());

				System.out.print("Enter 1hr time slot between 9:00 am to 5:00 pm : ");
				time = new String(ip.next());

				String temp = date+" "+time;

				toServer.println(temp);
				String status = fromServer.readLine();

				if(status.equals("Y"))
				{
					System.out.println("Time slot allocated.");
				}
				else if(status.equals("N"))
				{
					System.out.println("Choose another time slot.");
				}
				else
				{
					System.out.println("Error.");
				}

			}
		}
		while(input.equals("Y"));
	}
}
