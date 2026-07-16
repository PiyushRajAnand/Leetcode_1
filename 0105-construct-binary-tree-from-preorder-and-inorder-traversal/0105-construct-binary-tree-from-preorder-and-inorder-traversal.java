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
    int preOrderIndex=0;
    HashMap<Integer,Integer> inorderTrack=new HashMap<>();
    public TreeNode build(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int value=preorder[preOrderIndex++];
        TreeNode node=new TreeNode(value);
        int mid=inorderTrack.get(value);
        node.left=build(preorder,left,mid-1);
        node.right=build(preorder,mid+1,right);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderTrack.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1);
    }
}