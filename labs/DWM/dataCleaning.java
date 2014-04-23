class Record
{
	int year; //1 FE,2 TE,... 4BE
	int age;
	String name;
	int age1=18,age2=19,age3=20,age4=21;

	Record(String x,int y,int z)
	{
		name=x;
		year=y;
		age=z;
	}
	
}

class dataCleaning
{
	public static void main(String args[])
	{
		Record Students[] = new Record[6];
		Students[0]= new Record("Norind",1,18);
		Students[1]= new Record("Advuni",2,19);
		Students[2]= new Record("Avrind",3,20);
		Students[3]= new Record("Moyawa",4,21);
		Students[4]= new Record("Midlin",1,0);
		Students[5]= new Record("Ornub",2,0);
		System.out.println("Before Data Cleaning :-");
		display(Students);
		System.out.println();
		fillNull(Students);
		System.out.println("After Data Cleaning :-");
		display(Students);
	}

	public static void display(Record x[])
	{
		System.out.println("Name\t\t\tYear\t\t\tAge\t\t\t");
		for(int i=0;i<x.length;i++)
		{
			String temp = null;
			if(x[i].year==1)
			{
				temp="FE";
			}
			else if(x[i].year==2)
			{
				temp="SE";
			}
			else if(x[i].year==3)
			{
				temp="TE";
			}
			else if(x[i].year==4)
			{
				temp="BE";
			}
			String temp2 = "null";
			if(x[i].age!=0)
			{
				temp2 = Integer.toString(x[i].age);
			}
			System.out.println(x[i].name+"\t\t\t"+temp+"\t\t\t"+temp2);
		}
	}

	public static void fillNull(Record x[])
	{
		for(int i=0;i<x.length;i++)
		{
			if(x[i].age==0)
			{
				if(x[i].year==1)
				{
					x[i].age=x[i].age1;
				}
				else if(x[i].year==2)
				{
					x[i].age=x[i].age2;
				}
				else if(x[i].year==3)
				{
					x[i].age=x[i].age3;
				}
				else if(x[i].year==4)
				{
					x[i].age=x[i].age4;
				}
			}
		}
	}
}
