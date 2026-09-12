class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean isVisited[]=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                provinces++;
                dfs(i,isConnected,isVisited);
            }
        }
        return provinces;
    }
    public void dfs(int city,int[][] isConnected,boolean[] isVisited){
        isVisited[city]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[city][j]==1 && !isVisited[j]){
                dfs(j,isConnected,isVisited);
            }
        }
    } 
}