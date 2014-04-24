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
	item itemList[];

	Cluster(int x)
	{
		size=x;
		itemList = new item[size];
	}
}

class clusterList
{
	int nClusters=0;
	Cluster cList[]=new Cluster[100];

	clusterList(int x)
	{
		nClusters=x;
		//cList = new Cluster[nClusters];
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
		return minDistance;
	}

	void addCluster(Cluster C)
	{
		cList[nClusters]=C;
		nClusters++;
	}

	void findMatrix()
	{
		for(int i=0;i<nClusters;i++)
		{
			for(int j=i+1;j<nClusters;j++)
			{
				double temp = findMinDistance(cList[i],cList[j]);
				System.out.print(temp+"\t");
				if(temp<=1)
				{
					System.out.println("\nJoin Cluster "+(i+1)+" and "+"Cluster "+j);
				}
			}
			System.out.println();
		}
	}
}

class Agglomerative
{
	public static void main(String args[])
	{
		/*int nItems=5;
		item itemList[]=new item[nItems];
		itemList[0].x=1;
		itemList[0].y=2;
		itemList[1].x=2;
		itemList[1].y=3;
		itemList[2].x=4;
		itemList[2].y=4;
		itemList[3].x=5;
		itemList[3].y=4;
		itemList[4].x=3;
		itemList[4].y=5;
		double aMatrix[][]=new double[nItems][nItems]; //adjacency matrix
		*/
		clusterList C = new clusterList(5);
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

		//System.out.println(C.findMinDistance(C.cList[0],C.cList[1]));
		
		C.findMatrix();
	}
}
