import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here
		int sp = 0;
		int ep = 0;
		int zc = 0; //zero count
		int maxi = 0;

		while(ep<n){
			//introduce ep to the window
			if(arr[ep] == 0) zc++;
			//shrink until window is invalid
			while(zc > k){
				if(arr[sp] == 0) zc--;
				sp++;
			}
			//after this line our window will always be valid
			//i will try to update my ans
			maxi = Math.max(maxi,ep-sp+1);
			ep++;
		}
		return maxi;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}