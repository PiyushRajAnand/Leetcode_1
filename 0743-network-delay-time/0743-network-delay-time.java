class GraphNode{
    int index;
    int distance;
    ArrayList<int[]> neighbours;
    GraphNode(int index){
        this.index=index;
        this.distance=Integer.MAX_VALUE;
        this.neighbours=new ArrayList<>();
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       GraphNode graph[]=new GraphNode[n+1];
       for(int i=1;i<=n;i++){
        graph[i]=new GraphNode(i);
       }
       for(int time[]:times){
        int u=time[0];
        int v=time[1];
        int d=time[2];
        graph[u].neighbours.add(new int[]{v,d});
       }
       PriorityQueue<GraphNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));
       graph[k].distance=0;
       pq.offer(graph[k]);
       while(!pq.isEmpty()){
        GraphNode curr=pq.poll();
        for(int[] neigh:curr.neighbours){
            int v=neigh[0];
            int d=neigh[1];
            int distNew=curr.distance+d;
            if(distNew<graph[v].distance){
                graph[v].distance=distNew;
                pq.offer(graph[v]);
            }
        } 
       }
       for(int i=1;i<=n;i++){
        if(graph[i].distance==Integer.MAX_VALUE){
             return -1;
        }
       }
       int sig=0;
       for(int i=1;i<=n;i++){
           sig=Math.max(sig,graph[i].distance);
       }
       return sig;
    }
}
