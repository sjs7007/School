class lexicalAnalysis
{
	public static void main(String args[])
	{
		String keywords[] = {"void,int"};
		String terminal[] = {"{","}","(",")",",",";"}; 
		String operators[] = {"+","-","*","/","="};
		
		String program[]={"void main ( ) ","{"," int a , b , c ; "," c = a + b ; "," } "};
		//System.out.println(belongsTo(terminal,"{"));
		for(int i=0;i<program.length;i++)
		{
			String temp[] = program[i].split(" ");
			for(int j=0;j<temp.length;j++)
			{
				if(belongsTo(keywords,temp[j]))
				{
					System.out.println("Line "+(i+1)+"\t"+temp[j]+"\tKeyword");
				}
				else if(belongsTo(terminal,temp[j]))
				{
					System.out.println("Line "+(i+1)+"\t"+temp[j]+"\tTerminal");
				}
				else if(belongsTo(operators,temp[j]))
				{
					System.out.println("Line "+(i+1)+"\t"+temp[j]+"\tOperator");
				}
				else if(temp[j].length()!=0 && Character.isLetter(temp[j].charAt(0)))
				{
					System.out.println("Line "+(i+1)+"\t"+temp[j]+"\tIdentifier");
				}
			}
		}
	}

	public static boolean belongsTo(String x[],String y)
	{
		boolean answer = false;
		for(int i=0;i<x.length;i++)
		{
			if(x[i].equals(y))
			{
				answer=true;
				break;
			}
		}
		return answer;
	}
}
