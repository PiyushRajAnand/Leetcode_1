class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        long totalSpeed=0;
        long ans=0;
        for(int i=0;i<n;i++){
            totalSpeed+=arr[i][0];
            pq.offer(arr[i][0]);
            if(pq.size()>k){
                totalSpeed-=pq.poll();
            }
            ans=Math.max(ans,totalSpeed*arr[i][1]);
        }
        return (int)(ans%(1_000_000_007));
    }
}