import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean dfs(int node,boolean[] path,ArrayList<Integer> psf,ArrayList<ArrayList<Integer>> graph){

		path[node]=  true;
		psf.add(node);

		int N = graph.size()-1; //number of nodes, doing -1 because we have index 0 which we do not require
		if(psf.size() == N){
			//this is hamiltonian path, as it is having all the nodes
			// int os = psf.get(0);
			// System.out.print(psf);

			// for(int nbr: graph.get(node)){
			// 	if(nbr == os){
			// 		System.out.print(" Cycle");
			// 		break;
			// 	}
			// }
			// System.out.println();
			psf.remove(psf.size()-1);
			path[node] = false;
			return true;
		}
		
		for(int nbr: graph.get(node)){
			if(!path[nbr]){
				boolean found = dfs(nbr,path,psf,graph);
				if(found) return true;
			}
		}
		path[node] = false;
		psf.remove(psf.size()-1);
		return false;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> edges) {
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<=N;i++){//we will not be using the zeroth arrayList
			//testcases are 1 based indexed
			graph.add(new ArrayList<>());
		}

		for(ArrayList<Integer> edge: edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] path = new boolean[N+1];//1 based indexeing
		ArrayList<Integer> psf = new ArrayList<>();
		
		for(int i = 1;i<=N;i++){
			boolean found =dfs(i,path,psf,graph);
			if(found == true) return true;
		}
		return false; 
    }
}
















