import java.util.*;

class Solution {

		public int getSum(int sp,int ep,int[] pref){
			if(sp == 0) return pref[ep];
			return pref[ep] - pref[sp-1];
		}
	
        public int[] sumQuery(int[] arr, int[][] queries) {
            // Your code here.

			int[] ansToEveryQuery = new int[queries.length];
			int currQuery = 0;
			
			//step 1: create prefix sum array
			int[] pref = new int[arr.length];
			pref[0] = arr[0];
			for(int i = 1;i<arr.length;i++) pref[i] = pref[i-1] + arr[i];
			//step 2: answer every query
			for(int[] q: queries){
				int sp = q[0];
				int ep = q[1];
				ansToEveryQuery[currQuery] = (getSum(sp,ep,pref));
				currQuery++;
			}
			return ansToEveryQuery;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}