class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int n:stones){
            pq.add(n);
        }
        int result=0;
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            int p=y-x;
            result+=p;
            pq.offer(p); 
        }
        return pq.isEmpty()?0:pq.peek();
    }
}