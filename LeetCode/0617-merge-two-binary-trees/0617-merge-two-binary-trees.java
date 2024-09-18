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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{root1, root2});
        
        while(!q.isEmpty()){
            TreeNode[] cur = q.poll();
            TreeNode t1 = cur[0];
            TreeNode t2 = cur[1];
            
            t1.val += t2.val;

            if(t1.left != null && t2.left != null){
                q.offer(new TreeNode[]{t1.left,t2.left});
            }else if(t1.left == null){
                t1.left = t2.left;
            }

            if(t1.right != null && t2.right != null){
                q.offer(new TreeNode[]{t1.right, t2.right});
            }else if(t1.right == null){
                t1.right = t2.right;
            }
        }

        return root1;
    }
}