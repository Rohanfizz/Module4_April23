package Prefix2;
import java.util.*;

class Solution {

    public long solve(int grid[][]) {
        // Your code here
		int n = grid[0].length;
		long[] prefFromRow1 = new long[n];
		long[] suffixFromRow0 = new long[n];

		//making suffix sum array out of row0
		suffixFromRow0[n-1] = grid[0][n-1];
		for(int i = n-2;i>=0;i--) suffixFromRow0[i] = grid[0][i] + suffixFromRow0[i+1];

		//making prefix sum array out of row1
		prefFromRow1[0] = grid[1][0];
		for(int i = 1;i<n;i++) prefFromRow1[i] = grid[1][i] + prefFromRow1[i-1];

		//lets generate all the possible paths  for robot a
		//a path for robot a can be determined by the col "j" where robot a will be switching rows
		//for every j, we'll be having different paths (total n paths) for robot a
		long overall = Long.MAX_VALUE;
		for(int j = 0;j<n;j++){
			//if robot a switches its row on jth col, robot b is left with two choices.
			long choice1 = j+1<n ? suffixFromRow0[j+1] : 0; //collect all the people after we switched the row
			long choice2 = j-1>=0 ?prefFromRow1[j-1] : 0;//collect all the people before we switched the row
			long robotBbest = Math.max(choice1,choice2);
			//the min of all the bests
			overall = Math.min(overall,robotBbest);
		}
		return overall;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}