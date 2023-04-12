import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int arr[][], Pair queries[]) {
        // Your code here
		List<Integer> res = new ArrayList<Integer>();
		int n = arr.length; int m = arr[0].length;
		int[][] pref = new int[n][m];

		pref[0][0] = arr[0][0];

		//for first row
		for(int j = 1;j<m;j++)  pref[0][j] = pref[0][j-1] + arr[0][j];
		//for first column
		for(int i = 1;i<n;i++) pref[i][0] = pref[i-1][0] + arr[i][0];

		for(int i = 1;i<n;i++){
			for(int j = 1;j<m;j++){
				int A = arr[i][j];
				int B = pref[i][j-1];
				int C = pref[i-1][j];
				int D = pref[i-1][j-1];
				pref[i][j] = A + B + C - D;
			}
		}
		//now our 2d prefix sum array is ready

		for(Pair q:queries){
			int x1 = q.row1;
			int y1 = q.col1;
			int x2 = q.row2;
			int y2 = q.col2;
			res.add(getSum(x1,y1,x2,y2,pref));
		}
		return res;
    }
	public int getSum(int x1,int y1,int x2,int y2,int[][] pref){
		int A = pref[x2][y2];
		int B = y1==0 ? 0 : pref[x2][y1-1];
		int C = x1==0 ? 0 : pref[x1-1][y2];
		int D = (x1==0 || y1==0)? 0 : pref[x1-1][y1-1];
		return A-B-C+D;
	}
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}