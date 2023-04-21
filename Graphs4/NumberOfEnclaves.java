import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

	public static void destroy(int i,int j,int[][] grid){
		if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j] == 0) return;
		grid[i][j] = 0;

		destroy(i-1,j,grid);
		destroy(i,j-1,grid);
		destroy(i+1,j,grid);
		destroy(i,j+1,grid);
	}
	
  public static int numEnclaves(int[][] grid) {
    // your code here
	  
	  int n = grid.length;
	  int m = grid[0].length;
	  for(int j = 0;j<m;j++){
		  //top boundary
		  if(grid[0][j]== 1) destroy(0,j,grid);
		  //bottom boundary
		  if(grid[n-1][j] == 1) destroy(n-1,j,grid);
	  }

	  for(int i = 0;i<n;i++){
		  //left boundary
		  if(grid[i][0] == 1) destroy(i,0,grid);
		  //right boundary
		  if(grid[i][m-1]==1) destroy(i,m-1,grid);
	  }

	  //now all unsafe islands are destroyed
	  //count the remaining safe land cells
	  int ans = 0;
	  for(int i = 0;i<n;i++){
		  for(int j = 0;j<m;j++) if(grid[i][j] == 1) ans++;
	  }
	  return ans;
	  
  }
}