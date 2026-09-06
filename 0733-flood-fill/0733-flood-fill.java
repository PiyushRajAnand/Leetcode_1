class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean isVisited[][]=new boolean[image.length][image[0].length];
        int originColor=image[sr][sc];
        int newColor=color;
        image[sr][sc]=color;
        isVisited[sr][sc]=true;
        checkFills(originColor,sr,sc,newColor,image,isVisited);
        return image;
    }
    public void checkFills(int originColor,int csr,int csc,int newColor,int[][] image,boolean[][] isVisited){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{csr,csc});
        while(!queue.isEmpty()){
            int curr[]=queue.poll();
            int direction[][]={{1,0},{-1,0},{0,-1},{0,1}};
            for(int[] dir:direction){
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r>=0 && c>=0 && r<image.length && c<image[0].length && image[r][c]==originColor && isVisited[r][c]==false ){
                    isVisited[r][c]=true;
                    image[r][c]=newColor;
                    queue.add(new int[]{r,c});
                }
            }
        }
    }
}