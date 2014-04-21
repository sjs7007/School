//Own

import java.util.*;

class CRC3
{
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter frame : ");
		String frame=ip.next();
		System.out.print("Enter generator : ");
		String gen=ip.next();
		String temp=new String();
		String appendedFrame=frame; //frame with appended zeroes
		for(int i=0;i<gen.length()-1;i++)
		{
			appendedFrame=appendedFrame+'0';
		}
		System.out.println("Appended Frame : "+appendedFrame);
		temp=frame.substring(0,gen.length());
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
			System.out.println(result);
			temp2=pointer+gen.length()-result.length();
			if(temp2>appendedFrame.length())
			{
				temp2=appendedFrame.length();
			}
			result=result+appendedFrame.substring(pointer,temp2);
			pointer=temp2;
			System.out.println(result);
			result=XOR(gen,result);
			if(pointer==appendedFrame.length())
			{
				break;
			}
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
		System.out.println("Result: "+result);
		return result;
	}
}
