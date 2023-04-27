import java.util.*;

public class Main {
	static class Pair{
		int node;
		int wt;
		Pair(int node,int wt){
			this.node = node;
			this.wt = wt;
		}
	}
  static int primMST(int graph[][], int V) {
    // your code here
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
		  return a.wt - b.wt;
	  });
	  pq.add(new Pair(0,0));
	  int  ans  = 0;
	  boolean[] vis = new boolean[V];

	  while(pq.size()>0){
		  Pair curr = pq.remove();
		  if(vis[curr.node]) continue;
		  vis[curr.node] = true;
		  ans+=curr.wt;
		  

		  for(int nbr =0;nbr<V;nbr++){//adj matrix
			  if(graph[curr.node][nbr] == 0) continue; //there is no edge between curr.node na  dnbr
			  if(vis[nbr]) continue;
			  int edgeWeight = graph[curr.node][nbr];
			  pq.add(new Pair(nbr,edgeWeight));
		  }
	  }
	  return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices = sc.nextInt(), edges = sc.nextInt();
    int[][] graph = new int[vertices][vertices];
    for (int i = 0; i < edges; i++) {
      int src = sc.nextInt(), dest = sc.nextInt(), dist = sc.nextInt();
      graph[src][dest] = dist;
      graph[dest][src] = dist;
    }
    sc.close();

    System.out.println(primMST(graph, vertices));
  }
}

	