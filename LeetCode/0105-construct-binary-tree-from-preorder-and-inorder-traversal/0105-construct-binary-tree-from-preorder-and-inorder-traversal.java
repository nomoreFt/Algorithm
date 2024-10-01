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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer>inOrder = new ArrayList<>();

        for(int pre : preorder) preOrder.add(pre);
        for(int in : inorder) inOrder.add(in);

        return dfs(preOrder, inOrder);
    }
    
    public TreeNode dfs(List<Integer> preOrder, List<Integer> inOrder){
        if(inOrder.isEmpty()) return null;
        
        int inIndex = inOrder.indexOf(preOrder.get(0));
        
        TreeNode node = new TreeNode(inOrder.get(inIndex));

        node.left = dfs(preOrder.subList(1, inIndex + 1), inOrder.subList(0, inIndex));
        node.right = dfs(preOrder.subList(inIndex + 1, preOrder.size()),inOrder.subList(inIndex + 1, inOrder.size()));

        return node;
    }
}