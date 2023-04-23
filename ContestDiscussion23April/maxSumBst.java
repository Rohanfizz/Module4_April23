import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
//https://course.acciojob.com/idle?question=504e980e-fbca-4776-9612-7c0d4dd7cc2c
class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution g = new Solution();
        sc.close();
        int ans = g.maxSumBST(root);
        System.out.print(ans);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
	public class Helper{
		boolean isBst;
		int maxi;
		int mini;
		int sum;
		int maxSum;
		Helper(boolean isBst,int maxi,int mini,int sum,int maxSum){
			this.isBst = isBst;
			this.maxi = maxi;
			this.mini =mini;
			this.sum = sum;
			this.maxSum = maxSum;
		}
	}
	public Helper solve(Node root){
		if(root == null) return new Helper(true,Integer.MIN_VALUE,Integer.MAX_VALUE,0,0);
		Helper left = solve(root.left);
		Helper right = solve(root.right);
		boolean amBst = left.isBst && right.isBst && root.data > left.maxi && root.data < right.mini;
		if(amBst){
			//the case where i am bst
			int myMax = Math.max(root.data,right.maxi);//Math.max for handling leaf nodes
			int myMin = Math.min(root.data,left.mini);
			int sum = root.data + left.sum + right.sum;//sum of bst formed by me
			int maxSum = Math.max( sum , Math.max( left.maxSum , right.maxSum ) ); // overall max sum bst formed under and including me
			return new Helper(true,myMax,myMin,sum,maxSum);
		}
		//if i am not  bst, i dont care what myMax myMin will be.
		//my sum also does'nt matter as im not a bst
		//i will only consider my left.maxSum, right.maxSum
		return new Helper(false,0,0,0,Math.max(left.maxSum,right.maxSum));
	}
    public int maxSumBST(Node root) {
        // Your code here
		return solve(root).maxSum;
    }
}













