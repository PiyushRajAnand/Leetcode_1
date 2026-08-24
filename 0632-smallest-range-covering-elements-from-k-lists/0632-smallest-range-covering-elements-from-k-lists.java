class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int currentMax=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            int val=nums.get(i).get(0);
            pq.offer(new int[]{val,i,0});
            currentMax=Math.max(currentMax,val);
        }
        int bestRange[]={0,Integer.MAX_VALUE};
        while(pq.size()==nums.size()){
            int curr[]=pq.poll();
            int val=curr[0];
            int listIndex=curr[1];
            int valIndex=curr[2];
            if(currentMax-val<bestRange[1]-bestRange[0]){
                bestRange=new int[]{val,currentMax};
            }
            if (valIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(valIndex + 1);
                pq.offer(new int[]{nextVal, listIndex, valIndex+ 1});
                currentMax = Math.max(currentMax, nextVal);
            }
        }
        return bestRange;
    }
}