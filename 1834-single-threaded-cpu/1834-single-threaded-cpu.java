class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int sequence[]=new int[n];
        int taskList[][]=new int[n][3];
        for(int i=0;i<n;i++){
            taskList[i][1]=tasks[i][0];
            taskList[i][2]=tasks[i][1];
            taskList[i][0]=i;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->{
                if(taskList[a][2]==taskList[b][2]){
                    return Integer.compare(taskList[a][0],taskList[b][0]);
                }
                return Integer.compare(taskList[a][2],taskList[b][2]);
            }
        );
        Arrays.sort(taskList,(a,b)->a[1]-b[1]);
        int i=0;
        int currentTime=0;
        int index=0;
        while(i<tasks.length || !pq.isEmpty()){
            if(pq.isEmpty()){
                currentTime=Math.max(currentTime,taskList[i][1]);
            }
            while(i<n && taskList[i][1]<=currentTime){
                pq.offer(i);
                i++;
            }
            int t=pq.poll();
            sequence[index++]=taskList[t][0];
            currentTime+=taskList[t][2];
        }
        return sequence;
    }
}