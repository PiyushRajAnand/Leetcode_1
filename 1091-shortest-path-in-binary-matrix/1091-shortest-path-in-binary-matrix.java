class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0][0]!=0){
            return -1;
        }
        int r=grid.length;
        int c=grid[0].length;
        if(r==1 && c==1){
            return 1;
        }
        boolean isVisited[][]=new boolean[r][c];
        int directions[][]={{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        Queue<int[]> queue=new LinkedList<>();
        isVisited[0][0]=true;
        queue.add(new int[]{0,0,1});
        while(!queue.isEmpty()){
            int curr[]=queue.poll();
            for(int[] dir:directions){
                int sr=curr[0]+dir[0];
                int sc=curr[1]+dir[1];
                if(sr>=0 && sc>=0 && sr<r && sc<c && isVisited[sr][sc]==false && grid[sr][sc]==0){
                    if(sr==r-1 && sc==c-1){
                        return curr[2]+1;
                    }
                    int newDistance=curr[2]+1;
                    isVisited[sr][sc]=true;
                    queue.add(new int[]{sr,sc,newDistance});
                }
            }

        }
        return -1;
    }
}