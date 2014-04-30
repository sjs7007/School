import java.io.*;
import java.util.*;

class macroPass2
{
	public static void main(String args[]) throws IOException
	{
				
		String program[]=readFile(new String("macroPass2Input.txt")); //read file into string array
		DataOutputStream writeOut = new DataOutputStream(new FileOutputStream("macroPass2Output.txt"));
		int MNTCount=-1,ALACount=-1,MDTCount=0,MDTindexes[]=new int[100];
		String MNT[]=new String[100];
		String ALA[]=new String[100];
		String MDT[]=new String[100];
		String ALA2[]=new String[100];
		int ALA2Count=-1;
		int start=-1,end=-1;

		for(int i=0;i<program.length;i++)
		{
			//writeOut.writeBytes(System.getProperty("line.separator"));
			//int start=-1,end=-1;
			//System.out.println(program[i]);
			if(program[i].equals("MACRO"))
			{
				//System.out.println("3");
				start=i+1;
				String temp[] = program[start].split(" ");
				MNTCount = updateTable(temp[0],MNT); //send macro name
			//System.out.println(temp[0]+ " "+MNTCount );
				//npw update ALA
				MDTindexes[MNTCount-1] = MDTCount+1;

				for(int j=1;j<temp.length-1;j++)
				{
					ALACount = updateTable(temp[j].substring(0,temp[j].length()-1),ALA);
				}
				ALACount = updateTable(temp[temp.length-1],ALA);
				
				for(int j=i+1;;j++)
				{
					if(program[j].equals("MEND"))
					{
						end=j;
						break;
					}
				}
				for(int j=start;j<end;j++)
				{
					String temp2[] = program[j].split(" ");
					
					int temp4=2;
					if(j==start)
					{
						temp4=1;	
					}
					for(int k=temp4;k<temp2.length-1;k++)
					{
						temp2[k]="#"+Integer.toString(findTableIndex(temp2[k].substring(0,temp2[k].length()-1),ALA)+1)+",";
					}
					temp2[temp2.length-1] = "#"+Integer.toString(findTableIndex(temp2[temp2.length-1],ALA)+1);
					
					String temp3 = combineArray(temp2);
					MDTCount = updateTable(temp3,MDT);
				}
				MDTCount = updateTable(program[end],MDT);
			}	
		}

		writeOut.writeBytes("Macro Name Table:-\n");
		writeOut.writeBytes("MNTI\t\tMName\t\tMDTI\n");
		for(int i=0;i<MNTCount;i++)
		{
			writeOut.writeBytes((i+1)+"\t\t"+MNT[i]+"\t\t"+MDTindexes[i]+"\n");
		}
		
		writeOut.writeBytes("\nMacro Definition Table:-\n");
		writeOut.writeBytes("Index\t\tDefinition\n");
		for(int i=0;i<MDTCount;i++)
		{
			writeOut.writeBytes((i+1)+"\t\t"+MDT[i]+"\n");
		}
		
		writeOut.writeBytes("\nArgument List Array:-\n");
		writeOut.writeBytes("Index\t\tArgument\n");
		for(int i=0;i<ALACount;i++)
		{
			writeOut.writeBytes("#"+(i+1)+"\t\t"+ALA[i]+"\n");
		}
		
		//Pass 2 Code Begins
		writeOut.writeBytes("\nPass 2 :-");

		for(int i=end+1;i<program.length;i++)
		{
			String temp[] = program[i].split(" ");
			int mntPOS = findTableIndex(temp[0],MNT);
			//System.out.println(temp[0]+" "+mntPOS);
			if(mntPOS>=0)
			{
				for(int j=1;j<temp.length-1;j++)
				{
					temp[j]=temp[j].substring(0,temp[j].length()-1);
				//	System.out.println(temp[1]);
					ALA2Count = updateTable(temp[j],ALA2);
				}
				ALA2Count = updateTable(temp[temp.length-1],ALA2);
			}
		}

		writeOut.writeBytes("\nArgument List Array:-\n");
		writeOut.writeBytes("Index\t\tArgument\n");
		for(int i=0;i<ALA2Count;i++)
		{
			writeOut.writeBytes("#"+(i+1)+"\t\t"+ALA2[i]+"\n");
		}
		writeOut.close();
	}

	

	public static String[] readFile(String filename) throws IOException //store contents of file in string array
	{
		Scanner ip = new Scanner(new File(filename));
		ArrayList<String> lines = new ArrayList<String>();
		while(ip.hasNextLine())
		{
			lines.add(ip.nextLine());
		}
		return lines.toArray(new String[0]);
	}

	public static int updateTable(String x,String table[])
	{
		int temp=0;
		for(int i=0;i<table.length;i++)
		{
			if(table[i]==null)
			{
				temp=i+1;
				table[i]=x;
				break;
			}
		}
		return temp;
	}

	public static int findTableIndex(String x,String table[])
	{
		int pos=-1;
		for(int i=0;i<table.length;i++)
		{
			if(x.equals(table[i]))
			{
				pos=i;
				break;
			}
		}
		return (pos) ;
	}

	public static String combineArray(String x[])
	{
		String temp="";
		for(int i=0;i<x.length-1;i++)
		{
			temp=temp+x[i]+" ";
		}
		temp=temp+x[x.length-1];
		return temp;
	}
}
