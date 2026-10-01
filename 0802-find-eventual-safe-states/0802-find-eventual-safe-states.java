class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        int state[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(noCycle(i,graph,state)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean noCycle(int i,int[][] graph,int[] state){
        if(state[i]==2) return true;
        if(state[i]==1) return false;
        
        state[i]=1;
        for(int n:graph[i]){
            if(!noCycle(n,graph,state)){
                return false;
            }
        }
        state[i]=2;
        return true;
    }
}