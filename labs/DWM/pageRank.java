//Page Rank : http://www.math.cornell.edu/~mec/Winter2009/RalucaRemus/Lecture3/lecture3.html

import java.util.*;

class pageRank
{
	public static void main(String args[])
	{
		int nPages=4;
		float pageRank[] = new float[nPages];
		for(int i=0;i<nPages;i++)
		{
			pageRank[i]=1/(float)nPages;
		}
		//int adjacencyMatrix[] = new int[nPages][nPages];
		//int adjacencyMatrix[][]={{0,1,1,1},{0,0,1,1},{1,0,0,0},{1,0,1,0}};
		int adjacencyMatrix[][]={{1,1,1,1},{1,1,1,0},{1,1,0,0},{1,0,0,0}};
		int outGoing[] = new int[nPages];
		for(int i=0;i<nPages;i++)
		{
			for(int j=0;j<nPages;j++)
			{
				if(adjacencyMatrix[i][j]==1)
				{
					outGoing[i]++;
				}
			}
			//System.out.println(outGoing[i]);
		}
		float change = calcPR(pageRank,outGoing,adjacencyMatrix);
		//Now page rank should be recalculated again and again till equlibrium value, or change < 0.01
		int i=1;
		while(change>0.01)
		{
			i++;
			System.out.println("After iteration "+i+" :- ");
			change = calcPR(pageRank,outGoing,adjacencyMatrix);
		}
	}

	public static float calcPR(float pageRank[],int outGoing[],int adjacencyMatrix[][]) //return change in page ranks
	{
		int nPages=pageRank.length;
		float newPR[]=new float[nPages];
		float change=0;
		for(int i=0;i<nPages;i++)
		{
			float temp=0;
			for(int j=0;j<nPages;j++)
			{
				if(adjacencyMatrix[j][i]==1)
				{
				//	System.out.println(pageRank[j]+" "+outGoing[j]);
					temp = temp + pageRank[j]/outGoing[j];
				}
			}
			newPR[i] = temp;
		}

		for(int i=0;i<nPages;i++)
		{	
			change+=Math.abs(newPR[i]-pageRank[i]);
			pageRank[i] = newPR[i];
		}

		//display
		for(int i=0;i<nPages;i++)
		{
			System.out.println("Page Rank of "+(i+1)+" is : "+pageRank[i]);
		}
		System.out.println();
		return change;
	}
}
