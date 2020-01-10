import java.util.*;
public class RoundRobin
{ 
	static void findWaitingTime(int processes[], int n, int bt[], int wt[], int quantum) 
	{ 
		int rem_bt[] = new int[n]; 
		for (int i = 0 ; i < n ; i++) 
			rem_bt[i] =  bt[i]; 

		int t = 0;
		while(true) 
		{ 
			boolean done = true; 
			for (int i = 0 ; i < n; i++) 
			{ 
				if (rem_bt[i] > 0) 
				{ 
					done = false; // There is a pending process 

					if (rem_bt[i] > quantum) 
					{ 
						t += quantum; 
						rem_bt[i] -= quantum; 
					} 
					else
					{ 
						t = t + rem_bt[i]; 
						wt[i] = t - bt[i]; 
						rem_bt[i] = 0; 
					} 
				} 
			} 

			// If all processes are done 
			if (done == true) 
				break; 
		} 
	} 
	static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) 
	{ 
		for (int i = 0; i < n ; i++) 
			tat[i] = bt[i] + wt[i]; 
	} 
	static void findavgTime(int processes[], int n, int bt[], int quantum) 
	{ 
		int wt[] = new int[n], tat[] = new int[n]; 
		int total_wt = 0, total_tat = 0;  
		findWaitingTime(processes, n, bt, wt, quantum); 
		findTurnAroundTime(processes, n, bt, wt, tat); 
		System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time"); 
		for (int i=0; i<n; i++) 
		{ 
			total_wt = total_wt + wt[i]; 
			total_tat = total_tat + tat[i]; 
			System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " + wt[i] +"\t\t " + tat[i]); 
		} 

		System.out.println("Average waiting time = " + (float)total_wt / (float)n); 
		System.out.println("Average turn around time = " + (float)total_tat / (float)n); 
	} 
	public static void main(String[] args) 
	{ 
		Scanner s = new Scanner(System.in);
		int n,quantum;
		System.out.println("Enter time quantum:");
		quantum = s.nextInt();
		System.out.println("Enter number of process:");
		n = s.nextInt();
		int processes[] = new int[n]; 
		for(int i=0;i<n;i++)
		{
			processes[i] = i+1;
		}
		int burst_time[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter burst time for process " + processes[i]+":");
			burst_time[i] = s.nextInt();
		} 
		findavgTime(processes, n, burst_time, quantum); 
	} 
} 