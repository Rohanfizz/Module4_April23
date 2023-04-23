import java.io.*;
import java.util.*;

class Solution {
//https://course.acciojob.com/idle?question=b759dd60-d890-43e7-8971-7c24ee8c64fe
    public List<Integer> coldDrink(int arr[], int n, int k) {
        // write code here
		HashMap<Integer,Integer> hm = new HashMap<>();
		int sp= 0;
		int ep =0;
		int mini = Integer.MAX_VALUE;
		int osp = -1;
		int oep = -1;

		while(ep<n){
			int newdrink = arr[ep];
			hm.put(newdrink, hm.getOrDefault(newdrink,0) + 1 );

			while(hm.size()==k){
				if(ep-sp+1 < mini){
					mini = ep-sp+1;
					osp = sp;
					oep = ep;
				}
				//shrink
				hm.put(arr[sp],hm.get(arr[sp]) - 1);
				if(hm.get(arr[sp]) == 0) hm.remove(arr[sp]);
				sp++;
			}
			ep++;
		}
		List<Integer> res = new ArrayList<>();
		if(osp == -1){
			//i was not able to find the answer
			res.add(-1);
			return res;
		}
		res.add(osp);
		res.add(oep);
		return res;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        List<Integer> ans = Obj.coldDrink(arr, n, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }
}
