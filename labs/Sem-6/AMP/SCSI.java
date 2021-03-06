//SCSI

import java.util.*;

class Device
{
	int id,priority;

	Device(int x,int y)
	{
		id=x;
		priority=y;
	}
}

class SCSI
{
	public static void main(String args[])
	{
		int nDevices;
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number of devices : ");
		nDevices = ip.nextInt();
		Device dList[]=new Device[nDevices];
		
		for(int i=0;i<nDevices;i++)
		{
			System.out.print("Enter device id and priority : ");
			dList[i] = new Device(ip.nextInt(),ip.nextInt());
		}

		for(int i=0;i<nDevices;i++)
		{
			int index = maxPriority(dList);
			System.out.println("Device "+dList[index].id+" is granted bus.");
			System.out.print("Enter no. of bits to be transferred for device "+dList[index].id+" : ");
			int temp = ip.nextInt();
			System.out.print("Transmitting bits.... ");
			for(int j=0;j<temp;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println("\nTransmission completed...");
			System.out.println("Bus is released.");
			dList[index].priority=-1;

		}
	}

	public static int maxPriority(Device x[])
	{
		int index=0,priority=x[0].priority;
		for(int i=1;i<x.length;i++)
		{
			if(x[i].priority>priority)
			{
				index=i;
				priority=x[i].priority;
			}
		}
		return index;
	}
}
