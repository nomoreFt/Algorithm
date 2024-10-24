import java.io.*;
import java.util.*;

class Main {
    static int K;
    static int[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        s = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        //중위 순회 트리 복원
        TreeNode root = dfs(0, s.length - 1);
        //bfs 큐로 K Depth까지 노드 출력
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty() && depth < K){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            System.out.println();
            depth++;
        }
    }
    static TreeNode dfs(int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(s[mid]);
        node.left = dfs(start, mid - 1);
        node.right = dfs(mid + 1, end);

        return node;
    }

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
}