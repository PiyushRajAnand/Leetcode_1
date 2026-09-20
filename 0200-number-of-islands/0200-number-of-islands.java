class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    solve(grid,i,j,n,m);
                }
            }
        }
        return count;
    }
    public void solve(char[][] grid,int sr,int sc,int n,int m){
        if(sr<0 || sc<0 || sr>=n || sc>=m || grid[sr][sc]=='0'){
            return;
        }
        grid[sr][sc]='0';
        solve(grid,sr-1,sc,n,m);
        solve(grid,sr+1,sc,n,m);
        solve(grid,sr,sc-1,n,m);
        solve(grid,sr,sc+1,n,m);
    }
}