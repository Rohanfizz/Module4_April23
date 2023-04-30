import java.util.*;

class Solution {
	//https://course.acciojob.com/idle?question=2a52d218-f7ff-4261-af9d-5d2f4ae556a8
	public int atMostK(int[] arr,int k){
		int ans = 0;
		int sp = 0;
		int ep = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();//arr[i],freq

		while(ep<arr.length){
			//introduce
			hm.put( arr[ep], hm.getOrDefault(arr[ep],0) + 1);
			//shrink the window until is invalid
			while(hm.size() > k){
				hm.put(arr[sp],hm.get(arr[sp]) - 1);
				if(hm.get(arr[sp]) == 0) hm.remove(arr[sp]);
				sp++;
			}
			//if im standing on this line, my window is valid
			//this means my window has <=k distinct numbers
			ans += (ep-sp+1);
			ep++;
		}
		return ans;
	}
    public int kDistinctProd(int[] prods, int K) {
        //write code here
		return atMostK(prods,K) - atMostK(prods,K-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.kDistinctProd(A, k);
        System.out.println(res);
        sc.close();
    }
}
