class Solution {
    public int orangesRotting(int[][] grid) {
       int freshOranges=0;
       int minutes=-1;
       Queue<int[]> queue=new LinkedList<>();
       int n=grid.length;
       int m=grid[0].length;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                queue.offer(new int[]{i,j});
            }else if(grid[i][j]==1){
                freshOranges++;
            }
        }
       }
       
       if(freshOranges==0){
        return 0;
       }
       if(queue.isEmpty()){
        return -1;
       }
       while(!queue.isEmpty()){
        int size=queue.size();
        while(size-- > 0){
           int curr[]=queue.poll();
           int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
           for(int[] dir:directions){
            int nr=curr[0]+dir[0];
            int nc=curr[1]+dir[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                grid[nr][nc]=2;
                queue.offer(new int[]{nr,nc});
                freshOranges--;
            }
           }
        }
        minutes++;
       }
       if(freshOranges==0){
        return minutes;
       }
       return -1;
    }
    
}