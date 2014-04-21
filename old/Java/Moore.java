//101 if ends in A,110 ends in B else C
//working final
import java.util.*;

class Moore
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
			if(cs==0)
			{
				if(temp2[i]=='0')
				{
					cs2=0;
				}
				else
				{
					cs2=1;

				}
			}

			else if(cs==1)
			{
				if(temp2[i]=='0')
				{
					cs2=2;
				}
				else
				{
					cs2=3;
				}
			}

			else if(cs==2)
			{
				if(temp2[i]=='0')
				{
					cs2=0;
				}
				else
				{
					cs2=4;
				}
			}

			else if(cs==3)
			{
				if(temp2[i]=='0')
				{
					cs2=5;
				}
				else
				{
					cs2=3;
				}
			}

			else if(cs==4)
			{
				if(temp2[i]=='0')
				{
					cs2=2;
				}
				else
				{
					cs2=3;
				}
			}

			else if(cs==5)
			{
				if(temp2[i]=='0')
				{
					cs2=0;
				}
				else
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
