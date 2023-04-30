import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int arr[][]=new int[n-1][2];
      for(int i=0;i<n-1;i++){
        for(int j=0;j<2;j++){
            arr[i][j]=sc.nextInt();   
        }
      }
      Solution ob = new Solution();
      System.out.println(ob.findCenter(n,arr));
      
   }
}

class Solution {
	//https://course.acciojob.com/idle?question=f941e196-c628-446e-bce3-9ec899602d2c
    public int findCenter(int n,int[][] edges) {
        //Write code here
		int[] nbrs = new int[n+1];
		for(int[] e: edges){
			int u = e[0];
			int v = e[1];
			nbrs[v]++;
			nbrs[u]++;
		}
		for(int i = 1;i<=n;i++)if(nbrs[i]== n-1) return i;
		return -1;
    }
}










