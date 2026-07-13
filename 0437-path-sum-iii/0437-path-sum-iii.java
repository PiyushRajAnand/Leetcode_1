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
    int ans=0;
    HashMap<Long,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        map.put(0L,1);
        pathSumFrom(root,0,map,sum);
        return ans;
    }
    
    private void pathSumFrom(TreeNode node, long sum,HashMap<Long,Integer> map,int target) {
        if(node==null){
            return;
        }
        sum+=node.val;
        ans+=map.getOrDefault(sum-target,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        pathSumFrom(node.left,sum,map,target);
        pathSumFrom(node.right,sum,map,target);
        map.put(sum,map.get(sum)-1);
    }
}