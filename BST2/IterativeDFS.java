import java.util.*;

class IterativeDFS {

  public static class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static Node construct(int[] arr, int l, int r) {
    if (l > r) return null;

    int mid = (l + r) / 2;
    Node me = new Node(arr[mid]);
    me.left = construct(arr, l, mid - 1);
    me.right = construct(arr, mid + 1, r);
    return me;
  }

  public static void display(Node root) {
    if (root == null) return;

    System.out.print((root.left == null ? "-1" : root.left.val) + " -> ");
    System.out.print(root.val);
    System.out.print(" <- " + (root.right == null ? "-1" : root.right.val));
    System.out.println();

    display(root.left);
    display(root.right);
  }

  public static class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node= node;
        this.state = state;
    }
  }

  public static void iterativeDFS(Node root){
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root,1));
    ArrayList<Integer>  pre= new ArrayList<>();
    ArrayList<Integer>  in= new ArrayList<>();
    ArrayList<Integer>  post= new ArrayList<>();

    while(st.size()>0){
        Pair top = st.peek();
        if(top.state == 1){
            //first time = pre  order
            pre.add(top.node.val);
            top.state++;
            if(top.node.left != null) st.push(new Pair(top.node.left,1));
        }else if(top.state == 2){
            in.add(top.node.val);
            top.state++;
            if(top.node.right != null) st.push(new Pair(top.node.right,1));
        }else{
            post.add(top.node.val);
            st.pop();
        }
    }

    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int[] inorder = { 10, 20, 30, 40, 50, 60, 70, 80 };
    Node root = construct(inorder, 0, inorder.length - 1);
    // display(root);
    iterativeDFS(root);
    scn.close();
  }
}
