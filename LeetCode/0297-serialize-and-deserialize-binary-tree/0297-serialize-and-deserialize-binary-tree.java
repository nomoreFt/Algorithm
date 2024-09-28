/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            
            if(cur.left != null){
                sb.append("," + cur.left.val);
                q.add(cur.left);
            }else sb.append("," +null);
            
            if(cur.right != null){
                sb.append("," + cur.right.val);
                q.offer(cur.right);
            }else sb.append("," + null);
        }

System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            String str = nodes[idx++];
            
            if(str.equals("null")) continue;
            cur.left = new TreeNode(Integer.parseInt(str));
            q.add(cur.left);

            str = nodes[idx];
            if(str.equals("null")) continue;
            cur.right = new TreeNode(Integer.parseInt(str));
            q.add(cur.right);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));