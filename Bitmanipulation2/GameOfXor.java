import java.util.*;
class Solution
{
       static int xorSubarrayXors(int arr[], int n) {
        //Write code 
		   int res = 0;
		   for(int i = 0;i<n;i++){
			   //if im able to calculate = in howmany subarrays does this
			   // ith element comes, ill come to the freq of this element
			   //in the overall answer
			   //number of subarrays ith person comes in = (i+1)*(n-i)
			   //where i+1 are count of valid starting points
			   //and n-i is the count of valid endingpoints
			   int contri = (i+1)*(n-i);
			   if(contri % 2==1){
				   //odd means xor will be conside  red
				   //as n^n = 0; and n^n^n = n;
				   res ^= arr[i];
			   }
		   }
		   return res;
    }
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}