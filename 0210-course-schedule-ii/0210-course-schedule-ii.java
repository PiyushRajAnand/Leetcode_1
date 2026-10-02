class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
        for(int pre[]:prerequisites){
            int p=pre[0];
            int c=pre[1];
            graph.get(p).add(c);
            indegree[c]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int nc=numCourses;
        int result[]=new int[numCourses];
        int count=0;
        while(!queue.isEmpty()){
            int h=queue.poll();
            result[--nc]=h;
            count++;
            for(int n:graph.get(h)){
                indegree[n]--;
                if(indegree[n]==0){
                    queue.offer(n);
                }
            }
        }
        if(count!=numCourses){
            return new int[0];
        }
        return result;
    }
}