//Mealy machine 
//ends in 110 A 101 B else C

import java.util.*;

class Mealy
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter String : ");
		String temp=ip.next();
		char temp2[]=temp.toCharArray();
		int cs=0,ns=0; //current state,next state
		char output='C';
		for(int i=0;i<temp2.length;i++)
		{
			if(temp2[i]=='0')
			{
				if(cs==0)
				{
					ns=0;
					output='C';
				}
				else if(cs==1)
				{
					ns=2;
					output='C';
				}
				else if(cs==2)
				{
					ns=0;
					output='C';
				}
				else if(cs==3)
				{
					ns=2;
					output='B';
				}
			}
			else
			{
				if(cs==0)
				{
					ns=1;
					output='C';
				}
				else if(cs==1)
				{
					ns=3;
					output='C';
				}
				else if(cs==2)
				{
					ns=1;
					output='A';
				}
				else if(cs==3)
				{
					ns=3;
					output='C';
				}
			}
			System.out.println("On input "+temp2[i]+", transition from q"+cs+" to q"+ns);
			System.out.println("Output : "+output);
			cs=ns;
		}
	}
}
