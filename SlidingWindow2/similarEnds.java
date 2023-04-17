import java.util.*;

class Solution {
	static int solve(String s) {
		//Write your code here
		int l = 0;
		int r = s.length()-1;

		while(l<r){
			
			if(s.charAt(l) != s.charAt(r)){
				break;
			}

			char curr = s.charAt(l);
			while(l<r && s.charAt(l) == curr) l++;
			while(r>l && s.charAt(r) == curr) r--;
		}

		//if the loop broke due to l == r condition
		if(l == r) return 0;
		return r-l+1;
	}
}
public class Main{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}