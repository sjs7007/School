

class LRU
{
	public static void main(String args[])
	{
		int cache[][] = new int [4][2]; //1st col stores page number, 2nd stores time
		int mainMemory[]={1,3,4,7,2,4,6,3,1,2,1,3,5,6,4,3};

		//assign first 4 values from main memory to cache
		for(int i=0;i<4;i++)
		{
			cache[i][0]=mainMemory[i];
			for(int j=0;j<=i;j++)
			{
				cache[j][1]++;
			}
		}
		
		/*for(int i=0;i<4;i++)
		{
			System.out.println(cache[i][0]+" "+cache[i][1]);
		}*/

		for(int i=0;i<mainMemory.length;i++)
		{
			System.out.print("Cache : ");
			for(int j=0;j<4;j++)
			{
				System.out.print(cache[j][0]+" ");
			}
			System.out.println();

			System.out.println("Fetch Page "+mainMemory[i]+"....");
			int loc = inCache(cache,mainMemory[i]);
			if(loc==-1)
			{
				System.out.println("Cache miss.");
				loc=returnLRUPos(cache);
				System.out.println("Page "+cache[loc][0]+" replaced by Page "+mainMemory[i]+".");
				cache[loc][0]=mainMemory[i];
				cache[loc][1]=0;	
			}
			else
			{
				System.out.println("Cache hit.");
				cache[loc][1]=0;
			}
			//increase time of all
			increaseTime(cache);
			System.out.println();
		}
	}

	public static int returnLRUPos(int x[][])
	{
		//position with max. time is LRU
		int maxIndex=0;
		int maxTime=x[0][1];
		for(int i=1;i<4;i++)
		{
			if(maxTime<x[i][1])
			{
				maxTime=x[i][1];
				maxIndex=i;
			}
		}
		return maxIndex;
	}

	public static int inCache(int x[][],int find) //loc if present,else -1
	{
		int loc=-1;
		for(int i=0;i<4;i++)
		{
			if(x[i][0]==find)
			{
				loc=i;
				break;
			}
		}
		return loc;
	}

	public static void increaseTime(int x[][])
	{
		for(int i=0;i<4;i++)
		{
			x[i][1]++;
		}
	}
}
