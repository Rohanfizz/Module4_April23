package BST2;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {

	class Helper{
		Node parent;
		int l;
		int r;
		Helper(Node parent,int l,int r){
			this.parent = parent;
			this.l = l;
			this.r =r;
		}
	}
	
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Node root = new Node(arr[0]);
		int idx = 1;

		Queue<Helper> q = new LinkedList<>();
		//left
		q.add( new Helper(root,Integer.MIN_VALUE,root.data-1));
		//right
		q.add(new Helper(root,root.data + 1,Integer.MAX_VALUE));

		//bfs
		while(q.size()>0){
			Helper curr  = q.remove();

			//if there are any more elements left
			if(idx == arr.length) continue;
			// if the element at idx is out of bounds of curr platform
			if(arr[idx] < curr.l || arr[idx]>curr.r) continue;

			//if im standing on this line of code, this means that im a valid
			// child for curr platform. Now i just need to check if im the left of right child of curr.parent
			Node me = new Node(arr[idx]);
			idx++;

			if(me.data < curr.parent.data){
				curr.parent.left = me;
			}else curr.parent.right = me;

			//i can also be potential parent, so for that ill need to add left and right platforms
			q.add(new Helper(me,curr.l,me.data-1));
			q.add(new Helper(me,me.data + 1,curr.r));
		}
		return root;
    }
}













