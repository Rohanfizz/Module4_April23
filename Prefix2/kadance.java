import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        //Write code here
		int train = 0;
		int maxi = Integer.MIN_VALUE;

		int asp = -1;
		int aep = -1;

		int ctsp = 0;
		int ctep = 0;
		
		for(int i = 0;i<n;i++){
			//if a[i] sits with prev train
			int prev = train + a[i];
			//if a[i] starts its new train
			int newTrain = a[i];
			train = Math.max(prev,newTrain);
			maxi = Math.max(maxi,train);
		}
		return maxi;
    }
	//if you want to print starting and ending points
	public long maxSubarraySum(int a[],int n){
        //Write code here
		int train = 0;
		int maxi = Integer.MIN_VALUE;

		int asp = -1;
		int aep = -1;

		int ctsp = 0;
		int ctep = 0;
		
		for(int i = 0;i<n;i++){
			//if a[i] sits with prev train
			int prev = train + a[i];
			//if a[i] starts its new train
			int newTrain = a[i];
			if(newTrain > prev){
				ctsp = i;
				train = newTrain;
			}else train = prev;
			ctep = i;
			if(maxi < train){
				maxi = train;
				asp = ctsp;
				aep = ctep;
			}
		}
		System.out.println(asp+" "+aep);
		return maxi;
    }
}












