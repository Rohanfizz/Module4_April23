import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution {
	public class Edge{
		int nbr;
		int wt;
		Edge(int nbr,int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public class Helper{
		int node;
		int cost;
		Helper(int node,int cost){
			this.node = node;
			this.cost = cost;
		}
	}
       public int networkDelayTime(int[][] times, int N, int K) {
        //Write code here
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0;i<=N;i++) graph.add(new ArrayList<>()); // pushing n+1 arraylists as question is having 1 based indexing
	    for(int[] e : times){
			int u = e[0];
			int v = e[1];
			int w = e[2];
			
			graph.get(u).add(new Edge(v,w));
		}

		PriorityQueue<Helper> pq = new PriorityQueue<>((a,b)->{
			return a.cost-b.cost;
		});
			int[] visited = new int[N+1]; //1 based indexing
		   Arrays.fill(visited,-1);
		   // for(int i = 0;i<visited.length;i++) visited[i] = -1
		   pq.add(new Helper(K,0)); //help me to initiate bfs
			int maxi = 0;
		   
		   while(pq.size()>0){
			   //remove
			   Helper curr = pq.remove();
			   int node = curr.node;
			   int cost = curr.cost;
			   //mark
			   if(visited[node] != -1) continue;
			   visited[node] = cost;
			   //work
			   maxi = Math.max(maxi,cost);
			   // maxi =cost;
			   //add neighbours
			   for(Edge e:graph.get(node)){
				   int nbr = e.nbr;
				   int wt = e.wt;
				   if(visited[nbr] == -1) pq.add(new Helper(nbr,cost+wt));
			   }
		   }

		   for(int i =1;i<=N;i++) if(visited[i] == -1) return -1;
		   return maxi; //signal took this smallest possible maximum time
	}
}


















