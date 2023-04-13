import java.util.*;

class Solution {

	public int maxSubArraySumAtmostK(int[] arr,int k){
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(0);
		int pref = 0;
		int maxi = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++){
			pref += arr[i];
			Integer closestToIdeal = ts.ceiling(pref-k);
			if(closestToIdeal != null){
				int subArraySum = pref-closestToIdeal;
				maxi = Math.max(maxi,subArraySum);
			}

			ts.add(pref);
		}
		return maxi;
	}
	// TC: m2 * (n+nlogn)
    public int maxSumSubmatrix(int[][] arr, int k) {
        //Write code here
		int ans = Integer.MIN_VALUE;
		for(int left = 0;left<arr[0].length;left++){
			int[] rows = new int[arr.length];

			for(int right = left;right<arr[0].length;right++){
				
				for(int i = 0;i<arr.length;i++) rows[i] += arr[i][right];
				int currAns = maxSubArraySumAtmostK(rows,k);
				ans= Math.max(ans,currAns);
			}
			
		}
		return ans;		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}