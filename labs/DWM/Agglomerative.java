//Agglomerative single link

class item
{
	double x, y;

	item(double a,double b)
	{
		x=a;
		y=b;
	}
}

class Cluster
{
	int size;
	item itemList[]=new item[100];

	Cluster(int x)
	{
		size=x;
	}

	void displayCluster()
	{
		for(int i=0;i<size;i++)
		{
			System.out.println(itemList[i].x+" "+itemList[i].y);
		}
	}
}

class clusterList
{
	int nClusters=0;
	Cluster cList[]=new Cluster[100];

	clusterList(int x)
	{
		nClusters=x;
	}

	double findMinDistance(Cluster C1,Cluster C2) //find min. distance between two clusters
	{
		double minDistance=9999;
		for(int i=0;i<C1.size;i++)
		{
			for(int j=0;j<C2.size;j++)
			{
				double temp =Math.abs(Math.pow(C1.itemList[i].x - C2.itemList[j].x,2) + Math.pow(C1.itemList[i].y - C2.itemList[j].y,2));
				if(temp<minDistance)
				{
					minDistance = temp;
				}
			}
		}
		minDistance = Math.sqrt(minDistance);
		return minDistance;
	}

	void addCluster(Cluster C)
	{
		cList[nClusters]=C;
		nClusters++;
	}

	clusterList findMatrix(int threshold) //along with it form next set of clusters and return it 
	{
		clusterList nextSet = new clusterList(0);
		boolean avail[]=new boolean[nClusters];
		for(int i=0;i<nClusters;i++)
		{
			avail[i]=true;
		}
		for(int i=0;i<nClusters;i++)
		{
			for(int j=i+1;j<nClusters;j++)
			{
				double temp = findMinDistance(cList[i],cList[j]);
				System.out.println("Distance between Cluster "+(i+1)+" and "+(j+1)+" is : "+temp);
				if(temp<=threshold)
				{
					//if distance < threshold, join those clusters and remove them from avail clusters
					if(avail[i]==true && avail[j]==true)
					{
						System.out.println("Merge clusters "+(i+1)+" and "+(j+1)+".");
						nextSet.addCluster(mergeClusters(cList[i],cList[j]));
						avail[i]=false;
						avail[j]=false;
					}
				}
			}	
		}
		for(int i=0;i<nClusters;i++)
		{
			if(avail[i]==true)
			{
				//System.out.println("Add Cluster "+(i+1)+" to next set.");
				nextSet.addCluster(cList[i]);
			}
		}
		System.out.println("New Clusters are :-");
		nextSet.displayClusterList();
		return nextSet;
	}

	void displayClusterList()
	{
		for(int i=0;i<nClusters;i++)
		{
			System.out.println("Cluster "+(i+1)+" : -");
			cList[i].displayCluster();
		}
	}

	Cluster mergeClusters(Cluster C1,Cluster C2)
	{
		Cluster C3 = new Cluster(C1.size+C2.size);
		for(int i=0;i<C1.size;i++)
		{
			C3.itemList[i] = C1.itemList[i];
		}
		int n1 = C1.size,n2=C2.size;
		int n3=n1+n2;
		for(int i=0;i<n2;i++)
		{
			C3.itemList[n1+i] = C2.itemList[i];
		}
		return C3;
	}

}

class Agglomerative
{
	public static void main(String args[])
	{
		/*clusterList C = new clusterList(5);
		C.cList[0]=new Cluster(1);
		C.cList[1]=new Cluster(1);
		C.cList[2]=new Cluster(1);
		C.cList[3]=new Cluster(1);
		C.cList[4]=new Cluster(1);
		C.cList[0].itemList[0]=new item(1,2);
		C.cList[1].itemList[0]=new item(2,3);
		C.cList[2].itemList[0]=new item(4,4);
		C.cList[3].itemList[0]=new item(5,4);
		C.cList[4].itemList[0]=new item(3,6);
		*/

		clusterList C = new clusterList(6);
		int size=C.nClusters;
		C.cList[0]=new Cluster(1);
		C.cList[1]=new Cluster(1);
		C.cList[2]=new Cluster(1);
		C.cList[3]=new Cluster(1);
		C.cList[4]=new Cluster(1);
		C.cList[5]=new Cluster(1);
		C.cList[0].itemList[0]=new item(1,5);
		C.cList[1].itemList[0]=new item(1,1);
		C.cList[2].itemList[0]=new item(2,1);
		C.cList[3].itemList[0]=new item(4,3);
		C.cList[4].itemList[0]=new item(5,4);
		C.cList[5].itemList[0]=new item(6,2);
		
		int i=1;
		do
		{	
			System.out.println("Threshold for merging clusters is : "+i+".");
			C = C.findMatrix(i);
			System.out.println("------------------------");
			i++;
		}
		while(C.cList[0].size!=size);
	}		
}
