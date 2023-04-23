import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,q;
        n=sc.nextInt();
        q=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.minSubarray(a,n,q));		    
    }
}

class Solution
{
  public int minSubarray(int[] A,int n, int p) {
      //Write code here
	// https://course.acciojob.com/idle?question=7aa67433-0a18-481d-98d9-602d65779b1a
	  int total = 0;
	  for(int x:A){
		  total = (total+x)%p;
	  }
	  if(total == 0) return 0; //you dont need to delete any subarray
	  HashMap<Integer,Integer> hm = new HashMap<>();
	  hm.put(0,-1); //this is to handle if we are searching for a zero, meaning remove all the people from starting index till ith index
	  int mini = Integer.MAX_VALUE;
	  int pref = 0;

	  for(int i = 0;i<n;i++){
		  pref = (pref+A[i])%p;
		  int key = (pref-total+p)%p;
		  if(hm.containsKey(key)){
			  mini = Math.min(mini,i-hm.get(key));
		  }
		  hm.put(pref,i);
	  }
	  return mini==A.length?-1:mini;
  }
}











