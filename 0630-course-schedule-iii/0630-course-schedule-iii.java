class Solution {
    public int scheduleCourse(int[][] courses) {
        int startTime=0;
        int courseTaken=0;
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<courses.length;i++){
            startTime+=courses[i][0];
            pq.offer(courses[i][0]);
            if(startTime>courses[i][1]){
                startTime-=pq.poll();
            }
        }
        return pq.size();
    }
}