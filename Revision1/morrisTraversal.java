/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr  = root;
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        while(curr != null){
            if(curr.left == null){
                //special condition
                pre.add(curr.val);
                in.add(curr.val);
                curr = curr.right;
            }else{
                //i have to detect if im being visited for the
                //first time or second time
                //if link is not present = first time
                //else second time
                //i have to detect whether there is a link or not

                TreeNode rmn = curr.left;
                while(rmn.right !=null && rmn.right !=curr){
                    rmn = rmn.right;
                }
                //if the rmn.right == curr, link was there
                if(rmn.right == curr){
                    //second time as linkwas there
                    in.add(curr.val); //inorder work
                    rmn.right = null;//demolishing the link
                    curr = curr.right;//going to the right subtree
                }else{
                    //if link was not there, or rmn.right == null = first time
                    pre.add(curr.val);//preorder work
                    rmn.right = curr;//establishing the link
                    curr = curr.left;//going to the left subtree after pre work
                }
            }
        }
        // System.out.println(pre);
        // System.out.println(in);

        return pre;

    }
}















