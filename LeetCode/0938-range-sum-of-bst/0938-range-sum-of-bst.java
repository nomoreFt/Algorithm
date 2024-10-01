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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        // 현재 노드의 값이 high보다 크면 왼쪽 서브트리만 탐색
        if (root.val > high) return rangeSumBST(root.left, low, high);
        
        // 현재 노드의 값이 low보다 작으면 오른쪽 서브트리만 탐색
        if (root.val < low) return rangeSumBST(root.right, low, high);

        // 현재 노드의 값이 범위 내에 있다면, 현재 노드의 값과 좌우 서브트리의 값을 합산
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
    
}