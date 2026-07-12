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
    int sum=0;
    public void helper(TreeNode root,int value){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            value=value*10+root.val;
            sum+=value;
        }
        value=value*10+root.val;
        helper(root.left,value);
        helper(root.right,value);
    }
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
}