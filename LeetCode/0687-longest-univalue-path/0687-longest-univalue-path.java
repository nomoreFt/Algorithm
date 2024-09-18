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
    int longest = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        
        dfs(root);
        return longest;
    }
    public int dfs(TreeNode node){
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(node.left != null && node.left.val == node.val) left++;
        else left = 0;
        
        if(node.right != null && node.right.val == node.val) right++;
        else right = 0;

        this.longest = Math.max(this.longest, left + right);
        return Math.max(left, right);


    }
}