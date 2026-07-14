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
    public TreeNode insertBST(TreeNode root,int val){
        if(root==null){
            TreeNode newNode=new TreeNode(val);
            return newNode;
        }else if(root.val>=val){
            root.left=insertBST(root.left,val);
        }else{
            root.right=insertBST(root.right,val);
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root=insertBST(root,val);
        return root;
    }
}