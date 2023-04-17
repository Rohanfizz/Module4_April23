import java.util.*;

class Solution {

	public int longestWindowXuniqueAtLeastKRepeating(String s,int k,int x){
		int countUnique = 0;
		int countKRep = 0;
		int sp = 0;
		int ep = 0;
		int ans = 0;
		int[] freq = new int[123];

		while(ep<s.length()){
			//introduce new character
			char nc = s.charAt(ep);
			freq[nc]++;
			if(freq[nc] == 1) countUnique++;
			if(freq[nc] == k) countKRep++;

			//shrink untin unique characters <= x
			while(countUnique > x){
				char dc = s.charAt(sp);
				freq[dc]--;

				if(freq[dc] == 0) countUnique--;
				if(freq[dc] == k-1) countKRep--;
				sp++;
			}

			//the window will be valid, but it is possible that
			//either we are not having exactly x unique
			//or all the characters are not krepeating
			if(countUnique == x && countKRep == x){
				ans = Math.max(ans,ep-sp+1);
			}
			ep++;
		}
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int i = 1;i<=26;i++){
			int xuniquerep = longestWindowXuniqueAtLeastKRepeating(s,k,i);
			ans = Math.max(xuniquerep,ans);
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
