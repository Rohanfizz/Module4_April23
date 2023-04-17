import java.util.*;

public class Main {

    public static int ValidTriangles(int n,int[] arr){
        //write code here

		//tc:o(n2)
		//sc:1
		Arrays.sort(arr);
		int ans = 0;
		for(int i = n-1;i>=0;i--){
			int l = 0;
			int r = i-1;

			while(l<r){
				if(arr[l] + arr[r] > arr[i]){
					ans += r-l;
					r--;
				}else l++;
			}
		}
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int ans  ValidTriangles(n,arr);
        System.out.println(ans);
    }
}