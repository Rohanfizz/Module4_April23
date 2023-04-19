import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

	public static void dfs(ArrayList<Edge>[] graph,boolean[] path,int s,int d,String psf){
		if(s == d){
			//we have reached the destination
			System.out.println(psf);
			return;
		}

		path[s] = true;

		for(Edge e: graph[s]){
			int nbr = e.nbr;
			if(!path[nbr]) dfs(graph,path,nbr,d,psf+nbr);
		}
		path[s] = false;
	}
	
   public static void printAllPath(ArrayList<Edge>[]graph , int src , int dest , int n){ 
      //Your code here
	   boolean[] path  = new boolean[n];
	   dfs(graph,path,src,dest,""+src);
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      printAllPath(graph,src,dest,vtces);
   }


}