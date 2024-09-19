import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;
        
        // 입력이 있는 동안 트리를 생성
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            root = insert(root, val);
        } 
        
        // 후위 순회 출력
        postOrder(root);
    }
    
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        
        postOrder(root.left);
        postOrder(root.right);
        
        System.out.println(root.val);
    }
    
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    // 이진 트리 노드 클래스
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
