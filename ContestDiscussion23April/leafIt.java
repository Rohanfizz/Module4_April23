import java.util.*;
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            Solution solution = new Solution();
            System.out.println(solution.leafIt(root));
    }
    
    public static Node insert(Node root, int x)
    {
        
        if(root == null)
          {
              return (new Node(x));
          }
          
          if(x < root.data)
          {
              root.left = insert(root.left, x);
          }
          else if(x >= root.data)
          {
              root.right = insert(root.right, x);
          }
          
      return root;      
    }
    
}
class Solution
	{
		//https://course.acciojob.com/idle?question=27f200f6-90cd-4bd2-94a7-3cc25ded8048
    public static int leafIt(Node root){
        if(root == null) return 0;
		if(root.left == null && root.right == null) return root.data;
		return leafIt(root.left) + leafIt(root.right);
    }
}







