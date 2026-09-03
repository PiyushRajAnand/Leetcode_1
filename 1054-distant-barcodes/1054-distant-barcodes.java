class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int n:barcodes){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        for(int x:hm.keySet()){
            pq.add(new int[]{x,hm.get(x)});
        }
        int index=0;
        int ans[]=new int[barcodes.length];
        while(!pq.isEmpty()){
            int a[]=pq.poll();
            while(a[1]-->0){
                ans[index]=a[0];
                index+=2;
                if(index>=barcodes.length){ index=1;}
            }
        }
        return ans;
    }
}   