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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean rightToLeft=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ll=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.remove();
                if(rightToLeft){
                   ll.addLast(curr.val);
                }else{
                    ll.addFirst(curr.val);
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
                
            }
            rightToLeft=(!rightToLeft);
            list.add(ll);
        }
        return list;
    }
}