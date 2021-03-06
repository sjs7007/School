//BER for integers
//Tag:2 in binary 8 bits,length:4 in binary 8 bits,data:32 bits

import java.util.*;

class BER
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		String tag = Integer.toBinaryString(2);
		tag=appendZeroes(8,tag);
		String length = Integer.toBinaryString(4);
		length=appendZeroes(8,length);
		System.out.print("Enter an Integer : ");
		String data = Integer.toBinaryString(ip.nextInt());
		data = appendZeroes(32,data);
		System.out.println("BER Encoded Output : "+tag+"|"+length+"|"+data);
	}

	public static String appendZeroes(int nZeroes,String ip)
	{
		String temp=ip;
		int len=nZeroes-ip.length();
		for(int i=0;i<len;i++)
		{
			temp="0"+temp;
		}
		return temp;
	}
}
