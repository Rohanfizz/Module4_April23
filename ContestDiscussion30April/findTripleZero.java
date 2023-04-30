import java.util.*;
//https://course.acciojob.com/idle?question=5bc00c88-0d0b-441b-aebd-302ebec93eb5
class Solution {
    public boolean containsTriplet(int[] arr) {
        // Write code here
		Arrays.sort(arr);
		for(int i = 0;i<arr.length;i++){
			int newTar = -arr[i];
			int l = i+1;
			int r= arr.length-1;
			while(l<r){
				int csum = arr[l] + arr[r];
				if(csum ==newTar) return true;
				else if(csum < newTar) l++;
				else r--;
			}
		}
		return false;
    }
}
// a+b+c = 0
//  b + c = -a

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        boolean result = Obj.containsTriplet(arr);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        sc.close();
    }
}