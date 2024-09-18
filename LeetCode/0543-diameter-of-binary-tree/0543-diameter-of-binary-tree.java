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
public class Solution {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        // 왼쪽 자식에서의 최대 깊이
        int leftDepth = dfs(node.left);
        // 오른쪽 자식에서의 최대 깊이
        int rightDepth = dfs(node.right);
        
        // 현재 노드를 루트로 하는 경로의 길이 갱신
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        // 현재 노드에서의 최대 깊이 반환
        return Math.max(leftDepth, rightDepth) + 1;
    }
}