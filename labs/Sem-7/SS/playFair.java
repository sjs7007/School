class playFair
{
	public static void main(String args[])
	{
		String key = "FRIDAY";
		String all="";
		for(int i=0;i<26;i++)
		{
			char c = (char)((int)'A'+i);
			if(c!='J')
			{
				all = all + Character.toString(c);
			}
		}

		for(int i=0;i<all.length();i++)
		{
			String temp = Character.toString(all.charAt(i));
			if(!key.contains(temp))
			{
				key = key + temp;
			}
		}

		char keyMatrix[][]= new char [5][5];

		int count=0;

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				keyMatrix[i][j]=key.charAt(count);
				count++;
			}
		}

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(keyMatrix[i][j]+" ");
			}
			System.out.println();
		}

		String input="MONDAY";
		String output=encDec(1,input,keyMatrix);

		System.out.println("Encoded Message "+input+" as : "+output);
		System.out.println("Decoded Message "+output+" as : "+encDec(-1,output,keyMatrix));
	}

	public static String encDec(int x,String ip,char keyMatrix[][]) //x=1for encryption else -1
	{
		//If message for encryption and not of even length, make it even
		if(x==1)
		{
			if(ip.length()%2!=0)
			{
				ip = ip + 'X';
			}
		}

		//encrypt or decrypt characters here 
		
		String output="";

		for(int z=0;z<ip.length();z=z+2)
		{
			char ch1 = ip.charAt(z);
			char ch2 = ip.charAt(z+1);

			//find position of char.
			int r1=-1,c1=-1,r2=-2,c2=-2; 
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(keyMatrix[i][j]==ch1)
					{
						r1=i;
						c1=j;
					}
					else if(keyMatrix[i][j]==ch2)
					{
						r2=i;
						c2=j;
					}
				}
			}

			//Case 1 : r1!=r2 and c1!=c2, same logic for encryption and decryption, exachange column of two nos
			if(r1!=r2 && c1!=c2)
			{
				output+=Character.toString(keyMatrix[r1][c2])+Character.toString(keyMatrix[r2][c1]);
			}

			//Case 2 : c1=c2, +x will take care of making it +1 for enc and -1 for dec
			else if(c1==c2)
			{
				output+=Character.toString(keyMatrix[(r1+x)%5][c1])+Character.toString(keyMatrix[(r2+x)%5][c2]);
			}

			//Case 3 : c1=c2
			else 
			{
				output+=Character.toString(keyMatrix[r1][(c1+x)%5])+Character.toString(keyMatrix[r2][(c2+x)%5]);
			}
		}

		return output;
	}
}
