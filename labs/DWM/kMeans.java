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

class kMeans
{
	public static void main(String args[])
	{
		/*Cluster C = new Cluster(1);
		C.add(1);
		C.add(2);
		C.add(3);
		C.add(4);
		C.display();
		C.reCalculateMean();
		C.display();*/
		Scanner ip = new Scanner(System.in);
		int nNumbers=7;
		int nClusters=2; //number of clusters / means
		Cluster CList[]=new Cluster[nClusters];
		System.out.println("Enter "+nClusters+" mean values : ");
		float meanList[]=new float[nClusters];
		float numList[]=new float[nNumbers];
		for(int i=0;i<nClusters;i++)
		{
			meanList[i] = ip.nextFloat();
			CList[i] = new Cluster(meanList[i]);
		}
		System.out.println("Enter "+nNumbers+" numbers : ");
		for(int i=0;i<nNumbers;i++)
		{
			numList[i]=ip.nextFloat();
			CList[calcClosest(meanList,numList[i])].add(numList[i]);
		}
		displayAllClusters(CList);
		//reInitialize
		
	}

	public static int calcClosest(float x[],float num)
	{
		int cIndex=0;
		float diff=Math.abs(num-x[0]);
		for(int i=1;i<x.length;i++)
		{
			float temp = Math.abs(num-x[i]);
			if(temp<diff)
			{
				diff=temp;
				cIndex=i;
			}
		}
		return cIndex;
	}

	public static void displayAllClusters(Cluster x[])
	{
		for(int i=0;i<x.length;i++)
		{
			x[i].display();
		}
	}
}
