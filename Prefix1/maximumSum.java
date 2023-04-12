import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		//tc: nlogn because of sorting
		//Step 1: creating contri array
	    int[] contri  = new int[A.length];
		
		for(int[] op: ops){
			int sp = op[0];
			int ep = op[1];
			contri[sp]++;
			if(ep+1<A.length) contri[ep+1]--;
		}
		for(int i = 1;i<A.length;i++) contri[i] += contri[i-1];
		//Sort both
		Arrays.sort(A);
		Arrays.sort(contri);
		// summation
		int sum = 0;
		int md = 1000000007;
		for(int i =0;i<A.length;i++) sum = (sum%md +  (A[i] * contri[i])%md)%md;
		return sum%md;
		
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



