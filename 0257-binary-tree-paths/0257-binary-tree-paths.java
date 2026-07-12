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
    public void create(List<String> sl,TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        int len=sb.length();
        if(root.left==null && root.right==null){
            sb.append(root.val);
            sl.add(sb.toString());
        }
        sb.append(root.val);
        sb.append("->");
        
        create(sl,root.left,sb);
        create(sl,root.right,sb);
        sb.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        List<String> sl=new ArrayList<>();
        create(sl,root,sb);
        return sl;
    }
}