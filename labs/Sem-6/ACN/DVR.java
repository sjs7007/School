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
	int nTotalNetworks=7+1,nCurrentNetworks; //total networks, networks currently present in router table
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
		for(int i=1;i<nTotalNetworks;i++)
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

	void addEntry(int net,int hop,char next) //add new entry to router tables
	{
		recordList[net]=new Record(net,hop);
		recordList[net].next=next;
		nCurrentNetworks++;
	}
}

class DVR
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int nRouters=4;
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
		//AtoB(routerList[0],routerList[1]);
		//displayRouterTables(routerList);

		//for(int k=0;k<5;k++)
		while(!allFilled(routerList))
		{
			for(int i=0;i<nRouters;i++)
			{
				for(int j=0;j<routerList[i].nDirect;j++)
				{
					int netID = (int)(routerList[i].routersDirectlyConnected[j]-'A');
					if(i!=j)
					{
						//System.out.println(routerList[i].name+" "+routerList[netID].name);
						AtoB(routerList[i],routerList[netID]);
					}
				}
			}
			allFilled(routerList);			
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

	public static void AtoB(routerTable A,routerTable B) //router A sends information to router B
	{
		for(int i=0;i<A.nTotalNetworks;i++)
		{
			if(A.recordList[i]!=null && B.recordList[i]==null)
			{
				B.addEntry(A.recordList[i].networkID,A.recordList[i].hop+1,A.name);
			}
			else if(A.recordList[i]!=null && B.recordList[i]!=null)
			{
				if((A.recordList[i].hop+1)<B.recordList[i].hop)
				{
					B.recordList[i].hop=A.recordList[i].hop+1;
					B.recordList[i].next=A.name;
				}		
			}
		}
	}

	public static boolean allFilled(routerTable x[])
	{
		boolean flag=true;
		for(int i=0;i<x.length;i++)
		{
			//System.out.println(x[i].nCurrentNetworks);
			if(x[i].nCurrentNetworks!=7)
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
}

/* Output  : 

   Enter number of Networks and number of Routers directly connected to Router A : 4 3 
   Enter networks connected to Router A : 1 2 4 5
   Enter routers directly connected to Router A : B C D

   Enter number of Networks and number of Routers directly connected to Router B : 3 2
   Enter networks connected to Router B : 2 3 6
   Enter routers directly connected to Router B : A C

   Enter number of Networks and number of Routers directly connected to Router C : 3 2
   Enter networks connected to Router C : 5 6 7
   Enter routers directly connected to Router C : A B 

   Enter number of Networks and number of Routers directly connected to Router D : 1 1
   Enter networks connected to Router D : 4
   Enter routers directly connected to Router D : A

   Router Table for A :- 
   Net1 1 -
   Net2 1 -
   Net4 1 -
   Net5 1 -
   Routers directly connected to Router A : B C D 
   --------------------
   Router Table for B :- 
   Net2 1 -
   Net3 1 -
   Net6 1 -
   Routers directly connected to Router B : A C 
   --------------------
   Router Table for C :- 
   Net5 1 -
   Net6 1 -
   Net7 1 -
   Routers directly connected to Router C : A B 
   --------------------
   Router Table for D :- 
   Net4 1 -
   Routers directly connected to Router D : A 
   --------------------
   Router Table for A :- 
   Net1 1 -
   Net2 1 -
   Net3 2 B
   Net4 1 -
   Net5 1 -
   Net6 2 B
   Net7 2 C
   Routers directly connected to Router A : B C D 
   --------------------
   Router Table for B :- 
   Net1 3 C
   Net2 1 -
   Net3 1 -
   Net4 3 C
   Net5 2 C
   Net6 1 -
   Net7 2 C
   Routers directly connected to Router B : A C 
   --------------------
   Router Table for C :- 
   Net1 2 A
   Net2 2 A
   Net3 3 A
   Net4 2 A
   Net5 1 -
   Net6 1 -
   Net7 1 -
   Routers directly connected to Router C : A B 
   --------------------
	Router Table for D :- 
	Net1 2 A
	Net2 2 A
	Net3 3 A
	Net4 1 -
	Net5 2 A
	Net6 3 A
	Net7 3 A
	Routers directly connected to Router D : A 
	--------------------
*/
