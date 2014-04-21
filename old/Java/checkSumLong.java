//checksum via long way
//incomplete
import java.util.*;

class checkSumLong
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int n;
		System.out.print("Enter n : ");
		n=ip.nextInt();
		int numbers[]=new int[n],temp=0,temp2=0,checkSum;
		System.out.print("Enter numbers : ");
		for(int i=0;i<n;i++)
		{
			numbers[i]=ip.nextInt();
			temp+=numbers[i];
		}
		System.out.println("Decimal Sum : "+temp);
		String sumBinary=Integer.toBinaryString(temp);
		System.out.println("Decimal Sum in Binary : "+sumBinary);
 		//now split the binarySum into 4 bit strings and add
		//sumBinary=complement(sumBinary);
		//System.out.println(sumBinary);
		String tempBinary=new String();
		int remLength=sumBinary.length();
		while(remLength>0)
		{
			if(remLength<=4)
			{
				temp2+=Integer.parseInt(sumBinary.substring(0,remLength),2);
			}
			else
			{
				temp2+=Integer.parseInt(sumBinary.substring(remLength-4,remLength),2);
			}
			remLength-=4;
		}
		String finals=complement(Integer.toBinaryString(temp2));
		checkSum=Integer.parseInt(finals,2);
		System.out.println("Checksum : "+checkSum);
		int test=temp+checkSum;
		System.out.println("Sum + Checksum : "+test);
		System.out.println(Integer.toBinaryString(test));
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
