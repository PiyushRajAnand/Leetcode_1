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
    TreeNode ans=null;
    public void searchBst(TreeNode root, int val){
        if(root==null){
            return;
        }
        if(val==root.val){
            ans=root;
        }
        if(val<=root.val){
            searchBst(root.left,val);
        }else{
            searchBst(root.right,val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        searchBst(root,val);
        return ans;
    }
}