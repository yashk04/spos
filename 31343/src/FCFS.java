import java.text.ParseException;
import java.util.*;
  
class FCFS {  
    static void findWaitingTime(int processes[], int n, 
            int bt[], int wt[]) {   
        wt[0] = 0;  
        for (int i = 1; i < n; i++) { 
            wt[i] = bt[i - 1] + wt[i - 1]; 
        } 
    }   
    static void findTurnAroundTime(int processes[], int n, 
            int bt[], int wt[], int tat[])   
        for (int i = 0; i < n; i++) { 
            tat[i] = bt[i] + wt[i]; 
        } 
    } 
  
    //Function to calculate average time  
    static void findavgTime(int processes[], int n, int bt[]) { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0;   
        findWaitingTime(processes, n, bt, wt);  
        findTurnAroundTime(processes, n, bt, wt, tat); 
        System.out.printf("Processes Burst time Waiting time Turn around time\n");
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.printf(" %d ", (i + 1)); 
            System.out.printf("     %d ", bt[i]); 
            System.out.printf("     %d", wt[i]); 
            System.out.printf("     %d\n", tat[i]); 
        } 
        float s = (float)total_wt /(float) n; 
        int t = total_tat / n; 
        System.out.printf("Average waiting time = %f", s); 
        System.out.printf("\n"); 
        System.out.printf("Average turn around time = %d ", t); 
    } 
  
    // Driver code  
    public static void main(String[] args) throws ParseException { 
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of processes:"); 
        int n = s.nextInt();
        System.out.println("Enter processes:");
        int []processes = new int[n];
        for(int i=0;i<n;i++) {
        	processes[i] = s.nextInt();
        }
        System.out.println("Enter burst time:");
        int []burst_time = new int[n];
        for(int i=0;i<n;i++) {
        	burst_time[i] = s.nextInt();
        } 
  
        findavgTime(processes, n, burst_time); 
  
    } 
} 
