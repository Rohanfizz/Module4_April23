
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
	//your code
		int[] station = new int[1001];

		for(int[] trip : trips){
			int num = trip[0];
			int sp = trip[1];
			int ep = trip[2];
			station[sp] += num;
			station[ep] -= num;
		}
		//now we have to create a prefix sum array
		for(int i = 1;i<1001;i++){
			station[i] = station[i] + station[i-1];
		}

		//now we need to traverse over every station, and check
		//if number of passengers become > k for any station.
		for(int i = 0;i<1001;i++){
			if(station[i] > capacity) return false;
		}
		return true;
	}
}
