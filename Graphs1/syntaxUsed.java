import java.util.*;

class syntaxUsed {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // int n = scn.nextInt();

    // int[] arr = new  int[n];
    // for(int i = 0;i<n;i++) arr[i]= scn.nextInt();

    // for(int x: arr){
    //     System.out.println(x);
    // }
    // ArrayList<Integer> arr = new ArrayList<>();
    // for (int i = 0; i < n; i++) arr.add(0);
    // for (int i = 0; i < n; i++) arr.set(i, scn.nextInt());
    // for (int x : arr) {
    //   System.out.println(x);
    // }
    ArrayList<Integer>[] arr = new ArrayList[2];
    for (int i = 0; i < 2; i++) arr[i] = new ArrayList<Integer>();
    //after the above 2 lines of code, arr will be an array having 2 empty arraylists
    arr[0].add(1);
    arr[0].add(2);
    arr[0].add(3);
    arr[0].add(4);

    arr[1].add(6);
    arr[1].add(7);
    arr[1].add(8);
    arr[1].add(9);

    for (int x : arr[1]) {
      System.out.println(x);
    }

    scn.close();
  }
}
