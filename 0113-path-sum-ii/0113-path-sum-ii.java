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
    public void getAnswer(List<List<Integer>> list,List<Integer> res,int targetSum,TreeNode node){
        if(node==null){
            return;
        }
        res.add(node.val);
        targetSum-=node.val;
        if(node.left==null && node.right==null && targetSum==0){
            list.add(new ArrayList<>(res));
        }
        getAnswer(list,res,targetSum,node.left);
        getAnswer(list,res,targetSum,node.right);
        res.remove(res.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        getAnswer(list,res,targetSum,root);
        return list;
        }
}