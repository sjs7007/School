//101 if ends in A,110 ends in B else C
//working final
import java.util.*;

class MooreSmaller
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter String : ");
		String temp=ip.next();
		char temp2[]=temp.toCharArray();
		int cs=0,cs2=0,output=0;
		char disp='C';
		for(int i=0;i<temp2.length;i++)
		{
			if(temp2[i]=='0')
			{
				if(cs==0)
				{
					cs2=0;
				}
				else if(cs==1)
				{
					cs2=2;
				}
				else if(cs==2)
				{
					cs2=0;
				}
				else if(cs==3)
				{
					cs2=5;
				}
				else if(cs==4)
				{
					cs2=2;
				}
				else if(cs==5)
				{
					cs2=0;
				}
			}
			else 
			{
				if(cs==0)
				{
					cs2=1;
				}
				else if(cs==1)
				{
					cs2=3;
				}
				else if(cs==2)
				{
					cs2=4;
				}
				else if(cs==3)
				{
					cs2=3;
				}
				else if(cs==4)
				{
					cs2=3;
				}
				else if(cs==5)
				{
					cs2=4;
				}
			}
			System.out.println("On input symbol "+temp2[i]+", transition from q"+cs+" to q"+cs2);
			if(cs2==0 || cs2==1 || cs2==2 || cs2==3)
			{
				disp='C';
			}
			else if(cs2==4)
			{
				disp='A';
			}
			else
			{
				disp='B';
			}
			cs=cs2;
			System.out.println("Output state : "+disp);
		}
	}
}
