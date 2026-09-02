class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int finalLen=0;
        for(int i=0;i<k;i++){
            while(finalLen<n && arr[finalLen][0]<=w){
                pq.offer(arr[finalLen][1]);
                finalLen++;
            }
            if(pq.isEmpty()){
                break;
            }
            w+=pq.poll();
        }
        return w;
    }
}