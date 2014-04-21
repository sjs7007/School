//Own

import java.util.*;

class CRC
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
		for(int i=0;i<gen.length();i++)
		{
			appendedFrame=appendedFrame+'0';
		}
		System.out.println("Appended Frame : "+appendedFrame);
		temp=frame.substring(0,gen.length());
		XOR(gen,temp);
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
