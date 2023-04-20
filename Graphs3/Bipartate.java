import java.util.*;

class Solution {
   public class Pair{
	   int node;
	   int color;// == 1? blue, else == 2? red, else == 0 uncolored
	   Pair(int node,int color){
		   this.node = node;
		   this.color = color;
	   }
   }
    public int possibleBipartition(int n, int[][] edges) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<=n;i++) graph.add(new ArrayList<>()); //i<=n? to handle 1 based indexing

		for(int[] e: edges){
			int u = e[0];
			int v = e[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		Queue<Pair> q = new LinkedList<>();
		int[] visited = new int[n+1]; //initially all the indexes will have 0

		for(int i = 1;i<=n;i++){ //this loop helps us to apply bfs on every component
			if(visited[i] != 0) continue;
			q.add(new Pair(i,1));// color 1 with blue
			while(q.size()>0){
				Pair curr = q.remove();
	
				if(visited[curr.node] != 0) continue;
				visited[curr.node] = curr.color;
	
				int oppColor = curr.color == 1?2:1;
				
				for(int nbr: graph.get(curr.node)){
					if(visited[nbr] == 0){//when the nbr is colorless
						q.add(new Pair(nbr,oppColor));
					}else if(visited[nbr] == curr.color) return 0; //not bipartate when neigbour is having the same color as us
					else continue;//nbr is having oppColor already
				}
			}
		}
		
		return 1; //graph is bipartate and bfs stopped safely
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}