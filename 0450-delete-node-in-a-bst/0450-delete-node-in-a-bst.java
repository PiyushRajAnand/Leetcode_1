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
    public TreeNode minimum(TreeNode node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left!=null && root.right!=null){
                TreeNode node=root;
                TreeNode dt=minimum(node.right);
                node.val=dt.val;
                node.right=deleteNode(node.right,dt.val);
            }else if(root.left!=null){
                root=root.left;
            }else if(root.right!=null){
                root=root.right;
            }else{
                root=null;
            }
            
        }
        return root;
    }
}