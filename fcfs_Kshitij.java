import java.util.*;

public class fcfs {
public static void main(String args[])
{
	int i,j,n,temp,totwt=0,tottat=0;
	Scanner s=new Scanner(System.in);
	System.out.println("enter no of processes: ");
	n=s.nextInt();
	int at[]=new int[n];
	int bt[]=new int[n];
	int pid[]=new int[n];
	int wt[]=new int[n];
	int tat[]=new int[n];
	float avgwt=0,avgtat=0;
	
	//input
	for(i=0;i<n;i++)
	{
		System.out.println("enter process"+(i+1)+"arival time");
		at[i]=s.nextInt();
		System.out.println("enter process"+(i+1)+"brust time");
		bt[i]=s.nextInt();
		pid[i]=i+1;
	}
	
	//sorting
	for(i=0;i<n-1;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(at[i]>at[j])
			{
				temp=at[i];
				at[i]=at[j];
				at[j]=temp;
				
				temp=bt[i];
				bt[i]=bt[j];
				bt[j]=temp;
				
				temp=pid[i];
				pid[i]=pid[j];
				pid[j]=temp;
				
			}
		}
	}

	//calculation
	
	//wt
	wt[0]=0;
//	wt[1]=0;
	for(i=1;i<n;i++)
	{
		wt[i]=wt[i-1]+bt[i-1];
		totwt=totwt+wt[i];
		avgwt=totwt;
	}
	
	//turn around
	for(i=0;i<n;i++)
	{
		tat[i]=wt[i]+bt[i];
		tottat=tottat+tat[i];
		avgtat=tottat;
		
	}
	
	//printing
	System.out.println("pid\t"+"at\t"+"bt\t"+"wt\t"+"tat");
	for(i=0;i<n;i++)
	{
		System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
	}
	System.out.println("avg wt= "+avgwt/n);
	System.out.println("avg tat= "+avgtat/n);
}
}
