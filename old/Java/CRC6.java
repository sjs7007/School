//Own

import java.util.*;

class CRC6
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter msg : ");
		String msg=ip.next();
		System.out.print("Enter generator : ");
		String gen=ip.next();
		String temp=new String();
		String appendedmsg=msg; //msg with appended zeroes
		for(int i=0;i<gen.length()-1;i++)
		{
			appendedmsg=appendedmsg+'0';
		}
		System.out.println("Appended msg : "+appendedmsg);
		String result=CRC(appendedmsg,gen);
		System.out.println("Checksum : "+result);
		String finals=msg+result;
		System.out.println("Transmitted message : "+finals);
		System.out.print("Enter received message : ");
		String input=ip.next();
		String result2=CRC(input,gen);
		if(result2.equals("0"))
		{
			System.out.println("Message received is right!");
		}
		else
		{
			System.out.println("Message received is wrong.");
		}
	}

	public static String XOR(String s1,String s2)
	{
		String result=new String();
		for(int i=0;i<s1.length();i++)
		{
			int temp1=Integer.parseInt(Character.toString(s1.charAt(i)));
			int temp2=Integer.parseInt(Character.toString(s2.charAt(i)));
			result = result+Integer.toString(temp1^temp2);
		}
	//	System.out.println("Result: "+result);
		return result;
	}

	public static String CRC(String appendedmsg,String gen)
	{
		String temp=appendedmsg.substring(0,gen.length());
		String result=XOR(gen,temp);
		int pointer = gen.length();
		while(true)
		{
			int temp2=-1;
			for(int i=0;i<gen.length();i++)
			{
				if(result.charAt(i)=='1')
				{	
					break;
				}
				else if(result.charAt(i)=='0')
				{
					temp2++;
				}
			}
			result=result.substring(temp2+1,result.length());
			//System.out.println(result);
			temp2=pointer+gen.length()-result.length();
			if(temp2>appendedmsg.length())
			{
				temp2=appendedmsg.length();
			}
			result=result+appendedmsg.substring(pointer,temp2);
			pointer=temp2;
		//	System.out.println(result);
			if(result.length()<gen.length())
			{
				break;
			}
			result=XOR(gen,result);
		}
		return result;
	}
}
