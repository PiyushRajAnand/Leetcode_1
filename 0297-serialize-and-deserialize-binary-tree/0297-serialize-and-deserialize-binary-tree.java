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
    public void buildString(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left,sb);
        buildString(root.right,sb);
    }
    public TreeNode buildTree(Deque<String> deque){
        String value=deque.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(value));
        node.left=buildTree(deque);
        node.right=buildTree(deque);
        return node;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue=new ArrayDeque<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));