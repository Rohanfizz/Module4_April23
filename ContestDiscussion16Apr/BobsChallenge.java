import java.util.*;

class Node {

  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

class BinarySearchTree {

  Node constructBST(int[] arr, int start, int end, Node root) {
    if (start > end) return null;
    int mid = (start + end) / 2;

    if (root == null) root = new Node(arr[mid]);

    root.left = constructBST(arr, start, mid - 1, root.left);
    root.right = constructBST(arr, mid + 1, end, root.right);

    return root;
  }
}

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    Node root = null;
    BinarySearchTree bst = new BinarySearchTree();
    root = bst.constructBST(arr, 0, n - 1, root);
    Solution A = new Solution();
    int ans = A.BobsChallenge(root, k);
    System.out.println(ans);
  }
}

class Solution {

  class Pair {

    int state;
    Node node;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  Node getNextRevInorder(Stack<Pair> st) {
    while (st.size() > 0) {
      Pair curr = st.peek();
      if (curr.state == 1) {
        //we are travelling to right here because we want reverse inorder
        curr.state++;
        if (curr.node.right != null) st.push(new Pair(curr.node.right, 1));
      } else if (curr.state == 2) {
        //inorder
        curr.state++;
        if (curr.node.left != null) st.push(new Pair(curr.node.left, 1));
        return curr.node;
      } else {
        st.pop();
      }
    }
    return null; // dummy return
  }

  int BobsChallenge(Node root, int k) {
    //Your code
    // TC:O(N)
    // SC:O(logN) / O(H)
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root, 1));
    Node curr = null;
    while (k > 0) {
      curr = getNextRevInorder(st);
      k--;
    }
    return curr.data;
  }
}
// https://course.acciojob.com/idle?question=0a5267c8-7d83-4235-8f07-024fa0f99396
