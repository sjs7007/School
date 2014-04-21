import java.util.*;

class Graph
{
	int adjacency[][],n,infinity=1000; //n = number of vertices

	Graph(int x)
	{
		n=x;
		adjacency=new int[n+1][n+1];
		inputData();
		solve(2);
	}

	void inputData()
	{
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the adjacency matrix : ");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				adjacency[i][j]=ip.nextInt();
			}
		}

		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i!=j && adjacency[i][j]==0)
				{
					adjacency[i][j]=infinity;
				}
			}
		}
	}

	void displayGraph()
	{
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				System.out.print(adjacency[i][j]+" ");
			}
			System.out.println();
		}
	}

	void solve(int startnode)
	{
		int distance[]=new int[n+1],pred[]=new int[n+1],visited[]=new int[n+1],nextnode=0;
		for(int i=1;i<=n;i++)
		{
			distance[i]=adjacency[startnode][i];
			pred[i]=startnode;
			//visited[i]=0; by default zero
		}
		distance[startnode]=0;
		visited[startnode]=1;
		int count=1;
		while(count<n-1)
		{
			int mindistance=infinity;
			for(int i=1;i <=n;i++)
			if(distance[i] < mindistance && visited[i]==0)
			{
				mindistance=distance[i];
				nextnode=i;
			}
			visited[nextnode]=1;
			for(int i=1;i<=n;i++)
			{	
				if(visited[i]==0)
				{
					if(mindistance+adjacency[nextnode][i] < distance[i])
					{
						distance[i]=mindistance+adjacency[nextnode][i];
						pred[i]=nextnode;
					}
				}
				count++;
			}
		}

		for(int i=1;i <= n;i++)
		{
			if(i!=startnode)
			{
				//printf("\nDistance of %d = %d", i, distance[i]);
				//printf("\nPath = %d", i);
				System.out.println("Distance of "+i+" = "+distance[i]);
				System.out.print("Path = "+i);
				int j=i;
				do
				{
					j=pred[j];
					//printf(" <-%d", j);
					System.out.print("<-"+j);
				}
				while(j!=startnode);
			}
		}
	}	
}

class Dijkstra
{
	public static void main(String[] args) 
	{
		Graph G = new Graph(4);	
		//G.displayGraph();
	}
}
