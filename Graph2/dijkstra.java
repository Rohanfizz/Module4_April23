import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

	public static class Pair{
		int node;
		int wsf;
		String psf;
		Pair(int  node,int wsf,String psf){
			this.node = node;
			this.wsf = wsf;
			this.psf = psf;
		}
	}
	
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int S){
     // Write your code here
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
		  return a.wsf-b.wsf;
	  });//default is mintype
	  
	  pq.add(new Pair(S,0,""+S));

	  boolean[] visited = new boolean[V];
	  
	int[] res  = new int[V];
	  for(int i = 0;i<V;i++) res[i] = -1;
	  
	  while(pq.size()>0){
		  //remove
		  Pair  curr = pq.remove();
		  int node = curr.node;
		  int wsf = curr.wsf;
		  String psf = curr.psf;

		  //mark
		  if(visited[node]) continue;
		  visited[node] = true;

		  //work
		  // System.out.println(psf+" @ "+wsf);
		  res[node] = wsf;

		  //add unvisited neighbours to the queue
		  for(ArrayList<Integer> e: graph.get(node)){ //inner e = {src,nbr,wt}
			  int nbr = e.get(0); 
			  int wt = e.get(1);
			  if(!visited[nbr]) pq.add(new Pair(nbr,wsf+wt,psf+nbr));
		  }
	  }
	  
       return res;
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
