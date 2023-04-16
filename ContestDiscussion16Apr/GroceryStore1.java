import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        int[] ans = s.bestProducts(arr);
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}

class Solution {
    public static int[] bestProducts(int[][] arr) {
     // Write your code
		int n = arr.length;//number of rows / number of products
		int m = arr[0].length;//number of cols / number of days
		int[] prefRows = new int[n];//maintains the prefix sum for a particular product
		int[] ans = new int[m];//ans[i] represents the max cumulative sum product till the ith day

		for(int day = 0;day<m;day++){
			int maxi = 0;
			int maxIdx = -1;

			for(int product = 0;product<n;product++){
				prefRows[product] += arr[product][day];

				if(prefRows[product] > maxi){
					maxi = prefRows[product];
					maxIdx = product;
				}
			}
			ans[day] = maxIdx;
		}
		return ans;
		
    }
}

// https://course.acciojob.com/idle?question=caf97df9-7181-4553-b489-54fb9d45c6bd













