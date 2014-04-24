class item
{
	float x, y;

	item(float a,float b)
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
	int nClusters;
	Cluster cList[];

	clusterList(int x)
	{
		nClusters=x;
		cList = new Cluster[nClusters];
	}

	float findMinDistance(Cluster C1,Cluster C2) //find min. distance between two clusters
	{
		float minDistance=9999;
		for(int i=0;i<C1.size;i++)
		{
			for(int j=0;j<C2.size;j++)
			{
				float temp =Math.abs(C1.itemList[i].x * C1.itemList[i].x - C2.itemList[j].y *C2.itemList[j].y);
				if(temp<minDistance)
				{
					minDistance = temp;
				}
			}
		}
		return minDistance;
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
		float aMatrix[][]=new float[nItems][nItems]; //adjacency matrix
		*/
		clusterList C = new clusterList(2);
		C.cList[0]=new Cluster(1);
		C.cList[1]=new Cluster(1);
		C.cList[0].itemList[0]=new item(1,1);
		C.cList[1].itemList[0]=new item(2,2);

		System.out.println(C.findMinDistance(C.cList[0],C.cList[1]));
	}
}
