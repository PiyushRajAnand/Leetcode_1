class Solution {
    public void dfs(int [][] image,int originalColor,int r,int c,int newColor){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length){
            return;
        }
        if(image[r][c]!=originalColor){
            return;
        }
        image[r][c]=newColor;
        dfs(image,originalColor,r+1,c,newColor);
        dfs(image,originalColor,r-1,c,newColor);
        dfs(image,originalColor,r,c+1,newColor);
        dfs(image,originalColor,r,c-1,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int originalColor=image[sr][sc];
       if(originalColor==color){
        return image;
       }
       dfs(image,originalColor,sr,sc,color);
       return image;
    }
    
}