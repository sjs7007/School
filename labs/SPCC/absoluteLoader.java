//Absolute Loader 

class absoluteLoader
{
	public static void main(String args[])
	{
		String program[]={"0 L 1, 16(0,15)","4 A 1, 12(0,15)","8 ST 1, 20(0,15)","12 4","16 5","20 -"};
		displayArray(program);
		int startingAddress = 555;
		for(int i=0;i<program.length;i++)
		{
			String temp[]=program[i].split(" ");
			temp[0]=Integer.toString(Integer.parseInt(temp[0])+startingAddress);
			//System.out.println(combineArray(temp));
			//program[0]=combineArray(temp);
			if(temp.length==4)
			{
				int pos=temp[3].indexOf("(");
				int number = Integer.parseInt(temp[3].substring(0,pos));
				number = number + startingAddress;
				temp[3]=Integer.toString(number)+temp[3].substring(pos,temp[3].length());
			}
			program[i]=combineArray(temp);
		}
		displayArray(program);
	}

	public static void displayArray(String x[])
	{
		for(int i=0;i<x.length;i++)
		{
			System.out.println(x[i]);
		}
		System.out.println();
	}

	public static String combineArray(String x[])
	{
		String temp="";
		for(int i=0;i<x.length;i++)
		{
			temp=temp+x[i]+" ";
		}
		return temp;
	}
}
