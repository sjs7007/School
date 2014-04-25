//Distance Vector Routing

import java.util.*;

class Record //Individual Cell of a Router Table
{
	int networkID,hop;
	char next='-';

	Record(int x,int y)
	{
		networkID = x;
		hop = y; 
	}
}

class routerTable
{
	Scanner ip = new Scanner(System.in);
	int nTotalNetworks=7,nCurrentNetworks; //total networks, networks currently present in router table
	char name; //A,B,C....etc
	char routersDirectlyConnected[]=new char[100];
	int nDirect;
	Record recordList[]=new Record[nTotalNetworks];

	routerTable(char x,int y,int z)
	{
		name=x;
		nCurrentNetworks=y;
		nDirect=z;
	}

	void displayRouterTable()
	{
		System.out.println("Router Table for "+name+" :- ");
		for(int i=0;i<nTotalNetworks;i++)
		{
			if(recordList[i]!=null)
			{
				System.out.println("Net"+recordList[i].networkID+" "+recordList[i].hop+" "+recordList[i].next);
			}
		}
		System.out.print("Routers directly connected to Router "+name+" : ");
		for(int i=0;i<nDirect;i++)
		{
			System.out.print(routersDirectlyConnected[i]+" ");
		}
		System.out.println();
	}

	void inputDataFirst() //fill in initial state
	{
		System.out.print("Enter networks connected to Router "+name+" : ");
		for(int i=0;i<nCurrentNetworks;i++)
		{
			int temp = ip.nextInt();
			recordList[temp] = new Record(temp,1);
		}

		System.out.print("Enter routers directly connected to Router "+name+" : ");
		for(int i=0;i<nDirect;i++)
		{
			routersDirectlyConnected[i]=ip.next().charAt(0);
		}
		System.out.println();
	}
}

class DVR
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int nRouters=1;
		char temp='A';
		routerTable routerList[]=new routerTable[nRouters];
		for(int i=0;i<nRouters;i++)
		{
			System.out.print("Enter number of Networks and number of Routers directly connected to Router "+temp+" : ");
			routerList[i]=new routerTable(temp,ip.nextInt(),ip.nextInt());
			routerList[i].inputDataFirst();
			temp++;
		}
		displayRouterTables(routerList);
	}

	public static void displayRouterTables(routerTable  x[])
	{
		for(int i=0;i<x.length;i++)
		{
			x[i].displayRouterTable();
			System.out.println("--------------------");
		}
	}
}
