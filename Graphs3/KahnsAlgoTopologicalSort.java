import java.util.*;

class Solution {
 
    // @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] prerequisites) {
    //Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
		int[] indegree = new int[n];
		
		for(int[] e: prerequisites){
			int bi = e[1]; // bi
			int ai = e[0]; //ai
			//we need to do course bi first if we want to do ai
			graph.get(bi).add(ai);
			indegree[ai]++;
		}

		Queue<Integer> q= new LinkedList<>();
		//i will add all those people who's indegree is 0
		for(int i = 0;i<n;i++) if(indegree[i] == 0) q.add(i);

		ArrayList<Integer> topo = new ArrayList<>();
		//start bfs
		while(q.size()>0){
			int curr = q.remove();
			topo.add(curr);
			
			for(int nbr: graph.get(curr)){
				//i will decrese the indegree of nbr
				indegree[nbr]--;
				if(indegree[nbr] == 0) q.add(nbr);
			}
		}
		if(topo.size() < n){
			//the graph was not a DAG,it was having a cycle
			//hence topological sorting is not possible
			return new int[0];
		}
		int[] res = new int[n];
		for(int i = 0;i<n;i++) res[i] = topo.get(i);
		return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }
 
    }
}