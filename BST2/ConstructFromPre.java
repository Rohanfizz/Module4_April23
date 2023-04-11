package BST2;
import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
	public static int idx;

	public static TreeNode construct(int[] pre,int l,int r){
		//check for range
		if(idx == pre.length) return null;
		if(pre[idx] < l || pre[idx] > r) return null;

		//place a node
		TreeNode me = new TreeNode(pre[idx]);
		//increment index
		idx++;
		//attach left
		me.left = construct(pre,l,me.val-1);
		//attach right
		me.right = construct(pre,me.val+1,r);
		return me;
	}
    public static TreeNode CreateTree(int n,int[] preOrder) {
        // Write Your Code here
		idx = 0;
		return construct(preOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}