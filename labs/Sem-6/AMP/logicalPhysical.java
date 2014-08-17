class logicalPhysical
{
	public static void main(String args[])
	{
		//System.out.println(randString());
		String selector="0000000000110001";
		String offset="0000000000000001";
		String indexIntoDesc=selector.substring(0,13); //extract 1st 13 bits
		System.out.println("Index : "+indexIntoDesc);
		int decimalIndex = Integer.parseInt(indexIntoDesc,2); //convert from binary to decimal
		System.out.println("Decimal Index : "+decimalIndex);
		String localTable[]=new String[10];
		String globalTable[]=new String[10];
		System.out.println("Local Table :-");
		for(int i=0;i<localTable.length;i++)
		{
			localTable[i]=randString();
			System.out.println(i+" "+localTable[i]);
		}
		System.out.println("Global Table :-");
		for(int i=0;i<globalTable .length;i++)
		{
			globalTable [i]=randString();
			System.out.println(i+" "+globalTable [i]);
		}
		//0-Global Table,1-local table
		String answer="",temp32RightBits="";
		if(selector.charAt(13)=='0')
		{
			System.out.println("Global descriptor.");
			temp32RightBits=globalTable[decimalIndex].substring(32,64);
		}
		else
		{
			System.out.println("Local descriptor");
			temp32RightBits=localTable[decimalIndex].substring(32,64);
		}
		System.out.println(temp32RightBits);
		answer = Long.toBinaryString(Long.parseLong(temp32RightBits,2)+Long.parseLong(offset,2));
		System.out.println("32-bit Physical Address : "+answer);
	}

	public static String randString() //generate a random binary string of 64 bits
	{
		String temp="";
		for(int i=0;i<64;i++)
		{
			temp = temp + Integer.toString((int)(Math.random()*100)%2);
		}
		return temp;
	}
}
