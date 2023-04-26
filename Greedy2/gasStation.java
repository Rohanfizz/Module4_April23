import java.util.*;

class Solution {
    
    public int filling(int gas[],int cost[],int n) {
        //Write your code here
		int totalGas = 0;
		int totalCost = 0;
		
		for(int i = 0;i<n;i++){
			totalGas+=	gas[i];
			totalCost += cost[i];
		}

		if(totalGas < totalCost) return -1;

		//now that we have come on this line,
		//this means answer does exist
		int start = -1; //potantial start point
		int tank =0;

		for(int i = 0;i<n;i++){
			int diff = gas[i] - cost[i];
			tank+=diff;

			if(tank<0){
				//tank is invalid, so reset tank and start
				tank = 0;
				start = -1;
			}else{
				if(start == -1)  start = i;
			}
		}
		return start;
		
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
