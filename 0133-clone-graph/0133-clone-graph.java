/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node origin=new Node(node.val);
        HashMap<Node,Node> hm=new HashMap<>();
        hm.put(node,origin);
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            for(Node neighbour:curr.neighbors){
                if(!hm.containsKey(neighbour)){
                    Node n=new Node(neighbour.val);
                    queue.add(neighbour);
                    hm.put(neighbour,n);
                }
                hm.get(curr).neighbors.add(hm.get(neighbour));
            }
        }
        return origin;
    }
}