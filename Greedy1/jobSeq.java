import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n){
        // Your code here
		Arrays.sort(arr, (a,b)->{
			// -ve-> a is smaller
			// +ve-> a is bigger
			// 0-> a = b
			return b.profit - a.profit;
		} );
		boolean[] deadlines = new boolean[5005];
		int totalProfit = 0;
		int cnt = 0;

		for(Job cj: arr){
			int i = cj.deadline;
			while(i>0 && deadlines[i]==true) i--;
			if(i == 0) continue;
			//after the above while loop, "i" will be standing on the closest available day
			//to deadline
			deadlines[i] = true;
			cnt++;
			totalProfit+=cj.profit;
		}

		int[] res = new  int[2];
		res[0] = cnt;
		res[1] = totalProfit;
		return res;
		
    }
}















