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
    int postOrderIndex;
    HashMap<Integer,Integer> inorderTrack=new HashMap<>();
    public TreeNode build(int[] postorder,int left,int right){
        if(left>right){
            return null;
        }
        int value=postorder[postOrderIndex--];
        TreeNode node=new TreeNode(value);
        int mid=inorderTrack.get(value);
        node.right=build(postorder,mid+1,right);
        node.left=build(postorder,left,mid-1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            inorderTrack.put(inorder[i],i);
        }
        return build(postorder,0,postorder.length-1);
    }
}