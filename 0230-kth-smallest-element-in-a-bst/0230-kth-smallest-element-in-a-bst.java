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
    int kn=0;
    int count=0;
    public void kthSmallesT(TreeNode root, int k) {
        if(root==null){
            return;
        }
        kthSmallesT(root.left,k);
        
        count++;
        if(count==k){
            kn=root.val;
        }
        
        kthSmallesT(root.right,k);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        kthSmallesT(root,k);
        return kn;
    }
}