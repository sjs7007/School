// K means 

import java.util.*;

class Cluster
{
	int nActual=0; //no. of items in cluser
	float items[]=new float[100]; 
	float mean,sum=0; //sum = sum of numbers, will be used to calculate new mean later

	Cluster(float x)
	{
		mean=x;
	}

	void add(float x)
	{
		items[nActual]=x;
		nActual++;
		sum=sum+x;
	}

	void display()
	{
		System.out.print("Cluster with mean "+mean+" : ");
		for(int i=0;i<nActual;i++)
		{
			System.out.print(items[i]+" ");
		}
		System.out.println();
	}

	//code for recalculating mean
	void reCalculateMean() //recalculate mean
	{
		mean = sum/nActual;
	}

	void reInitialize() //set sum=0,nAcutal=0
	{
		sum=0;
		nActual=0;
	}
}

class ClusterList
{
	Scanner ip = new Scanner(System.in);
	int nNumbers,nClusters; //number of bumbers,number of clusters / means
	Cluster CList[];
	float meanList[];
	float numList[];
	float meanChange=0;


	ClusterList(int x,int y)
	{
		nNumbers=x;
		nClusters=y;
		CList = new Cluster[nClusters];
		meanList = new float[nClusters];
		numList = new float[nNumbers];
		input();
	}

	int calcClosest(float num)
	{
		int cIndex=0;
		float diff=Math.abs(num-meanList[0]);
		for(int i=1;i<nClusters;i++)
		{
			float temp = Math.abs(num-meanList[i]);
			if(temp<diff)
			{
				diff=temp;
				cIndex=i;
			}
		}
		return cIndex;
	}

	void displayAllClusters()
	{
		for(int i=0;i<nClusters;i++)
		{
			CList[i].display();
		}
		System.out.println();
	}

	void input()
	{
		System.out.print("Enter numbers : ");
		for(int i=0;i<nNumbers;i++)
		{
			numList[i] = ip.nextFloat();
		}

		System.out.print("Enter means : ");
		for(int i=0;i<nClusters;i++)
		{
			meanList[i] = ip.nextFloat();
			CList[i]=new Cluster(meanList[i]);
		}
		//assignClusters();
	}

	void assignClusters()
	{
		for(int i=0;i<nNumbers;i++)
		{
			CList[calcClosest(numList[i])].add(numList[i]);
		}
		displayAllClusters();
		//get new means back and re initialize clusters for next round
		meanChange=0;
		for(int i=0;i<nClusters;i++)
		{
			CList[i].reCalculateMean();
			meanChange+=meanList[i]-CList[i].mean; //if meanChange!=0, reassign again
			meanList[i]=CList[i].mean;
			CList[i].reInitialize();
		}

	}

}

class kMeans
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int n1,n2,i=0;
		System.out.print("Enter number of numbers and clusters : ");
		n1=ip.nextInt();
		n2=ip.nextInt();
		ClusterList CList = new ClusterList(n1,n2);	
		do
		{
			i++;
			System.out.println("Clusters after iteration "+i+":-");
			CList.assignClusters();
		}
		while(CList.meanChange!=0);
	}
}
