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
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root,(long) sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, long sum) {
        if(node==null){
            return 0;
        }
        int ans=0;
        if(node.val==sum){
            ans++;
        }
        ans+=pathSumFrom(node.left,sum-node.val);
        ans+=pathSumFrom(node.right,sum-node.val);
        return ans;
    }
}