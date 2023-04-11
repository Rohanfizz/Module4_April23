import java.util.*;

class CreateBstFromInorder {

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

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int[] inorder = { 10, 20, 30, 40, 50, 60, 70, 80 };
    Node root = construct(inorder, 0, inorder.length - 1);
    display(root);
    scn.close();
  }
}
