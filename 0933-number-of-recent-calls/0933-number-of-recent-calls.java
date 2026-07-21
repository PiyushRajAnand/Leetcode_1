class RecentCounter {
    public int requests;
    Queue<Integer> queue=new LinkedList<>();
    public RecentCounter() {
        this.requests=0;
    }
    
    public int ping(int t) {
        queue.offer(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */