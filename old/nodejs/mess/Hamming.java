import java.util.*;

class Hamming
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		//System.out.print("Enter message : ");
		//String msg = ip.next();
		String msg=args[0];
		//now find number of parity bits needed using m+r+1<=2^m
		int r=0,m=msg.length();
		while(true)
		{
			if((m+r+1)<=Math.pow(2,r))
			{
				break;
			}
			r++;
		}
		System.out.println("Number of parity bits needed : "+r);
		int transLength=m+r,temp=0,temp2=0,j=0;
		int transMessage[]=new int[transLength+1]; //length+1 because fram starts from 1
		for(int i=1;i<=transLength;i++)
		{
			temp2=(int)Math.pow(2,temp);
			if(i%temp2!=0)
			{
				transMessage[i]=Integer.parseInt(Character.toString(msg.charAt(j)));
				j++;
			}
			else
			{
				temp++;
			}
		}

		for(int i=1;i<=transLength;i++)
		{
			System.out.print(transMessage[i]);
		}
		//now calculate parity bits
		System.out.println( );
		for(int i=0;i<r;i++)
		{
			int smallStep=(int)Math.pow(2,i);
			int bigStep=smallStep*2;
			int start=smallStep,checkPos=start;
			System.out.println("Small Step :"+smallStep);
			while(true)
			{
				for(int k=start;k<=(start+smallStep-1);k++)
				{
					checkPos=k;
					System.out.print(checkPos+" ");
					if(k>transLength)
					{
						break;
					}
					transMessage[smallStep]=transMessage[smallStep]^transMessage[checkPos];
				}
				if(checkPos>transLength)
				{
					break;
				}
				else
				{
					start=start+bigStep;
				}

			}
			System.out.println( );
		}	
		//dis answer
		System.out.println("Hamming Code Encoded Message : ");
		for(int i=1;i<=transLength;i++)
		{
			System.out.print(transMessage[i]);
		}


	}
}
