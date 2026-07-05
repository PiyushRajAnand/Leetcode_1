class Node{
    int key,value;
    Node next,prev;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    public int capacity;
    public Map<Integer,Node> map;
    public Node head,tail;
    LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insertFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insertFront(node);
        }else{
            if(map.size()==capacity){
                Node last=tail.prev;
                remove(last);
                map.remove(last.key);
            }
            Node node=new Node(key,value);
            map.put(key,node);
            insertFront(node);
        }
    }
    public void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public void insertFront(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */