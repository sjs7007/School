import java.io.*;
import java.util.*;
import java.sql.*;

class Record
{
	String creditHistory,debt,collateral,risk;
	int incomeGroup; //0:0-10k , 1:10-25k ,2:>25k
	Record(String x,String y,String z,int k,String l)
	{    creditHistory = x;
		debt = y;
		collateral = z;
		incomeGroup = k;
		risk = l;
	}
	void display()
	{
		System.out.println("Credit History : 		"+creditHistory);
		System.out.println("Debt : "+debt);
		System.out.println("Collateral : "+collateral);
		if(incomeGroup==0)
		{
			System.out.println("0-10k");
		}
		else if(incomeGroup==1)
		{
			System.out.println("10-25k");
		}
		else
		{
			System.out.println(">25k");
		}
		System.out.println("Risk : "+risk);
		System.out.print("----------");
		System.out.println();
	}
}
class Table
{
	int nEntries=12,nTest=2;
	Record recordTable[]=new Record[nEntries+1]; //+1 so that last location can be used to store tuple to be classified
	int nHR=0,nMR=0,nLR=0;
	double pHR,pMR,pLR;
	double pXHR=1,pXMR=1,pXLR=1;
	void display()
	{
		for(int i=0;i<nEntries;i++)
		{    System.out.println("Record "+(i+1)+":-");
			recordTable[i].display();
		}
	}			
	void calculateRiskProbability()
	{
		for(int i=0;i<nEntries;i++)
		{
			if(recordTable[i].risk.equals("HR"))
			{
				nHR++;	
			}
			else if(recordTable[i].risk.equals("LR"))
			{
				nLR++;		
			}
			else 
			{
				nMR++;
			}
		}
		//System.out.println(nHR+" "+nMR+" "+nLR);
		pHR = nHR/(double)nEntries;
		pMR = nMR/(double)nEntries;
		pLR = nLR/(double)nEntries;
	}
	int calculateCountXY(String x,String y,String typeX) //x will be one of the attributes except risk, y=risk, returns count 
	{
		int temp=0;
		for(int i=0;i<nEntries;i++)
		{
			if(typeX.equals("CH"))
			{
				if(recordTable[i].creditHistory.equals(x) && recordTable[i].risk.equals(y))
				{
					temp++;
				}
			}
			else if(typeX.equals("debt"))
			{
				if(recordTable[i].debt.equals(x) && recordTable[i].risk.equals(y))
				{
					temp++;
				}
			}
			else if(typeX.equals("collateral"))
			{
				if(recordTable[i].collateral.equals(x) && recordTable[i].risk.equals(y))
				{
					temp++;
				}
			}
			else if(typeX.equals("income"))
			{
				if(Integer.toString(recordTable[i].incomeGroup).equals(x) && recordTable[i].risk.equals(y))
				{
					temp++;
				}
			}
		}
		//System.out.println("Count for "+x+" and "+y+" : "+temp);
		return temp;
	}
	
	double calculatePXClass(String riskClass)
	{
		double temp;
		double den; //denominator
		if(riskClass.equals("HR"))
		{
			den=nHR;
		}
		else if(riskClass.equals("MR"))
		{
			den=nMR;
		}
		else
		{
			den=nLR;
		}
		den = Math.pow(den,4);
		double num=1;
		num = num * calculateCountXY(recordTable[12].creditHistory,riskClass,"CH");
		num = num * calculateCountXY(recordTable[12].debt,riskClass,"debt");
		num = num * calculateCountXY(recordTable[12].collateral,riskClass,"collateral");
		num = num * calculateCountXY(Integer.toString(recordTable[12].incomeGroup),riskClass,"income");
		System.out.println("num : "+num);
		System.out.println("den : "+den);
		temp = num/den;
		return temp;
	}
}
class Bayesian
{	
	public static void main(String args[]) throws IOException,SQLException
	{
		Scanner ip = new Scanner(System.in);
		Table T = new Table();
		/*T.recordTable[0] = new Record("bad","high","none",0,"HR");	
		T.recordTable[1] = new Record("unknown","high","none",1,"HR");	
		T.recordTable[2] = new Record("unknown","low","none",1,"MR");
		T.recordTable[3] = new Record("unknown","low","none",0,"HR");	
		T.recordTable[4] = new Record("unknown","low","none",2,"LR");	
		T.recordTable[5] = new Record("unknown","low","adequate",2,"LR");	
		T.recordTable[6] = new Record("bad","low","none",0,"HR");	
		T.recordTable[7] = new Record("bad","low","adequate",2,"MR");
		T.recordTable[8] = new Record("good","low","none",2,"LR");	
		T.recordTable[9] = new Record("good","high","adequate",2,"LR");	
		T.recordTable[10] = new Record("good","high","none",0,"HR");
		T.recordTable[11] = new Record("good","high","none",1,"MR");
		*/
		
		Connection connect = DriverManager.getConnection("jdbc:odbc:db");
		PreparedStatement statement = connect.prepareStatement("select * from bayesian");
		ResultSet rs = statement.executeQuery();
		int i=0;
		while(rs.next())
		{
			String temp1 = rs.getString(2);
			String temp2 = rs.getString(3);
			String temp3 = rs.getString(4);
			int temp4 = Integer.parseInt(rs.getString(5));
			String temp5 = rs.getString(6);
			T.recordTable[i]=new Record(temp1,temp2,temp3,temp4,temp5);
			System.out.println(temp1+" "+temp2+" "+temp3+" "+temp4+" "+temp5);
			i++;
		}
		
		//tuple to be classified
		System.out.print("Enter Credit History,Debt,Collateral,0 for <10k income,1 for 10-25k and 2 for >25k : ");
		T.recordTable[12] = new Record(ip.next(),ip.next(),ip.next(),ip.nextInt(),"");	
		//T.display();	
		T.calculateRiskProbability();
	//	T.calculateCountXY("1","HR","income");
		double temp1 = T.calculatePXClass("HR");
		double temp2 = T.calculatePXClass("MR");
		double temp3 = T.calculatePXClass("LR");
	/*	System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);*/
		temp1 =(temp1 * T.pHR)/(double)T.nEntries;
		temp2 =(temp2 * T.pMR)/(double)T.nEntries;
		temp3 =(temp3 * T.pLR)/(double)T.nEntries;
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		if(temp1>=temp2 && temp1>=temp3)
		{
			System.out.println("Sample belongs to High Risk category.");
		}
		else if(temp2>=temp1 && temp2>=temp3)
		{
			System.out.println("Sample belongs to Moderate Risk category.");
		}
		else
		{
			System.out.println("Sample belongs to Low Risk category.");
		}	
	}
}
/* 
Enter Credit History,Debt,Collateral,0 for <10k income,1 for 10-25k and 2 for >25k : unknown low none 1
num : 20.0
den : 625.0
num : 8.0
den : 81.0
num : 0.0
den : 256.0
0.0011111111111111111
0.0020576131687242796
0.0
Sample belongs to Moderate Risk category.
*/
