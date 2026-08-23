class MedianFinder {
    public PriorityQueue<Integer> left;
    public PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left=new PriorityQueue<>((a,b)->b-a);
        this.right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num<=left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }
        if(left.size()>right.size()+1){
            right.offer(left.poll());
        }
        if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */