import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		Collections.sort(A,(a,b)->{
			return a.get(0) - b.get(0);
		});

		int prevsp = -1;
		int prevep = -1;
		int cnt = 0;

		for(List<Integer> interval : A){
			int csp = interval.get(0);
			int cep = interval.get(1);
			if(csp<=prevep){//are intervals overlapping?
				//if the curr and prevly selected interv. overlap,
				//i have to make a choice
				//if the curr inter. is having < ep,
				//i will update the prev pointers to curr interval
				//else i do nothing as im already having better (if prevep < cep)
				if(cep < prevep){
					prevsp = csp;
					prevep = cep;
				}
			}else{
				//if intervals are not overlapping
				//i can simply take into consideration the curr interval as well
				cnt++;
				prevsp = csp;
				prevep = cep;
			}
		}
		return cnt;
		
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
