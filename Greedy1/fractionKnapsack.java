import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int cap, Item arr[], int n) {
       // Write your code here
		Arrays.sort(arr,(a,b)->{
			double pwa = 1.0 * a.value / a.weight;
			double pwb = 1.0 * b.value / b.weight;
			//we cant simply return pwb-pwa as return type of lambda function is int
			if(pwa > pwb) return -1;
			return 1;
		});
		double totalProfit = 0.0;
		for(Item item: arr){
			int w = item.weight;
			int p = item.profit;
			if(cap >= w){
				//if i can completely engulf this item
				cap-=w;
				totalProfit += p;
			}else{
				//if i cannot engulf this item completely,
				//i want to break this item
				double costOfSingleUnit = 1.0* p/w;
				double profitAfterBreaking = 1.0* cap * costOfSingleUnit ;
				cap = 0;
				totalProfit+=profitAfterBreaking;
				break;
			}
		}
		return totalProfit;
    }
}



















