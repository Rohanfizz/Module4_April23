import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean ithBitSet(int n,int i){
		return (n & (1<<i)) != 0;
	}
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] freq = new int[32]; //how much is ith bit contributing

		for(int x: nums){
			for(int bit = 0;bit<32;bit++){
				if(ithBitSet(x,bit)) freq[bit]++;
			}
		}

		//now my freq array is having the information as to how much the ith bit is contributing
		int ans = 0;
		for(int bit = 0;bit<32;bit++){
			if(freq[bit]%3 == 1){
				ans |= (1<<bit);
			}
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}