/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    public Node connect(Node root) {
        // if(root==null){
        //     return root;
        // }
        // Queue<Node> queue=new LinkedList<>();
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     Node right=null;
        //     for(int i=queue.size();i>0;i--){
        //         Node curr=queue.poll();
        //         curr.next=right;
        //         right=curr; //Give me set the current pointer
        //         if(curr.right!=null){
        //             queue.offer(curr.right);
        //             queue.offer(curr.left);
        //         }
        //     }
        // }
        // return root;

        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left.next=root.right;
            if(root.next!=null){
                root.right.next=root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);

        return root;
    }
}