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
class BSTIterator {
    public TreeNode curr;
    public BSTIterator(TreeNode root) {
        this.curr = root;
    }
    
    public int next() {
        while(curr != null){
            if(curr.left == null){
                //pre
                //in
                int nextNodeinInorder = curr.val;
                curr = curr.right;
                return nextNodeinInorder;
            }else{
                TreeNode rmn = curr.left;
                while(rmn.right != null && rmn.right!=curr){
                    rmn = rmn.right;
                }

                if(rmn.right == curr){
                    //in
                    int nextNodeinInorder = curr.val;
                    rmn.right = null;
                    curr = curr.right;
                    return nextNodeinInorder;
                }else{
                    //pre
                    rmn.right = curr;
                    curr = curr.left;
                }
            }
        }
        return -1;
    }
    
    public boolean hasNext() {
        // return curr != null;
        return curr == null?false:true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */