//register windowing

import java.util.*;

class regWindowing
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int ins[]=new int[8],outs[]=new int[8],locals[]=new int[8];
		fillRandom(ins);
		fillRandom(outs);
		fillRandom(locals);
		System.out.println("Register window generated....");
		String input="";
		do
		{
			displayAll("ins","outs","locals",ins,outs,locals);
			System.out.print("\nDo you want to continue(yes/no): ");
			input = ip.next();
			for(int i=0;i<8;i++)
			{
				ins[i]=outs[i];
			}
			fillRandom(outs);
			fillRandom(locals);
		}
		while(input.equals("yes"));
	}

	public static void displayAll(String name1,String name2,String name3,int x[],int y[],int z[])
	{
		System.out.print(name1+" = { ");
		for(int i=0;i<x.length-1;i++)
		{
			System.out.print(x[i]+" , ");
		}
		System.out.println(x[x.length-1]+" } ");

		System.out.print(name2+" = { ");
		for(int i=0;i<y.length-1;i++)
		{
			System.out.print(y[i]+" , ");
		}
		System.out.println(y[y.length-1]+" } ");

		System.out.print(name3+" = { ");
		for(int i=0;i<z.length-1;i++)
		{
			System.out.print(z[i]+" , ");
		}
		System.out.println(z[z.length-1]+" } ");
	}

	public static void fillRandom(int x[])
	{
		for(int i=0;i<x.length;i++)
		{
			x[i]=(int)(Math.random()*100);
		}
	}
}
