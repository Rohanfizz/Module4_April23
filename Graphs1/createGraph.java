import java.util.*;

class createGraph {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); //number of nodes
    int e = scn.nextInt(); //number of edges

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());

    for (int i = 0; i < e; i++) {
      int u = scn.nextInt();
      int v = scn.nextInt();
      graph.get(u).add(v);
      graph.get(v).add(u);
      // [[3, 1], [2], [], [4, 2], []]
    //   [[3, 1], [2, 0], [1, 3], [0, 4, 2], [3]]
    }
    System.out.println(graph);
    scn.close();
  }
}
