class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] p:prerequisites){
            graph.get(p[0]).add(p[1]);
        }
        int state[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(hasCycle(i,graph,state)){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int i,List<List<Integer>> graph,int[] state){
        if(state[i]==2) return false;
        if(state[i]==1) return true;
        state[i]=1;
        for(int neigh:graph.get(i)){
            // if(state[neigh]==1){ return true; }
            if(hasCycle(neigh,graph,state)){
                return true;
            }
        }
        state[i]=2;
        return false;
    }
}