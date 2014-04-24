import java.util.*;

class Apriori
{
	public static void main(String args[])
	{
		ArrayList<TreeSet<Integer>> transList = new ArrayList<TreeSet<Integer>>();
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,4)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,5)));
		
		/*int count1=0,count2=0;
		for(int i=0;i<transList.size();i++)
		{
			if(transList.get(i).contains(1))
			{
				count1++;
			}
			if(transList.get(i).containsAll(Arrays.asList(3,5)))
			{
				count2++;
			}
		}
		System.out.println(count1+ " "+count2);*/

		/*String trans = new String("1 2 3");*/

		ArrayList<TreeSet<Integer>> setSet = new ArrayList<TreeSet<Integer>>();
		setSet.add(new TreeSet<Integer>(Arrays.asList(1)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(2)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(3)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(4)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(5)));
	
		int x[];
		setSet.get(0).toArray(x);
		String temp = new String();
		for(int i=1;i<x.length;i++)
		{
			temp=temp+" "+Integer.toString(x[i]);
		}
		System.out.println(temp);


		String find = new String();

							
				int count1=0;
				//for(int k=0;k<transList.size();k++)
				{
					/*if(transList.get(k).containsAll(Arrays.asList(1,2,3,4,5,6,7,8)));
					{
						count1++;
					}*/
				//	System.out.println(transList.get(k));
					if(trans.contains("2 3"));
					{
						System.out.println("Yes");
					}
				}
				System.out.println(count1);
	}
}
