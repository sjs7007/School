import java.util.*;

class Apriori
{
	public static void main(String args[])
	{
		int nTrans=4,nItems=5,confidenceValue=2;
		ArrayList<TreeSet<Integer>> transList = new ArrayList<TreeSet<Integer>>();
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,4)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(1,2,3,5)));
		transList.add(new TreeSet<Integer>(Arrays.asList(2,5)));

		ArrayList<TreeSet<Integer>> cSet = new ArrayList<TreeSet<Integer>>(); //cSet = candidate set
		cSet.add(new TreeSet<Integer>(Arrays.asList(1)));
		cSet.add(new TreeSet<Integer>(Arrays.asList(2)));
		cSet.add(new TreeSet<Integer>(Arrays.asList(3)));
		cSet.add(new TreeSet<Integer>(Arrays.asList(4)));
		cSet.add(new TreeSet<Integer>(Arrays.asList(5)));

		//System.out.print(transList.get(0).containsAll(Arrays.asList(cSet.get(0).toArray())));
		//Use above code to check if subset

		ArrayList<TreeSet<Integer>> largeSet = new ArrayList<TreeSet<Integer>>();

		//find count of sets from transaction and if > confidence value, add to large set
		for(int i=0;i<cSet.size();i++)
		{
			int count=0;
			for(int j=0;j<nTrans;j++)
			{
				if(transList.get(j).containsAll(Arrays.asList(cSet.get(i).toArray())))
				{
					count++;
				}
			}
			System.out.println(cSet.get(i)+" : "+count);
			if(count>=confidenceValue)
			{
				System.out.println("Add to large set...");
				largeSet.add(cSet.get(i));
			}
		}

		System.out.println("Large Item Set : "+largeSet);

		//form new candidate set of size last+1
		cSet = new ArrayList<TreeSet<Integer>>();
		for(int i=0;i<largeSet.size();i++)
		{
			for(int j=i+1;j< largeSet.size();j++)
			{
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.addAll(largeSet.get(i));
				temp.addAll(largeSet.get(j));
				if(temp.size()==2 && !cSet.contains(temp)) //should be of last+1 size and not already be present in new cSet
				{
					cSet.add(temp);
				}
			}
		}

		System.out.println("New Candidate Set : "+cSet);

	}
}
