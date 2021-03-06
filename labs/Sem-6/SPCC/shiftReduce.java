//Primitive Shift Reduce Parser

class Production
{
	String LHS;
	String productions[]; //has LHS at 0th position so size = nProd+1
	int nProductions;

	Production(String ip)
	{
		productions = ip.split(" ");
		LHS = productions[0];
		nProductions = productions.length-1;
	}

	void display()
	{
		System.out.print(LHS+" --> ");
		for(int i=1;i<productions.length-1;i++)
		{
			System.out.print(productions[i]+" | ");
		}	
		System.out.println(productions[nProductions]);
	}

	int isHandle(String x) //return -1 if not hande, else return rule number 
	{ 
		int ruleNo = -1;
		for(int i=1;i<productions.length;i++)
		{
			if(x.equals(productions[i]))
			{
				ruleNo = i;
				break;
			}
		}
		return ruleNo;
	}
}

class shiftReduce
{
	public static void main(String args[])
	{
		Production G = new Production("E E+E E*E id");
		G.display();
		//System.out.println(G.isHandle("id"));
		String input = new String("id * id");
		String inputArray[] = input.split(" ");
		String stack[] = new String[100];
		int nStack = 0;
		System.out.println("\nInput : "+input+"\n");
		for(int i=0;i<inputArray.length;i++)
		{
			int pos = G.isHandle(inputArray[i]);

			if(pos==-1)
			{
				System.out.println("Shift "+inputArray[i]);
				stack[nStack]=inputArray[i];
			}
			else
			{
				System.out.println("Handle detected : "+inputArray[i]);
				System.out.println("Reduce.");
				System.out.println("Rule used : "+G.LHS+" --> "+G.productions[pos]);
				stack[nStack]=G.LHS;
			}
			nStack++;
			System.out.print("Stack Contents : ");
			for(int j=0;j<nStack;j++)
			{
				System.out.print(stack[j]);
			}
			System.out.println("\n");
		}
		
		String temp = "";
		for(int i=0;i<nStack;i++)
		{
			temp+=stack[i];
		}
		int pos=G.isHandle(temp);
		if(pos>0)
		{
			System.out.println("Handle detected : "+temp);
			System.out.println("Reduce.");
			System.out.println("Rule used : "+G.LHS+" --> "+G.productions[pos]);
			System.out.println("Accepted.");
		}
		else
		{
			System.out.println("Rejected.");
		}
	}
}


