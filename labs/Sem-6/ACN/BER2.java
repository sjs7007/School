//BER for octet string
//Tag:4 in binary 8 bits,length:length of string in binary 8 bits,data:32 bits

import java.util.*;

class BER2
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		String tag = Integer.toBinaryString(4);
		tag=appendZeroes(8,tag);
		System.out.print("Enter a String : ");
		String temp = ip.next();
		String length = Integer.toBinaryString(temp.length());
		length=appendZeroes(8,length);
		
		String data="";
		for(int i=0;i<temp.length();i++)
		{
		//	System.out.println(appendZeroes(8,Integer.toBinaryString((int)(temp.charAt(i)))));
			data = data+appendZeroes(8,Integer.toBinaryString((int)(temp.charAt(i))));
		}

		data = appendZeroes(32,data);
		System.out.println("BER Encoded Output : "+tag+"|"+length+"|"+data);
		System.out.print("BCD : ");	
		data=tag+length+data;
		for(int i=0;i<data.length();i=i+8)
		{
			temp = Integer.toString(Integer.parseInt(data.substring(i,i+4),2))+Integer.toString(Integer.parseInt(data.substring(i+4,i+8),2));
			System.out.print("|"+temp+"|");
		}
		System.out.println();
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
