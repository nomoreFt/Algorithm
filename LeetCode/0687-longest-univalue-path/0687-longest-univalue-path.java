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
    int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root){
                if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left != null && root.left.val == root.val){
            left += 1;
        }else {
            left = 0;
        }

        if(root.right != null && root.right.val == root.val){
            right += 1;
        }else{
            right = 0;
        }
        
        result = Math.max(result, left + right);

        return Math.max(left, right);
    }
}