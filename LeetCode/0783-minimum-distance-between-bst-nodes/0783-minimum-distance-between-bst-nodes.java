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
    int minDiff = Integer.MAX_VALUE;
    int prev = -1;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) minDiffInBST(root.left);
        
        if(prev != -1) {
            minDiff = Math.min(minDiff, Math.abs(prev - root.val));
        }
        
        prev = root.val;
        
        if(root.right != null) minDiffInBST(root.right);

        return minDiff;
    }
}