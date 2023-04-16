import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }
        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        int ans=A.medianMarks(root);
        System.out.println(ans);
    }
}

class Solution
{ 
	public static int sz(Node root){
		return root == null? 0 : sz(root.left) + sz(root.right) + 1;
	}
	public static class Pair{
		int state;
		Node node;
		Pair(Node node,int state){
			this.state = state;
			this.node = node;
		}
	}
	public static Node getNextInorder(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//inorder
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else{
				//post
				st.pop();
			}
		}
		return null;
	}
    public static int medianMarks(Node root){
        //Your code here
		int n = sz(root);
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root,1));
		if(n % 2 == 1){//odd?
			int idx = (n+1)/2;
			Node curr = null;
			while(idx > 0){
				curr = getNextInorder(st);
				idx--;
			}
			return curr.data;
		}else{//even
			int currIdx = (n/2)+1;
			Node curr = null;
			Node prev = null;
			while(currIdx > 0){
				prev = curr;
				curr = getNextInorder(st);
				currIdx--;
			}
			return (prev.data + curr.data)/2;
		}
		
    }
}










// https://course.acciojob.com/idle?question=fae6db56-4eea-43cb-adfe-5df110ce2a6a





