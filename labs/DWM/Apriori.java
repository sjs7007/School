import java.util.*;

class Apriori
{
	public static void main(String args[])
	{
		int nTrans=4,nItems=5;
		ArrayList<TreeSet<Integer>> transList = new ArrayList<TreeSet<Integer>>();
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,4)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,5)));

		ArrayList<TreeSet<Integer>> setSet = new ArrayList<TreeSet<Integer>>();
		setSet.add(new TreeSet<Integer>(Arrays.asList(1)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(2)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(3)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(4)));
		setSet.add(new TreeSet<Integer>(Arrays.asList(5)));

		//System.out.print(transList.get(0).containsAll(Arrays.asList(setSet.get(0).toArray())));
		//Use above code to check if subset

		//find count of sets from transaction
		for(int i=0;i<nItems;i++)
		{
			int count=0;
			for(int j=0;j<nTrans;j++)
			{
				if(transList.get(j).containsAll(Arrays.asList(setSet.get(i).toArray())))
				{
					count++;
				}
			}
			System.out.println(setSet.get(i)+" : "+count);
		}
	}
}
