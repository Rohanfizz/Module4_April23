import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] graph;
 
    Graph(int v) {
        this.vertices = v;
        graph = new ArrayList[v];
        
        for (int i = 0; i < v; i++) graph[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) {
        graph[v].add(w);
     
    }
 
    void BFS(int x) {
        // your code here
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		boolean[] visited  = new boolean[this.vertices];
		while(q.size()>0){
			int front = q.remove();
			//mark
			if(visited[front]) continue; //to prevent cycles
			visited[front] = true;
			//work
			System.out.print(front+" ");
			//add all the unvisited neighbours
			for(int nbr:graph[front]){
				if(!visited[nbr]) q.add(nbr);
			}
		}
    }
}
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
