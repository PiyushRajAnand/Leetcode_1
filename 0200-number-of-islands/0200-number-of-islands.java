class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean isVisited[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isVisited[i][j]==false && grid[i][j]=='1'){
                    count++;
                    solve(grid,isVisited,i,j,n,m);
                }
            }
        }
        return count;
    }
    public void solve(char[][] grid,boolean[][] isVisited,int sr,int sc,int n,int m){
        Queue<int[]> queue=new LinkedList<>();
        isVisited[sr][sc]=true;
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int curr[]=queue.poll();
            int directions[][]={{0,-1},{0,1},{1,0},{-1,0}};
            for(int[] dir:directions){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r>=0 && c>=0 && r<n && c<m && isVisited[r][c]==false && grid[r][c]=='1'){
                    isVisited[r][c]=true;
                    queue.add(new int[]{r,c});
                }
            }
        }
    }
}