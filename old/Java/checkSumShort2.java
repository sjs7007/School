//shortcut checksum

import java.util.*;

class checkSumShort2
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = ip.nextInt();
		System.out.print("Enter numbers : ");
		int numbers[]=new int[n],temp=0;
		for(int i=0;i<n;i++)
		{
			numbers[i]=ip.nextInt();
			temp+=numbers[i];
		}
		System.out.println("Decimal Sum : "+temp);
		String tempBinary=Integer.toBinaryString(temp);
		System.out.println("Decimal Sum in Binary : "+tempBinary);
		tempBinary=complement(tempBinary);
		System.out.println("Complement Binary : "+tempBinary);
		int checkSum=Integer.parseInt(tempBinary,2);
		System.out.println("CheckSum : "+checkSum);
		/*temp=temp+checkSum;
		System.out.println("Sum+CheckSum : "+temp);
		tempBinary=Integer.toBinaryString(temp);
		tempBinary=complement(tempBinary);
		System.out.println("Complement of dec+checksum : "+tempBinary);
		if(Integer.parseInt(tempBinary,2)==0)
		{
			System.out.println("Right!");
		}
		else
		{
			System.out.println("Wrong!");
		}*/
		System.out.println("Receiver Side ");
		System.out.print("Enter n : ");
		n = ip.nextInt();
		int numbers2[]=new int[n+1];
		System.out.print("Enter numbers : ");
		temp=0;
		for(int i=0;i<n;i++)
		{
			numbers[i]=ip.nextInt();
			temp+=numbers[i];
		}
		System.out.print("Enter checksum : ");
		checkSum=ip.nextInt();
		System.out.println("Decimal Sum : "+temp);
		tempBinary=Integer.toBinaryString(temp);
		System.out.println("Decimal Sum in Binary : "+tempBinary);
		tempBinary=complement(tempBinary);
		System.out.println("Complement Binary : "+tempBinary);
		//checkSum=Integer.parseInt(tempBinary,2);
		//System.out.println("CheckSum : "+checkSum);
		temp=temp+checkSum;
		System.out.println("Sum+CheckSum : "+temp);
		tempBinary=Integer.toBinaryString(temp);
		tempBinary=complement(tempBinary);
		System.out.println("Complement of dec+checksum : "+tempBinary);
		if(Integer.parseInt(tempBinary,2)==0)
		{
			System.out.println("Right!");
		}
		else
		{
			System.out.println("Wrong!");
		}


	}

	public static String complement(String src)
	{
		String des=new String();
		for(int i=0;i<src.length();i++)
		{
			if(src.charAt(i)=='0')
			{
				des+="1";
			}
			else
			{
				des+="0";
			}
		}
		return des;
	}
}
