import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
		// TC: O(n)
		int l = 0;
		int r = A.length-1;

		while(l<r){
			int currPairSum = A[l] + A[r];
			if(currPairSum == target){
				//i have found an answer
				//i have to return an array containing the 1 based indexing of l and r
				// return {l+1, r+1};
				int[] ans = new int[2];
				ans[0] = l+1;
				ans[1] = r+1;
				return ans;
			}else if(currPairSum < target){
				l++;
			}else if(currPairSum > target){
				r--;
			}
		}
		//dummy return because we will always find an answer
		//according to the question
		return new int[0];
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



