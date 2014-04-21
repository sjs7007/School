//Find first set of given grammar. 
//Assumptions : lowercase terminal,uppercase non-terminal,no symbol for epsilon yet.

class Production
{
	String LHS;
	String productions[]; //has LHS at 0th position so size = nProd+1
	int nProductions;
	boolean isTerminal[]; //store if ith profuction is terminal or not
	String first = new String(); //store first as a string separated by spaces 

	Production(String ip)
	{
		productions = ip.split(" ");
		LHS = productions[0];
		nProductions = productions.length-1;
		isTerminal = new boolean[nProductions+1]; //start from 1
		fillIsTerminal();
	}

	void fillIsTerminal()
	{
		for(int i=1;i<isTerminal.length;i++)
		{
			isTerminal[i] = checkTerminal(productions[i]);
		}
	}
	
	boolean checkTerminal(String input) //check if input starts with therminal or not
	{
		boolean flag=false;
		if(Character.isLowerCase(input.charAt(0)))
		{
			flag=true;
		}
		return flag;
	}
}

class Grammar
{
	int nNonTerminals;
	Production prodSet[];
	
	Grammar(int x)
	{
		nNonTerminals=x;
		prodSet = new Production[nNonTerminals];
		//enter rules here
		prodSet[0]=new Production("S Aa b");
		prodSet[1]=new Production("A bdZ eZ");
		prodSet[2]=new Production("Z cZ adZ x");
	}

	String findTerminal(String input)
	{
		int inputID=0;
		char temp = input.charAt(0);
		String temp2 = new String();
		for(int i=0;i<nNonTerminals;i++)
		{
			if(temp==prodSet[i].LHS.charAt(0))
			{
				inputID = i;
				break;
			}
		}

		for(int i=1;i<=prodSet[inputID].nProductions;i++)
		{
			if(prodSet[inputID].isTerminal[i])
			{
				//if first char itself is terminal,store in temp3
				String temp3 = Character.toString(prodSet[inputID].productions[i].charAt(0));

				//now before inserting, check if terminal is already present or not
				if(!temp2.contains(temp3))
				{
					temp2+=(temp3)+" ";
				}
			}
			else
			{
				//first char is non-terminal, so apply findterminal function on it and store result later
				temp2+=findTerminal(prodSet[inputID].productions[i]);
			}
		}
		return temp2;
	}

	void findAllFirst()
	{
		for(int i=0;i<nNonTerminals;i++)
		{
			prodSet[i].first=findTerminal(prodSet[i].LHS);
			System.out.println("First for "+prodSet[i].LHS+" : "+prodSet[i].first);

		}
	}
}

class first
{
	public static void main(String args[])
	{
		Grammar G = new Grammar(3); //enter number of rules
		G.findAllFirst();
	}
}

/*
First for S : b e 
First for A : b e 
First for Z : c a x 
*/
