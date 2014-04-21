//U unlocked L locked
// Mutual M Exclusive E Shared S Invalid I

class cell
{
	int pageNumber,data;
	char state;

	cell(int x,int y,char z)
	{
		pageNumber=x;
		data=y;
		state=z;
	}
}

class mainMemory
{
	cell cells[]=new cell[16];

	mainMemory()
	{
		insertPages();
	}

	void insertPages()
	{
		for(int i=0;i<16;i++)
		{
			cells[i] = new cell(i,i*10,'U');
		}
	}

	int returnLoc(int pageNumber) //return -1 if not found
	{
		int loc=-1;
		for(int i=0;i<16;i++)
		{
			if(cells[i].pageNumber==pageNumber && cells[i].state=='U')
			{
				//System.out.println("Cache hit.");
				loc=i;
			}
		}
		if(loc==-1)
		{
			System.out.println("Not found in main memory.");
		}
		return loc;
	}
}

class cache
{
	cell cells[]=new cell[4];
	int loc=0,id;

	cache(int x)
	{
		initCache();
		id=x;
	}
	
	void initCache()
	{
		for(int i=0;i<4;i++)
		{
			cells[i]= new cell(0,0,'I');
		}
	}

	int returnLoc(int pageNumber) //return -1 if not found
	{
		int loc=-1;
		for(int i=0;i<4;i++)
		{
			if(cells[i].pageNumber==pageNumber && cells[i].state!='I')
			{
				System.out.println("Cache hit in Cache "+id+".");
				loc=i;
			}
		}
		if(loc==-1)
		{
			System.out.println("Cache miss in Cache "+id+".");
		}
		return loc;
	}

	void fetchPage(int x,mainMemory M,cacheSet C)
	{
		int loc = returnLoc(x);

		if(loc==-1)
		{
			System.out.println("Fetching from main memory.....");
			loc = M.returnLoc(x);
			System.out.println("Page Number : "+M.cells[loc].pageNumber);
			System.out.println("Data : "+M.cells[loc].data);
			System.out.println("Status : "+M.cells[loc].state);
			char temp = C.findState(M.cells[loc].pageNumber);
			insertPage(M.cells[loc].pageNumber,M.cells[loc].data,temp);
			System.out.println("Page added to cache "+id +" with state : "+temp+".");
		}
		else
		{
			System.out.println("From Cache :-");
			System.out.println("Page Number : "+cells[loc].pageNumber);
			System.out.println("Data : "+cells[loc].data);
			System.out.println("Status : "+cells[loc].state);
		}
			
	}

	void insertPage(int x,int y,char z)
	{
		cells[loc]=new cell(x,y,z);
		loc++;
	}

	void display()
	{
		System.out.println("Page\t\tData\t\tStatus");
		for(int i=0;i<4;i++)
		{
			System.out.print(cells[i].pageNumber+"\t\t");
			System.out.print(cells[i].data+"\t\t");
			String temp="null";
			if(cells[i].state=='S')
			{
				temp="Shared";
			}
			else if(cells[i].state=='E')
			{
				temp="Exclusive";
			}
			else if(cells[i].state=='I')
			{
				temp="Invalid";
			}
			System.out.println(temp);
		}
	}
}

class cacheSet
{
	cache C[]=new cache[4];

	cacheSet()
	{
		initCacheSet();
	}

	void initCacheSet()
	{
		for(int i=0;i<4;i++)
		{
			C[i]=new cache(i);
		}
	}

	char findState(int pageNumber)
	{	int found=0;// found=0 exclusive(just about to be added),>=1 shared
		for(int i=0;i<4;i++)
		{
			int temp=0;
			if((temp=C[i].returnLoc(pageNumber))!=-1)
			{
				C[i].cells[temp].state='S';
				found++;
			}
		}
		char state='E'; //default Exclusive
		if(found>=1)
		{
			state='S';
		}
		return state;
	}

	void display()
	{
		for(int i=0;i<4;i++)
		{
			System.out.println("Cache "+i+".");
			C[i].display();
		}
	}

}


class MESI
{
	public static void main(String args[])
	{
		mainMemory M = new mainMemory();
		cacheSet cSet = new cacheSet();
		cSet.C[1].insertPage(3,30,'E');
		cSet.C[2].insertPage(2,20,'E');
		cSet.C[3].insertPage(4,40,'E');
		cSet.C[1].insertPage(5,50,'E');	
		System.out.println("Caches before :-");
		cSet.display();
		System.out.println("Try to fetch page 3 from cache 0.....");
		cSet.C[0].fetchPage(3,M,cSet);
		System.out.println("Try to fetch page 3 from cache 0.....");
		cSet.C[0].fetchPage(3,M,cSet);
		System.out.println("Try to fetch page 4 from cache 3......");
		cSet.C[3].fetchPage(4,M,cSet);
		System.out.println("Caches after above operations : -");
		cSet.display();
		//cSet.C[1].fetchPage(3,M,cSet);
	}
}

/*
Output :

Caches before :-
Cache 0.
Page		Data		Status
0		0		Invalid
0		0		Invalid
0		0		Invalid
0		0		Invalid
Cache 1.
Page		Data		Status
3		30		Exclusive
5		50		Exclusive
0		0		Invalid
0		0		Invalid
Cache 2.
Page		Data		Status
2		20		Exclusive
0		0		Invalid
0		0		Invalid
0		0		Invalid
Cache 3.
Page		Data		Status
4		40		Exclusive
0		0		Invalid
0		0		Invalid
0		0		Invalid
Try to fetch page 3 from cache 0.....
Cache miss in Cache 0.
Fetching from main memory.....
Page Number : 3
Data : 30
Status : U
Cache miss in Cache 0.
Cache hit in Cache 1.
Cache miss in Cache 2.
Cache miss in Cache 3.
Page added to cache 0 with state : S.
Try to fetch page 3 from cache 0.....
Cache hit in Cache 0.
From Cache :-
Page Number : 3
Data : 30
Status : S
Try to fetch page 4 from cache 3......
Cache hit in Cache 3.
From Cache :-
Page Number : 4
Data : 40
Status : E
Caches after above operations : -
Cache 0.
Page		Data		Status
3		30		Shared
0		0		Invalid
0		0		Invalid
0		0		Invalid
Cache 1.
Page		Data		Status
3		30		Shared
5		50		Exclusive
0		0		Invalid
0		0		Invalid
Cache 2.
Page		Data		Status
2		20		Exclusive
0		0		Invalid
0		0		Invalid
0		0		Invalid
Cache 3.
Page		Data		Status
4		40		Exclusive
0		0		Invalid
0		0		Invalid
0		0		Invalid

*/