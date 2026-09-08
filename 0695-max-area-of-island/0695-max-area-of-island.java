class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int ans=0;
         int n=grid.length;
         int m=grid[0].length;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j,n,m));
                }
            }
         }
         return ans;
    }
    public int dfs(int[][] grid,int sr,int sc,int n,int m){
        if(sr>=0 && sc>=0 && sc<m && sr<n && grid[sr][sc]==1 ){
            grid[sr][sc]=0;
            return 1+dfs(grid,sr,sc-1,n,m)+dfs(grid,sr,sc+1,n,m)+dfs(grid,sr+1,sc,n,m)+dfs(grid,sr-1,sc,n,m);
        }
        return 0;
    }
}