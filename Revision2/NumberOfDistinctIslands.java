import java.util.*;

class Solution {

	
	
public static void dfs(int[][] grid,ArrayList<Integer> shape,int i,int j,int bi,int bj){
	if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0) return;

	grid[i][j] = 0; //destroy or mark visited
	
	shape.add(i-bi);
	shape.add(j-bj);

	//uldr
	dfs(grid,shape,i-1,j,bi,bj);
	dfs(grid,shape,i,j-1,bi,bj);
	dfs(grid,shape,i+1,j,bi,bj);
	dfs(grid,shape,i,j+1,bi,bj);
}

  
  public static int countDistinctIslands(int[][] grid) {
    // write your code here
	  HashSet<ArrayList<Integer>> hs = new HashSet<>();

	  for(int i = 0;i<grid.length;i++){
		  for(int j = 0;j<grid[0].length;j++){
			  if(grid[i][j] == 0) continue;
			  ArrayList<Integer> shape  = new ArrayList<>();
			
			  dfs(grid,shape,i,j,i,j);
			  hs.add(shape);
		  }
	  }
	  return hs.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}